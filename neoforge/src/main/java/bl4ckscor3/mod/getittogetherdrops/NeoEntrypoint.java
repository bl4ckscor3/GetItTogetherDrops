package bl4ckscor3.mod.getittogetherdrops;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;

@Mod(GetItTogetherDrops.MODID)
@EventBusSubscriber
public class NeoEntrypoint {
	public NeoEntrypoint(ModContainer modContainer) {
		modContainer.registerConfig(ModConfig.Type.SERVER, GetItTogetherDropsConfig.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onConfigChange(ModConfigEvent event) {
		GetItTogetherDropsConfig.onConfigChange(event.getConfig().getSpec());
	}
}
