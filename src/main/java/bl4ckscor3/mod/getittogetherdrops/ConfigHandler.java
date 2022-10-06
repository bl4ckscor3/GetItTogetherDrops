package bl4ckscor3.mod.getittogetherdrops;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class ConfigHandler
{
	private static GetItTogetherDropsConfig config;

	public static void register()
	{
		AutoConfig.register(GetItTogetherDropsConfig.class, JanksonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(GetItTogetherDropsConfig.class).getConfig();
	}

	public static double radius()
	{
		return config.radius;
	}

	public static boolean checkY()
	{
		return config.checkY;
	}
}