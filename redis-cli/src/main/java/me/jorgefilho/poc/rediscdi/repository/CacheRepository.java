package me.jorgefilho.poc.rediscdi.repository;

import java.io.Serializable;

public interface CacheRepository extends Serializable {

	String setex(String key, int timeToReload, String json);

	String get(String string);

	Long del(String key);
}
