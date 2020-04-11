package net.soggymustache.organicadd.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.soggymustache.organicadd.OrganicMain;
import net.soggymustache.organicadd.client.model.ModelBubble;
import net.soggymustache.organicadd.common.entity.EntityBubble;

import javax.annotation.Nullable;

public class RenderBubble extends Render<EntityBubble> {

	public static final ModelBubble MODEL_BUBBLE = new ModelBubble();
	public static final ResourceLocation TEXTURE = new ResourceLocation(OrganicMain.MOD_ID, "textures/entity/bubble/bubble.png");
	public static FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;;

	public RenderBubble(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(EntityBubble entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		bindTexture(getEntityTexture(entity));
		GlStateManager.translate(x, y + 0.4F, z);
		MODEL_BUBBLE.render(entity, 0,0,0,0,0,1);
		GlStateManager.popMatrix();

		if(entity.getRidingEntity() != null) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(x, y + 0.4f, z);
			GlStateManager.rotate(entity.getRidingEntity().rotationYaw, 0, 1, 0);
			GlStateManager.scale(0.010416667F, -0.010416667F, 0.010416667F);
			GlStateManager.glNormal3f(0.0F, 0.0F, -0.010416667F);
			GlStateManager.depthMask(false);
			fontrenderer.drawString("Ok Boomer", 0, 0, 0);

			GlStateManager.depthMask(true);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			GlStateManager.popMatrix();
		}
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EntityBubble entity) {
		return TEXTURE;
	}
}
