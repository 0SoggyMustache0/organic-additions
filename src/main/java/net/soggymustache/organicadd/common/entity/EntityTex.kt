package net.soggymustache.organicadd.common.entity

import net.minecraft.block.BlockRedstoneWire
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityAgeable
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.*
import net.minecraft.entity.passive.EntityAnimal
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.util.DamageSource
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.soggymustache.bookworm.client.animation.lerp.Animation
import net.soggymustache.bookworm.client.animation.lerp.AnimationHandler
import net.soggymustache.organicadd.client.AnimationConstants
import net.soggymustache.organicadd.client.RenderConstants
import net.soggymustache.organicadd.common.sound.OrganicSounds

class EntityTex(w: World) : EntityAnimal(w){

    val animator = AnimationHandler()

    companion object{
        const val HEEL_CLICK = 0
        const val SCRATCH = 1
        const val DISAPPOINT = 2
        const val DANCE = 3
        const val HAT = 4
        const val CELEBRATE = 5
        const val WAVE = 6
    }

    init{
        setSize(1.0F, 2.0F)
        if(world.isRemote) {
            animator.abruptStopping = false
            animator.addAnimation(HEEL_CLICK, AnimationConstants.HEEL_CLICK)
            animator.addAnimation(SCRATCH, AnimationConstants.SCRATCH)
            animator.addAnimation(DISAPPOINT, AnimationConstants.DISAPPOINT)
            animator.addAnimation(DANCE, AnimationConstants.DANCE)
            animator.addAnimation(HAT, AnimationConstants.HAT)
            animator.addAnimation(CELEBRATE, AnimationConstants.CELEBRATE)
            animator.addAnimation(WAVE, AnimationConstants.WAVE)
        }
    }

    override fun onUpdate() {
        super.onUpdate()
        if(world.isRemote) {
            animator.onEntityUpdate(this)

            if (animator.isPlaying(CELEBRATE) && animator.frame == 2) {
                //TODO send packet to make this jump
                jump()
            }

            if(animator.playingAnimation == null) {
                val state = world.getBlockState(BlockPos(this).add(0,0,0))
                if (state.block == Blocks.REDSTONE_WIRE) {
                    val power = state.getValue(BlockRedstoneWire.POWER)
                    if (power in 9..16) {
                        animator.play(power - 9)
                    }
                    else if(power < OrganicSounds.TEX_SOUNDS.size){
                        playSound(OrganicSounds.TEX_SOUNDS[power], 1.0F, 1.0F)
                    }
                }
            }
        }
    }

    override fun initEntityAI() {
        super.initEntityAI()
        tasks.addTask(0, EntityAISwimming(this))
        tasks.addTask(3, EntityAITempt(this, 1.25, Items.ACACIA_BOAT, false))
        tasks.addTask(2, EntityAIWanderAvoidWater(this, 1.0))
        tasks.addTask(4, EntityAIWatchClosest(this, EntityPlayer::class.java, 6.0F))
        tasks.addTask(5, EntityAILookIdle(this))
        tasks.addTask(3, EntityAIAttackMelee(this, 1.2, false))
        tasks.addTask(4, EntityAIHurtByTarget(this, false))
    }

    override fun applyEntityAttributes() {
        super.applyEntityAttributes()
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).baseValue = 10.0
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).baseValue = 0.2
    }

    override fun attackEntityAsMob(entityIn: Entity): Boolean {
        return super.attackEntityAsMob(entityIn) && entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0F)
    }

    override fun createChild(ageable: EntityAgeable): EntityAgeable = EntityTex(world)

}