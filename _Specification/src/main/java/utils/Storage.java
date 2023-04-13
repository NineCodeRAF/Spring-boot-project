package utils;

import java.util.List;

public interface Storage {

	List<Entity> importFileToObject(String path) throws Exception;

	boolean exportObjectToFile(List<Entity> entiteti, String path) throws Exception;

	/**
	 * Koristi postojece
	 */
	void init();	
	
	/**
	 * Pravi novo
	 * @param path
	 */
	void initNew(String path);
	
	/**
	 * Maks broj entiteta u jednom fajlu
	 * @param num
	 */
	void setNumOfEntitiesPerFile(Integer num);
	
	/**
	 * Doda entitet, automatski dodeli id
	 */
	void addEntity(Entity entity);
	
	/**
	 * Doda entitet, proverava jedinstvenost. Vraca da li je jedinstven
	 */
	boolean addEntity(Entity entity, int id);
	
	/**
	 * Doda entitet u okviru drugog entiteta
	 */
	void addEntity(Entity entity, String idParent, String keyChild);
	
	/**
	 * Pretrazi jedan entitet
	 */
	Entity getEntity(int id);
	
	/**
	 * Pretrazi, vraca sve entitete koji odgovaraju imenu
	 */
	List<Entity> getEntities(String name);
	
	/**
	 * Pretrazi, vraca sve, sortirano
	 */
	List<Entity> getEntitiesSorted(String name, String priority, Boolean isAscending);
	
	/**
	 * Brise jedan entitet 
	 */
	void removeEntity(int id);
	
	/**
	 * Brise vise entiteta
	 */
	void removeEntities(String entityType, String name);
}
