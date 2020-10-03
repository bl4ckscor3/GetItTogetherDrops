package bl4ckscor3.mod.getittogetherdrops.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import bl4ckscor3.mod.getittogetherdrops.GetItTogetherDrops.Configuration;
import net.minecraft.entity.item.EntityItem;

@Mixin(EntityItem.class)
public class MixinEntityItem
{
	@Inject(method="searchForOtherItemsNearby", at=@At("HEAD"), cancellable=true)
	private void searchForOtherItemsNearby(CallbackInfo info)
	{
		EntityItem me = (EntityItem)(Object)this;

		for(EntityItem ei : me.world.getEntitiesWithinAABB(EntityItem.class, me.getEntityBoundingBox().grow(Configuration.radius, Configuration.checkY ? Configuration.radius : 0.0D, Configuration.radius)))
		{
			me.combineItems(ei);
		}

		info.cancel(); //"return;" in the original method
	}
}
