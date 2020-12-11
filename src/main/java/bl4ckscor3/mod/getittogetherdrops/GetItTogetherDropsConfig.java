package bl4ckscor3.mod.getittogetherdrops;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig.ModConfigEvent;

@EventBusSubscriber(modid=GetItTogetherDrops.MODID, bus=Bus.MOD)
public class GetItTogetherDropsConfig
{
	public static final ForgeConfigSpec CONFIG_SPEC;
	public static final GetItTogetherDropsConfig CONFIG;
	private final DoubleValue radiusConfigValue;
	private final BooleanValue checkYConfigValue;
	public static double radius;
	public static boolean checkY;

	static
	{
		Pair<GetItTogetherDropsConfig,ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(GetItTogetherDropsConfig::new);

		CONFIG_SPEC = specPair.getRight();
		CONFIG = specPair.getLeft();
	}

	public GetItTogetherDropsConfig(ForgeConfigSpec.Builder builder)
	{
		radiusConfigValue = builder
				.comment("The radius (in blocks) that dropped items should check around them for other dropped items to combine with. (\"0.5\" is vanilla behavior)")
				.defineInRange("radius", 2.0D, 0.5D, 500.0D);
		checkYConfigValue = builder
				.comment("Set to true if you want dropped items to also check above and below them, set to false if not (\"false\" is vanilla behavior)")
				.define("checkY", true);
	}

	@SubscribeEvent
	public static void onModConfig(ModConfigEvent event)
	{
		if(event.getConfig().getSpec() == GetItTogetherDropsConfig.CONFIG_SPEC)
		{
			radius = CONFIG.radiusConfigValue.get();
			checkY = CONFIG.checkYConfigValue.get();
		}
	}
}