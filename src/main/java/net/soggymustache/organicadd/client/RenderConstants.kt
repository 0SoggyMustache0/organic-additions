package net.soggymustache.organicadd.client

import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.soggymustache.bookworm.client.model.ModelCMF
import net.soggymustache.organicadd.OrganicMain

@SideOnly(Side.CLIENT)
class RenderConstants{

    companion object{
        fun model(path: String) = ModelCMF(ResourceLocation(OrganicMain.MOD_ID, "models/entity/$path"))

        @JvmField
        val TEX = model("tex/tex_mex.bkm")
        @JvmField
        val TEX_DEFAULT = TEX.clone()
        @JvmField
        val TEX_CELEBRATE = model("tex/tex_celebrate.bkm")
        @JvmField
        val TEX_CLICK_1 = model("tex/tex_click_1.bkm")
        @JvmField
        val TEX_CLICK_2 = model("tex/tex_click_2.bkm")
        @JvmField
        val TEX_CLICK_3 = model("tex/tex_click_3.bkm")
        @JvmField
        val TEX_DANCE_1 = model("tex/tex_dance_1.bkm")
        @JvmField
        val TEX_DANCE_2 = model("tex/tex_dance_2.bkm")
        @JvmField
        val TEX_DANCE_3 = model("tex/tex_dance_3.bkm")
        @JvmField
        val TEX_DANCE_4 = model("tex/tex_dance_4.bkm")
        @JvmField
        val TEX_DANCE_5 = model("tex/tex_dance_5.bkm")
        @JvmField
        val TEX_DISAPPOINT_1 = model("tex/tex_disappoint_1.bkm")
        @JvmField
        val TEX_DISAPPOINT_2 = model("tex/tex_disappoint_2.bkm")
        @JvmField
        val TEX_DISAPPOINT_3 = model("tex/tex_disappoint_3.bkm")
        @JvmField
        val TEX_SCRATCH_1 = model("tex/tex_scratch_1.bkm")
        @JvmField
        val TEX_SCRATCH_2 = model("tex/tex_scratch_2.bkm")
        @JvmField
        val TEX_TOSS_1 = model("tex/tex_toss_1.bkm")
        @JvmField
        val TEX_TOSS_2 = model("tex/tex_toss_2.bkm")
        @JvmField
        val TEX_TOSS_3 = model("tex/tex_toss_3.bkm")
        @JvmField
        val TEX_WAVE_1 = model("tex/tex_wave_1.bkm")
        @JvmField
        val TEX_WAVE_2 = model("tex/tex_wave_2.bkm")
        @JvmField
        val TEX_WAVE_3 = model("tex/tex_wave_3.bkm")
    }
}