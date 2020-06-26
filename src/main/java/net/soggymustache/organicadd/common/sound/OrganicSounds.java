package net.soggymustache.organicadd.common.sound;

import net.minecraft.client.audio.Sound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.soggymustache.organicadd.OrganicMain;

import java.util.ArrayList;
import java.util.List;

public class OrganicSounds {

	public static final List<SoundEvent> SOUNDS = new ArrayList<>();
	public static final List<SoundEvent> TEX_SOUNDS = new ArrayList<>();

	public static SoundEvent booger_eater_hurt = registerSound("booger.eater.hurt");
	public static SoundEvent booger_eater_idle = registerSound("booger.eater.idle");
	public static SoundEvent booger_eater_death = registerSound("booger.eater.death");
	public static SoundEvent tex_sound_0 = registerTexSound("tex.sound.0");
	public static SoundEvent tex_sound_1 = registerTexSound("tex.sound.1");
	public static SoundEvent tex_sound_2 = registerTexSound("tex.sound.2");
	public static SoundEvent tex_sound_3 = registerTexSound("tex.sound.3");
	public static SoundEvent tex_sound_4 = registerTexSound("tex.sound.4");
	public static SoundEvent tex_sound_5 = registerTexSound("tex.sound.5");
	public static SoundEvent tex_sound_6 = registerTexSound("tex.sound.6");
	public static SoundEvent tex_sound_7 = registerTexSound("tex.sound.7");
	public static SoundEvent tex_sound_8 = registerTexSound("tex.sound.8");
	public static SoundEvent tex_sound_9 = registerTexSound("tex.sound.9");

	private static SoundEvent registerSound(String s) {
		ResourceLocation l = new ResourceLocation(OrganicMain.MOD_ID, s);
		SoundEvent event = new SoundEvent(l);
		event.setRegistryName(l);
		SOUNDS.add(event);
		return event;
	}

	private static SoundEvent registerTexSound(String s){
		SoundEvent e = registerSound(s);
		TEX_SOUNDS.add(e);
		return e;
	}

}
