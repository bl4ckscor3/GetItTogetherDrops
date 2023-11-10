package bl4ckscor3.mod.getittogetherdrops.mixin;

import bl4ckscor3.mod.getittogetherdrops.GetItTogetherDrops;
import bl4ckscor3.mod.getittogetherdrops.GetItTogetherDropsConfig;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
	@Inject(method = "mergeWithNeighbours", at = @At(value = "INVOKE_ASSIGN", id = "Lnet/minecraft/world/entity/item/ItemEntity;isMergable()Z"), cancellable = true)
	private void mergeWithNeighbours(CallbackInfo info) {
		ItemEntity me = (ItemEntity) (Object) this;
		ItemStack item = me.getItem();

		if (item.is(GetItTogetherDrops.IGNORED)) //if part of tag: fall back to vanilla behavior
			return;
		else if (!item.is(GetItTogetherDrops.DO_NOT_COMBINE)) { //if part of tag: do not combine the item at all
			double radius = GetItTogetherDropsConfig.radius;
			boolean checkY = GetItTogetherDropsConfig.checkY;

			for (ItemEntity ei : me.level().getEntitiesOfClass(ItemEntity.class, me.getBoundingBox().inflate(radius, checkY ? radius : 0.0D, radius), e -> e != me && e.isMergable())) {
				me.tryToMerge(ei);

				if (me.isRemoved())
					break;
			}
		}

		info.cancel(); //"return;" in the original method
	}
}
