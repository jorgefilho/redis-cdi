package me.jorgefilho.poc.rediscdi.interceptor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.jorgefilho.poc.rediscdi.annotation.Cached;
import me.jorgefilho.poc.rediscdi.domain.Envelope;
import me.jorgefilho.poc.rediscdi.repository.CacheRepository;
import me.jorgefilho.poc.rediscdi.util.ClassTypeAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.exceptions.JedisConnectionException;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

@Interceptor
@Cached
public class CachingInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(CachingInterceptor.class);

    private Gson gson;
	
	@Inject
	private CacheRepository cacheRepository;

	public CachingInterceptor() {
		gson = new GsonBuilder().registerTypeAdapter(Class.class, new ClassTypeAdapter()).create();
	}

	@AroundInvoke
	public Object perform(final InvocationContext ctx) throws Exception {
		
		final Object objectToReturn = getReturnOfCache(ctx);
 
		return objectToReturn;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object getReturnOfCache(final InvocationContext ctx) throws Exception {
		Object objectToReturn = null;

		try{
			
			final String key = getKey(ctx.getMethod(), ctx.getParameters());
			final String json = cacheRepository.get(key);
			
			if (json == null) {
				objectToReturn = ctx.proceed();
				
				final int timeToExpire = getTime(ctx.getMethod());
				final Envelope envelope = new Envelope(gson.toJson(objectToReturn), objectToReturn.getClass());
	
				final String statusCode = cacheRepository.setex(key,timeToExpire, gson.toJson(envelope));
				
				if (!statusCode.equals("OK")){
					LOGGER.warn("Problems in recording cache - status code {}", statusCode);
				}
			} else {
				final Envelope envelope = gson.fromJson(json, Envelope.class);
				final Class type = envelope.getTypeOfJson();
				
				objectToReturn = gson.fromJson(envelope.getJson(), type);
				
				if (objectToReturn == null) {
					objectToReturn = ctx.proceed();
					LOGGER.warn("Problems whith the object type - Type Envelop {}", type);
				}
			} 
		} catch (Exception e){
			LOGGER.error("*** Redis is out - {}", e.getMessage());
			objectToReturn = ctx.proceed();
		} 
		return objectToReturn;
	}

	private int getTime(Method method) {
		Cached enableCaching = method.getAnnotation(Cached.class);
		
		if (enableCaching == null) {
			enableCaching = method.getDeclaringClass().getAnnotation(Cached.class);
		}
		final int timeToExpire =  enableCaching.expireInSeconds();
		
		return timeToExpire;
	}

	private String getKey(Method method, Object[] parameters) {
		final String parametersInLineCustom = Arrays.toString(parameters).replace(" ", "").replace("null", "");
		
		final String key = method.getDeclaringClass().getSimpleName() + method.getName() + parametersInLineCustom;
		
		return key;
	}
}
