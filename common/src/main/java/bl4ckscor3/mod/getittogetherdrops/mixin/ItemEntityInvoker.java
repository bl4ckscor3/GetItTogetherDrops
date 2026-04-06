package bl4ckscor3.mod.getittogetherdrops.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.entity.item.ItemEntity;

@Mixin(ItemEntity.class)
public interface ItemEntityInvoker {
	@Invoker("isMergable")
	boolean callIsMergable();

	@Invoker("tryToMerge")
	void callTryToMerge(ItemEntity itemEntity);
}