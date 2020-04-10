package net.soggymustache.organicadd.client.render;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.organicadd.OrganicMain;
import net.soggymustache.organicadd.common.entity.EntityBoogerEater;

@SideOnly(Side.CLIENT)
public class RenderBoogerEater extends RenderBiped<EntityBoogerEater> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(OrganicMain.MOD_ID, "textures/entity/booger_eater/booger_eater.png");

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
	
	protected ResourceLocation getEntityTexture(EntityBoogerEater entity) {
		return TEXTURE;
	}
}