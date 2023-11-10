package bl4ckscor3.mod.getittogetherdrops;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.fml.common.Mod.EventBusSubscriber.Bus;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import net.neoforged.neoforge.common.ModConfigSpec.DoubleValue;
import org.apache.commons.lang3.tuple.Pair;

@EventBusSubscriber(modid = GetItTogetherDrops.MODID, bus = Bus.MOD)
public class GetItTogetherDropsConfig {
	public static final ModConfigSpec CONFIG_SPEC;
	public static final GetItTogetherDropsConfig CONFIG;
	private final DoubleValue radiusConfigValue;
	private final BooleanValue checkYConfigValue;
	public static double radius;
	public static boolean checkY;

	static {
		Pair<GetItTogetherDropsConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(GetItTogetherDropsConfig::new);

		CONFIG_SPEC = specPair.getRight();
		CONFIG = specPair.getLeft();
	}

	public GetItTogetherDropsConfig(ModConfigSpec.Builder builder) {
		radiusConfigValue = builder.comment("The radius (in blocks) that dropped items should check around them for other dropped items to combine with. (\"0.5\" is vanilla behavior)").defineInRange("radius", 2.0D, 0.5D, 500.0D);
		checkYConfigValue = builder.comment("Set to true if you want dropped items to also check above and below them, set to false if not (\"false\" is vanilla behavior)").define("checkY", true);
	}

	@SubscribeEvent
	public static void onModConfig(ModConfigEvent event) {
		if (event.getConfig().getSpec() == GetItTogetherDropsConfig.CONFIG_SPEC) {
			radius = CONFIG.radiusConfigValue.get();
			checkY = CONFIG.checkYConfigValue.get();
		}
	}
}