package me.jorgefilho.poc.rediscdi.domain;

import java.io.Serializable;

public class Envelope implements Serializable {

	private static final long serialVersionUID = 1L;

	private String json;

	private Class<?> typeOfJson;

	public Envelope() {
	}

	public Envelope(final String json, final Class<?> typeOfJson) {
		this.json = json;
		this.typeOfJson = typeOfJson;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public Class<?> getTypeOfJson() {
		return typeOfJson;
	}

	public void setTypeOfJson(Class<?> typeOfJson) {
		this.typeOfJson = typeOfJson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((json == null) ? 0 : json.hashCode());
		result = prime * result + ((typeOfJson == null) ? 0 : typeOfJson.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Envelope other = (Envelope) obj;
		if (json == null) {
			if (other.json != null)
				return false;
		} else if (!json.equals(other.json))
			return false;
		if (typeOfJson == null) {
			if (other.typeOfJson != null)
				return false;
		} else if (!typeOfJson.equals(other.typeOfJson))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Envelope [json=" + json + ", typeOfJson=" + typeOfJson + "]";
	}
}
