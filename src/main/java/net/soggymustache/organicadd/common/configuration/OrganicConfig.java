package net.soggymustache.organicadd.common.configuration;

import net.minecraftforge.common.config.Config;
import net.soggymustache.organicadd.OrganicMain;

@Config(modid = OrganicMain.MOD_ID, name = "OrganicAdditions")
@Config.LangKey("config.organic.title")
public class OrganicConfig{

	public static final Options serverOptions = new Options();
	public static final ClientOptions clientOptions = new ClientOptions();

	public static class ClientOptions{

	}

	public static class Options {
		@Config.Name("Booger Eater Phrases")
		@Config.Comment("List of what the booger eaters say")
		public String[] boogerSayings = {
				"Hermitcraft 7! When!!",
				"Y ban! I did no wrong."
		};

	}
}
