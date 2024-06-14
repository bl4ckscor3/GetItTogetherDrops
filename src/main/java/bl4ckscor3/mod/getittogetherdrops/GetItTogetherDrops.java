package bl4ckscor3.mod.getittogetherdrops;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(GetItTogetherDrops.MODID)
public class GetItTogetherDrops {
	public static final String MODID = "getittogetherdrops";
	public static final TagKey<Item> IGNORED = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MODID, "ignored"));
	public static final TagKey<Item> DO_NOT_COMBINE = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MODID, "do_not_combine"));

	public GetItTogetherDrops(ModContainer modContainer) {
		modContainer.registerConfig(ModConfig.Type.SERVER, GetItTogetherDropsConfig.CONFIG_SPEC);
	}
}
