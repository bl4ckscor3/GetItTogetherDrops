package bl4ckscor3.mod.getittogetherdrops;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class GetItTogetherDrops implements ModInitializer
{
	public static final String MODID = "getittogetherdrops";
	public static final TagKey<Item> IGNORED = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "ignored"));

	@Override
	public void onInitialize()
	{
		if(FabricLoader.getInstance().isModLoaded("cloth-config"))
			ConfigHandler.register();
	}
}