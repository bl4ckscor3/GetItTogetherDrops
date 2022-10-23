package bl4ckscor3.mod.getittogetherdrops;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class GetItTogetherDrops implements ModInitializer {
	public static final String MODID = "getittogetherdrops";
	public static final TagKey<Item> IGNORED = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "ignored"));
	public static final TagKey<Item> DO_NOT_COMBINE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "do_not_combine"));
	private static GetItTogetherDropsConfig config;

	@Override
	public void onInitialize() {
		AutoConfig.register(GetItTogetherDropsConfig.class, JanksonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(GetItTogetherDropsConfig.class).getConfig();
	}

	public static double radius() {
		return config.radius;
	}

	public static boolean checkY() {
		return config.checkY;
	}
}