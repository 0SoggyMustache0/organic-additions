package net.soggymustache.organicadd.common.sound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.soggymustache.organicadd.OrganicMain;

import java.util.ArrayList;
import java.util.List;

public class OrganicSounds {

	public static final List<SoundEvent> SOUNDS = new ArrayList<>();

	public static SoundEvent booger_eater_hurt = registerSound("booger.eater.hurt");
	public static SoundEvent booger_eater_idle = registerSound("booger.eater.idle");
	public static SoundEvent booger_eater_death = registerSound("booger.eater.death");


	private static SoundEvent registerSound(String s) {
		ResourceLocation l = new ResourceLocation(OrganicMain.MOD_ID, s);
		SoundEvent event = new SoundEvent(l);
		event.setRegistryName(l);
		SOUNDS.add(event);
		return event;
	}

}
