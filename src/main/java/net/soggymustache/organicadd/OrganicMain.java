package net.soggymustache.organicadd;

import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.soggymustache.organicadd.client.render.RenderBoogerEater;
import net.soggymustache.organicadd.client.render.RenderTex;
import net.soggymustache.organicadd.common.OrganicEntities;
import net.soggymustache.organicadd.common.entity.EntityBoogerEater;
import net.soggymustache.organicadd.common.entity.EntityTex;
import net.soggymustache.organicadd.common.sound.OrganicSounds;

@Mod(modid = OrganicMain.MOD_ID, name = OrganicMain.NAME, version = OrganicMain.VERSION)
public class OrganicMain {

	public static final String MOD_ID = "organicadd";
	public static final String NAME = "Organic Additions";
	public static final String VERSION = "1.0.0";

	@Mod.EventBusSubscriber(modid = MOD_ID)
    public static class Handlers{

        private static int ENTITY_ID = 0;

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
            final IForgeRegistry<EntityEntry> registry = event.getRegistry();
            OrganicEntities.CONTAINERS.forEach(a -> {
                ResourceLocation r = new ResourceLocation(OrganicMain.MOD_ID, a.entityName);
                EntityEntry e = EntityEntryBuilder.create().entity(a.entityClass).id(r, ENTITY_ID++).name(OrganicMain.MOD_ID + "." + a.entityName).tracker(120, 1, true).build();
                if(a.sec != -1 && a.prim != -1)
                    e.setEgg(new EntityList.EntityEggInfo(r, a.prim, a.sec));
                registry.register(e);
            });
        }

        @SubscribeEvent
        public static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
            event.getRegistry().registerAll(OrganicSounds.SOUNDS.toArray(new SoundEvent[0]));
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void registerRenders(ModelRegistryEvent e) {
            RenderingRegistry.registerEntityRenderingHandler(EntityBoogerEater.class, RenderBoogerEater::new);
            RenderingRegistry.registerEntityRenderingHandler(EntityTex.class, RenderTex::new);
        }

        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(OrganicMain.MOD_ID)) ConfigManager.sync(OrganicMain.MOD_ID, Config.Type.INSTANCE);
        }
    }
}
