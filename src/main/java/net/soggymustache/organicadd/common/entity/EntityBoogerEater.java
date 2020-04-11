package net.soggymustache.organicadd.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.soggymustache.organicadd.OrganicMain;
import net.soggymustache.organicadd.common.configuration.OrganicConfig;

import javax.annotation.Nullable;
import javax.annotation.Resource;

public class EntityBoogerEater extends EntityMob {

	public static final DataParameter<String> MESSAGE = EntityDataManager.createKey(EntityBoogerEater.class, DataSerializers.STRING);
	public static final ResourceLocation EATER_TABLE = LootTableList.register(new ResourceLocation(OrganicMain.MOD_ID, "loot_tables/entities/booger_eater.json"));

	public EntityBoogerEater(World worldIn) {
		super(worldIn);
		this.setSize(0.4F, 1.13F);
	}

	@Nullable
	protected ResourceLocation getLootTable()
	{
		return EATER_TABLE;
	}

	@Nullable
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		this.setMessage(OrganicConfig.serverOptions.boogerSayings[rand.nextInt(OrganicConfig.serverOptions.boogerSayings.length)]);
		return super.onInitialSpawn(difficulty, livingdata);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(MESSAGE, "");
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		setMessage(compound.getString("Message"));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("Message", getMessage());
	}

	public String getMessage() {
		return dataManager.get(MESSAGE);
	}

	public void setMessage(String data) {
		dataManager.set(MESSAGE, data);
	}

	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, false));
		this.tasks.addTask(3, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 0.6D));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(6, new EntityAISwimming(this));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.tasks.addTask(0, new EntityAIAttackMelee(this, 1.2D, false));
	}

	@Override
	protected boolean processInteract(EntityPlayer player, EnumHand hand) {
/*		if(!world.isRemote) {
			EntityBubble b = new EntityBubble(world);
			b.setPosition(this.posX, this.posY, this.posZ);
			world.spawnEntity(b);
			b.startRiding(this, true);
		}*/

		return super.processInteract(player, hand);
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.31D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		return super.attackEntityAsMob(entityIn) && entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 2.0F);
	}

	@Override
	public boolean isChild() {
		return true; // This is always true because booger eaters are always children
	}
}
