package net.soggymustache.organicadd.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.organicadd.OrganicMain;
import net.soggymustache.organicadd.client.model.ModelBubble;
import net.soggymustache.organicadd.common.entity.EntityBoogerEater;

@SideOnly(Side.CLIENT)
public class RenderBoogerEater extends RenderBiped<EntityBoogerEater> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(OrganicMain.MOD_ID, "textures/entity/booger_eater/booger_eater.png");
	public static final ModelBubble MODEL_BUBBLE = new ModelBubble();
	public static final ResourceLocation BUBBLE = new ResourceLocation(OrganicMain.MOD_ID, "textures/entity/bubble/bubble.png");
	public static FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;;

	public RenderBoogerEater(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelZombie(), 0.5F);
		LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this) {
			protected void initArmor() {
				this.modelLeggings = new ModelZombie(0.5F, true);
				this.modelArmor = new ModelZombie(1.0F, true);
			}
		};
		this.addLayer(layerbipedarmor);
	}

	@Override
	public void doRender(EntityBoogerEater entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);

		GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		bindTexture(BUBBLE);
		GlStateManager.translate(x, y + 1.01F, z);
		GlStateManager.rotate(180 - entity.renderYawOffset, 0, 1, 0);
		GlStateManager.scale(1.0F, 0.35F, 0.01F);
		MODEL_BUBBLE.render(entity, 0,0,0,0,0,0.0625F);
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		renderText(entity, x, y, z, 1);
		GlStateManager.popMatrix();
	}

	protected void renderText(EntityBoogerEater entity, double x, double y, double z, float rotation){
		GlStateManager.translate(x - Math.sin(entity.renderYawOffset * 0.017f) * 0.01F,y + 1.5F, z + Math.cos(entity.renderYawOffset * 0.017f) * 0.01F);
		GlStateManager.scale(0.010416667F, -0.010416667F, 0.010416667F);
		GlStateManager.rotate(180 - entity.renderYawOffset, 0, 1, 0);
		GlStateManager.rotate(180, 0,rotation,0);
		GlStateManager.glNormal3f(0.0F, 0.0F, -0.010416667F);
		GlStateManager.depthMask(false);
		fontrenderer.drawSplitString(entity.getMessage(),-40, 0, 100,0);
		GlStateManager.depthMask(true);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	}

	protected ResourceLocation getEntityTexture(EntityBoogerEater entity) {
		return TEXTURE;
	}
}