package net.soggymustache.organicadd.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Bubble - Soggy
 * Created using Tabula 7.0.0
 */
public class ModelBubble extends ModelBase {
    public ModelRenderer Bubble;

    public ModelBubble() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Bubble = new ModelRenderer(this, 0, 0);
        this.Bubble.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.Bubble.addBox(-8.0F, -8.0F, -0.5F, 16, 16, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Bubble.render(f5);
    }
}
