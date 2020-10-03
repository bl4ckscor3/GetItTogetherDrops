package bl4ckscor3.mod.getittogetherdrops.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import bl4ckscor3.mod.getittogetherdrops.GetItTogetherDrops.Configuration;
import net.minecraft.entity.item.ItemEntity;

@Mixin(ItemEntity.class)
public class ItemEntityMixin
{
	@Inject(method="searchForOtherItemsNearby", at=@At("HEAD"), cancellable=true)
	private void searchForOtherItemsNearby(CallbackInfo info)
	{
		ItemEntity me = (ItemEntity)(Object)this;

		if(me.func_213857_z())
		{
			double radius = Configuration.CONFIG.radius.get();
			boolean checkY = Configuration.CONFIG.checkY.get();

			for(ItemEntity ei : me.world.getEntitiesWithinAABB(ItemEntity.class, me.getBoundingBox().grow(radius, checkY ? radius : 0.0D, radius), e -> e != me && e.func_213857_z()))
			{
				if(ei.func_213857_z())
				{
					me.func_226530_a_(ei);

					if(me.removed)
						break;
				}
			}

		}

		info.cancel(); //"return;" in the original method
	}
}
