package net.soggymustache.organicadd.common;

import net.minecraft.entity.Entity;
import net.soggymustache.organicadd.common.entity.EntityBoogerEater;

import java.util.ArrayList;
import java.util.List;

public class OrganicEntities {

	public static final List<EntityContainer> CONTAINERS = new ArrayList<>();

	static {
		add(EntityBoogerEater.class, "boogereater", 0x2bfa14, 0xd0dba2);

	}

	private static void add(Class<? extends Entity> entityClass, String entityNameIn, int prim, int sec) {
		CONTAINERS.add(new EntityContainer(entityClass, entityNameIn.toLowerCase(), prim, sec));
	}

	public static class EntityContainer {
		public Class<? extends Entity> entityClass;
		public String entityName;
		public int prim, sec;

		public EntityContainer(Class<? extends Entity> EntityClass, String entityNameIn, int prim, int sec) {
			this.entityClass = EntityClass;
			this.entityName = entityNameIn;
			this.prim = prim;
			this.sec = sec;
		}
	}
}
