package bl4ckscor3.mod.getittogetherdrops;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class GetItTogetherDrops {
	public static final String MODID = "getittogetherdrops";
	public static final TagKey<Item> IGNORED = createItemTag("ignored");
	public static final TagKey<Item> DO_NOT_COMBINE = createItemTag("do_not_combine");

	private static TagKey<Item> createItemTag(String name) {
		return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name));
	}
}
