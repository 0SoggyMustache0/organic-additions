package net.soggymustache.organicadd.client

import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.soggymustache.bookworm.client.animation.lerp.Animation

@SideOnly(Side.CLIENT)
class AnimationConstants {

    companion object {
        @JvmField
        val HEEL_CLICK = object : Animation(
                RenderConstants.TEX,
                RenderConstants.TEX_CLICK_1,
                RenderConstants.TEX_CLICK_2,
                RenderConstants.TEX_CLICK_3,
                RenderConstants.TEX_DEFAULT
        ){
            override fun getSpeedForFrame(frame: Int): Float {
                return when(frame) {
                    2 -> 0.5F
                    3 -> 0.8F
                    4 -> 0.8F
                    else -> super.getSpeedForFrame(frame)
                }
            }
        }.apply { speed = 0.3F}

        @JvmField
        val SCRATCH = Animation(
                RenderConstants.TEX,
                RenderConstants.TEX_SCRATCH_1,
                RenderConstants.TEX_SCRATCH_2,
                RenderConstants.TEX_SCRATCH_1,
                RenderConstants.TEX_SCRATCH_2,
                RenderConstants.TEX_DEFAULT
        ).apply { speed = 0.3F; playedParts = mutableListOf("armLeft")}

        @JvmField
        val DISAPPOINT = object : Animation(
                RenderConstants.TEX,
                RenderConstants.TEX_DISAPPOINT_1,
                RenderConstants.TEX_DISAPPOINT_2,
                RenderConstants.TEX_DISAPPOINT_3,
                RenderConstants.TEX_DISAPPOINT_2,
                RenderConstants.TEX_DISAPPOINT_1,
                RenderConstants.TEX_DEFAULT
        ){
            override fun getSpeedForFrame(frame: Int): Float {
                return if(frame <= 0 || frame >= 5) super.getSpeedForFrame(frame) else 0.2F
            }
        }.apply { speed = 0.1F; playedParts = mutableListOf("head")}

        @JvmField
        val DANCE = Animation(
                RenderConstants.TEX,
                RenderConstants.TEX_DANCE_1,
                RenderConstants.TEX_DANCE_2,
                RenderConstants.TEX_DANCE_3,
                RenderConstants.TEX_DANCE_4,
                RenderConstants.TEX_DANCE_5,
                RenderConstants.TEX_DANCE_1,
                RenderConstants.TEX_DANCE_2,
                RenderConstants.TEX_DANCE_3,
                RenderConstants.TEX_DANCE_4,
                RenderConstants.TEX_DANCE_5,
                RenderConstants.TEX_DANCE_1,
                RenderConstants.TEX_DANCE_2,
                RenderConstants.TEX_DANCE_3,
                RenderConstants.TEX_DANCE_4,
                RenderConstants.TEX_DANCE_5,
                RenderConstants.TEX_DEFAULT
        ).apply { speed = 0.3F}

        @JvmField
        val HAT = Animation(
                RenderConstants.TEX,
                RenderConstants.TEX_TOSS_1,
                RenderConstants.TEX_TOSS_2,
                RenderConstants.TEX_TOSS_3,
                RenderConstants.TEX_TOSS_2,
                RenderConstants.TEX_TOSS_1,
                RenderConstants.TEX_DEFAULT
        ).apply { speed = 0.3F; playedParts = mutableListOf("armRight", "hatBrim", "hatTop")}

        @JvmField
        val CELEBRATE = object : Animation(
                RenderConstants.TEX,
                RenderConstants.TEX_CELEBRATE,
                RenderConstants.TEX_CELEBRATE,
                RenderConstants.TEX_DEFAULT
        ){
            override fun getSpeedForFrame(frame: Int): Float {
                return when(frame){
                    1 -> 0.1F
                    2 -> 0.1F
                    else -> super.getSpeedForFrame(frame)
                }
            }
        }.apply { speed = 0.3F}

        @JvmField
        val WAVE = object : Animation(
                RenderConstants.TEX,
                RenderConstants.TEX_WAVE_1,
                RenderConstants.TEX_WAVE_2,
                RenderConstants.TEX_WAVE_3,
                RenderConstants.TEX_WAVE_2,
                RenderConstants.TEX_WAVE_3,
                RenderConstants.TEX_WAVE_2,
                RenderConstants.TEX_WAVE_3,
                RenderConstants.TEX_DEFAULT
        ){
            override fun getSpeedForFrame(frame: Int): Float {
                return when(frame) {
                    1 -> 0.5F
                    else -> super.getSpeedForFrame(frame)
                }
            }
        }.apply { speed = 0.3F; playedParts = mutableListOf("armRight")}

    }

}