package utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;

public class StorageYAMLImpl implements Storage {

	private String pathYML = "C:\\Users\\nikol\\OneDrive\\Radna površina\\SK projekat\\ConverterComponent\\Data\\YAML\\data.yml";

	@Override
	public void addEntity(Entity ent) {
		ObjectMapper objectMapper = new ObjectMapper();
		int najveci = 0;
		try {
			List<Entity> Entiteti = objectMapper.readValue(new File(pathYML), new TypeReference<List<Entity>>() {
			});
			Entity entitet = new Entity();
			ArrayList<Entity> list = new ArrayList<Entity>();
			for(Entity e : Entiteti)
			{
				list.add(e);
			}

			for(int i = 0; i<list.size(); i++)
			{
				
				if(list.get(i).getId() > najveci)
				{
					najveci = list.get(i).getId();
				}
				
				
				
				for(Entity en : list.get(i).getEntityProperties().values())
				{
					list.add(en);
				}
			}
			ent.setId(najveci+1);
			Entiteti.add(ent);
			exportObjectToFile(Entiteti, pathYML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public boolean addEntity(Entity ent, int id) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<Entity> Entiteti = objectMapper.readValue(new File(pathYML), new TypeReference<List<Entity>>() {
			});
			Entity entitet = new Entity();
			ArrayList<Entity> list = new ArrayList<Entity>();
			for(Entity e : Entiteti)
			{
				list.add(e);
			}

			for(int i = 0; i<list.size(); i++)
			{
				
				if(list.get(i).getId() == id)
				{
					return false;
				}
				
				
				
				for(Entity en : list.get(i).getEntityProperties().values())
				{
					list.add(en);
				}
			}
			ent.setId(id);
			Entiteti.add(ent);
			exportObjectToFile(Entiteti, pathYML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void addEntity(Entity ent, String arg1, String arg2) {
		int idPar = Integer.parseInt(arg1);
		int idNew = Integer.parseInt(arg2);
		Entity ep = getEntity(idPar);
		ObjectMapper objectMapper = new ObjectMapper();
		int najveci = 0;
		try {
			List<Entity> Entiteti = objectMapper.readValue(new File(pathYML), new TypeReference<List<Entity>>() {
			});
			Entity entitet = new Entity();
			ArrayList<Entity> list = new ArrayList<Entity>();
			for(Entity e : Entiteti)
			{
				list.add(e);
			}

			for(int i = 0; i<list.size(); i++)
			{
				
				if(list.get(i).getId() > najveci)
				{
					najveci = list.get(i).getId();
				}
				
				
				
				for(Entity en : list.get(i).getEntityProperties().values())
				{
					list.add(en);
				}
			}
			ent.setId(najveci+1);
			ep.addEntityProperty(ent.getNaziv(), ent);
			System.out.println(ep);
			System.out.println(Entiteti);
			exportObjectToFile(Entiteti, pathYML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Entity> getEntities(String str) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Entity> returnList = new ArrayList<Entity>();
		try {
			List<Entity> Entiteti = objectMapper.readValue(new File(pathYML), new TypeReference<List<Entity>>() {
			});
			Entity entitet = new Entity();
			ArrayList<Entity> list = new ArrayList<Entity>();
			
			for(Entity e : Entiteti)
			{
				list.add(e);
			}

			for(int i = 0; i<list.size(); i++)
			{
				
				if(list.get(i).getNaziv().equals(str))
				{
					returnList.add(list.get(i));
				}
				
				
				
				for(Entity en : list.get(i).getEntityProperties().values())
				{
					list.add(en);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnList;
	}
	

	@Override
	public List<Entity> getEntitiesSorted(String name, String arg, Boolean bool) {
		List<Entity> list = getEntities(name);
		Comparator<Entity> comp = new Comparator<Entity>() {
			@Override
		    public int compare(Entity e1, Entity e2) {
		        //return o1.getId().compareTo(o2.getId());
		        return e1.getSimpleProperties().get(arg).compareTo(e2.getSimpleProperties().get(arg));
		    }
			
		};
		Collections.sort(list,comp);
		if(bool!=true)
		{
			Collections.reverse(list);
		}
		return list;
	}

	@Override
	public Entity getEntity(int id) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<Entity> Entiteti = objectMapper.readValue(new File(pathYML), new TypeReference<List<Entity>>() {
			});
			Entity entitet = new Entity();
			ArrayList<Entity> list = new ArrayList<Entity>();
			for(Entity e : Entiteti)
			{
				list.add(e);
			}

			for(int i = 0; i<list.size(); i++)
			{
				
				if(list.get(i).getId() == id)
				{
					return list.get(i);
				}
				
				
				
				for(Entity en : list.get(i).getEntityProperties().values())
				{
					list.add(en);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initNew(String arg0) {
		pathYML = arg0;
		
	}

	@Override
	public void removeEntities(String err, String name) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Entity> returnList = new ArrayList<Entity>();
		try {
			List<Entity> Entiteti = objectMapper.readValue(new File(pathYML), new TypeReference<List<Entity>>() {
			});
			Entity entitet = new Entity();
			ArrayList<Entity> list = new ArrayList<Entity>();
			
			for(Entity e : Entiteti)
			{
				list.add(e);
			}

			for(int i = 0; i<list.size(); i++)
			{
				
				if(list.get(i).getNaziv().equals(name))
				{
					returnList.add(list.get(i));
				}
				
				
				
				for(Entity en : list.get(i).getEntityProperties().values())
				{
					list.add(en);
				}
			}
			list.removeAll(returnList);
			exportObjectToFile(list, pathYML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void removeEntity(int id) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<Entity> Entiteti = objectMapper.readValue(new File(pathYML), new TypeReference<List<Entity>>() {
			});
			Entity entitet = new Entity();
			ArrayList<Entity> list = new ArrayList<Entity>();
			for(Entity e : Entiteti)
			{
				list.add(e);
			}

			for(int i = 0; i<list.size(); i++)
			{
				
				if(list.get(i).getId() == id)
				{
					list.remove(i);
				}
				
				
				
				for(Entity en : list.get(i).getEntityProperties().values())
				{
					list.add(en);
				}
			}
			exportObjectToFile(list, pathYML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
	

	@Override
	public void setNumOfEntitiesPerFile(Integer arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Entity> importFileToObject(String path) throws Exception {
		pathYML = path;
		ObjectMapper objectMapper = new ObjectMapper();
		List<Entity> Entiteti = objectMapper.readValue(new File(path), new TypeReference<List<Entity>>() {
		});
	
		return Entiteti;
	}
	
	@Override
	public boolean exportObjectToFile(List<Entity> Entiteti, String path) throws Exception {
	
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(path), Entiteti);
	
		return true;
	}
	
}


