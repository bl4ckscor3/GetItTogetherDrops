package bl4ckscor3.mod.getittogetherdrops;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

import org.apache.commons.lang3.tuple.Pair;

@EventBusSubscriber(modid = GetItTogetherDrops.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GetItTogetherDropsConfig {

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final Configuration CONFIG;

    static {
        Pair<Configuration,ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Configuration::new);
        CONFIG_SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

    public static double radius;
    public static boolean checkY;

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if (configEvent.getConfig().getSpec() == GetItTogetherDropsConfig.CONFIG_SPEC) {
            bakeConfig();
        }
    }

    public static void bakeConfig() {
        radius = CONFIG.radius.get();
        checkY = CONFIG.checkY.get();
    }

    public static class Configuration {
        public final ForgeConfigSpec.DoubleValue radius;
        public final ForgeConfigSpec.BooleanValue checkY;

        public Configuration(ForgeConfigSpec.Builder builder) {            
            radius = builder.
                    comment("The radius (in blocks) that dropped items should check around them for other dropped items to combine with. (\"0.5\" is vanilla behavior)")
                    .defineInRange("radius", 2.0D, 0.5D, 500.0D);
            checkY = builder.
                    comment("Set to true if you want dropped items to also check above and below them, set to false if not (\"false\" is vanilla behavior)")
                    .define("checkY", true);
        }
    }
}