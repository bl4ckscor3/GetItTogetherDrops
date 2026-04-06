package bl4ckscor3.mod.getittogetherdrops;

import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import fuzs.forgeconfigapiport.fabric.api.v5.ModConfigEvents;
import net.fabricmc.api.ModInitializer;
import net.neoforged.fml.config.ModConfig;

public class FabricEntrypoint implements ModInitializer {
	@Override
	public void onInitialize() {
		ConfigRegistry.INSTANCE.register(GetItTogetherDrops.MODID, ModConfig.Type.SERVER, GetItTogetherDropsConfig.CONFIG_SPEC);
		ModConfigEvents.loading(GetItTogetherDrops.MODID).register(config -> GetItTogetherDropsConfig.onConfigChange(config.getSpec()));
		ModConfigEvents.reloading(GetItTogetherDrops.MODID).register(config -> GetItTogetherDropsConfig.onConfigChange(config.getSpec()));
		ModConfigEvents.unloading(GetItTogetherDrops.MODID).register(config -> GetItTogetherDropsConfig.onConfigChange(config.getSpec()));
	}
}
