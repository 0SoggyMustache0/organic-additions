package net.soggymustache.organicadd.common.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class EntityBubble extends EntityCreature {

	public EntityBubble(World worldIn) {
		super(worldIn);
		this.setSize(0.1F, 0.1F);
	}

}
