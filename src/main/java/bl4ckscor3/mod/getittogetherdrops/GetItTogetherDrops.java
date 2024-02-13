package bl4ckscor3.mod.getittogetherdrops;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.fml.IExtensionPoint.DisplayTest;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(GetItTogetherDrops.MODID)
public class GetItTogetherDrops {
	public static final String MODID = "getittogetherdrops";
	public static final TagKey<Item> IGNORED = ItemTags.create(new ResourceLocation(MODID, "ignored"));
	public static final TagKey<Item> DO_NOT_COMBINE = ItemTags.create(new ResourceLocation(MODID, "do_not_combine"));

	public GetItTogetherDrops() {
		//make sure the mod being absent on the other network side does not cause the client to display the server as incompatible
		ModLoadingContext.get().registerExtensionPoint(DisplayTest.class, () -> new DisplayTest(() -> DisplayTest.IGNORESERVERONLY, (a, b) -> true));
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, GetItTogetherDropsConfig.CONFIG_SPEC);
	}
}
