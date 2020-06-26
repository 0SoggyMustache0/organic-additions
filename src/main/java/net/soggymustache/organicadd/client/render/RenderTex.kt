package net.soggymustache.organicadd.client.render

import net.minecraft.client.renderer.entity.RenderLiving
import net.minecraft.client.renderer.entity.RenderManager
import net.minecraft.client.renderer.entity.layers.LayerHeldItem
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.MathHelper
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer
import net.soggymustache.bookworm.client.model.CMFAnimator
import net.soggymustache.bookworm.client.model.ModelCMF
import net.soggymustache.organicadd.OrganicMain
import net.soggymustache.organicadd.client.RenderConstants
import net.soggymustache.organicadd.common.entity.EntityTex

class RenderTex(rm: RenderManager) : RenderLiving<EntityTex>(rm, RenderConstants.TEX, 0.3F){

    companion object{
        @JvmField
        val texture = ResourceLocation(OrganicMain.MOD_ID, "textures/entity/tex/tex_mex_pig.png")

        init{
            RenderConstants.TEX.setAnimator(::TexAnimator)
        }
    }

    init{
        addLayer(LayerHeldItem(this))
    }

    override fun getEntityTexture(entity: EntityTex) = texture

    open class TexAnimator(model: ModelCMF) : CMFAnimator<EntityTex>(model){

        protected val bipedRightArm: BookwormModelRenderer = model.getPartByName("armRight")
        protected val bipedLeftLeg: BookwormModelRenderer = model.getPartByName("legLeft")
        protected val bipedRightLeg: BookwormModelRenderer = model.getPartByName("legRight")
        protected val bipedLeftArm: BookwormModelRenderer = model.getPartByName("armLeft")
        protected val bipedHead: BookwormModelRenderer = model.getPartByName("head")

        override fun setRotationAngles(limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float, scaleFactor: Float, entityIn: EntityTex) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn)
            model.reset()
            this.bipedHead.rotateAngleY = netHeadYaw * 0.017453292f
            this.bipedHead.rotateAngleX = headPitch * 0.017453292f
            this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + Math.PI.toFloat()) * 2.0f * limbSwingAmount * 0.5f
            this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 2.0f * limbSwingAmount * 0.5f
            this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount
            this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + Math.PI.toFloat()) * 1.4f * limbSwingAmount
            entityIn.animator.updateModel(model)
        }

    }

}