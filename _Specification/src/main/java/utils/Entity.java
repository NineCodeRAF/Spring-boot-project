package utils;

import java.util.HashMap;
import java.util.Map;

public class Entity {

	private int id;
	private String naziv;

	private Map<String, String> simpleProperties;
	private Map<String, Entity> entityProperties;

	public Entity() {
		simpleProperties = new HashMap<String, String>();
		entityProperties = new HashMap<String, Entity>();
	}

	public Entity(int id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
		simpleProperties = new HashMap<String, String>();
		entityProperties = new HashMap<String, Entity>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Map<String, String> getSimpleProperties() {
		return simpleProperties;
	}

	public void setSimpleProperties(Map<String, String> simpleProperties) {
		this.simpleProperties = simpleProperties;
	}

	public Map<String, Entity> getEntityProperties() {
		return entityProperties;
	}

	public void setEntityProperties(Map<String, Entity> entityProperties) {
		this.entityProperties = entityProperties;
	}

	public void addSimpleProperty(String key, String value) {
		simpleProperties.put(key, value);

	}

	public void addEntityProperty(String key, Entity value) {
		entityProperties.put(key, value);

	}

	@Override
	public String toString() {
		return "Entitet [id=" + id + ", naziv=" + naziv + ", simpleProperties=" + simpleProperties
				+ ", entityProperties=" + entityProperties + "]";
	}

}