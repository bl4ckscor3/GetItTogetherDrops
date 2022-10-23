package bl4ckscor3.mod.getittogetherdrops.mixin;

import bl4ckscor3.mod.getittogetherdrops.GetItTogetherDrops;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {
	@Inject(method = "mergeWithNeighbours", at = @At("HEAD"), cancellable = true)
	private void mergeWithNeighbours(CallbackInfo info) {
		ItemEntity me = (ItemEntity) (Object) this;
		ItemStack item = me.getItem();

		if (item.is(GetItTogetherDrops.IGNORED)) //fall back to vanilla behavior
			return;

		ItemEntityInvoker invokeMe = (ItemEntityInvoker) me;

		if (invokeMe.callIsMergable() && !item.is(GetItTogetherDrops.DO_NOT_COMBINE)) { //do not combine the item at all
			double radius = GetItTogetherDrops.radius();
			boolean checkY = GetItTogetherDrops.checkY();

			for (ItemEntity ei : me.level.getEntitiesOfClass(ItemEntity.class, me.getBoundingBox().inflate(radius, checkY ? radius : 0.0D, radius), e -> e != me && ((ItemEntityInvoker) e).callIsMergable())) {
				invokeMe.callTryToMerge(ei);

				if (me.isRemoved())
					break;
			}

		}

		info.cancel(); //"return;" in the original method
	}
}