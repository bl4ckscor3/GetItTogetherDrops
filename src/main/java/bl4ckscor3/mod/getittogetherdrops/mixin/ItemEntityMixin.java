package bl4ckscor3.mod.getittogetherdrops.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import bl4ckscor3.mod.getittogetherdrops.GetItTogetherDrops;
import bl4ckscor3.mod.getittogetherdrops.GetItTogetherDropsConfig;
import net.minecraft.world.entity.item.ItemEntity;

@Mixin(ItemEntity.class)
public class ItemEntityMixin
{
	@Inject(method="mergeWithNeighbours", at=@At("HEAD"), cancellable=true)
	private void mergeWithNeighbours(CallbackInfo info)
	{
		ItemEntity me = (ItemEntity)(Object)this;

		if(me.getItem().is(GetItTogetherDrops.IGNORED))
			return;
		else if(me.isMergable())
		{
			double radius = GetItTogetherDropsConfig.radius;
			boolean checkY = GetItTogetherDropsConfig.checkY;

			for(ItemEntity ei : me.level.getEntitiesOfClass(ItemEntity.class, me.getBoundingBox().inflate(radius, checkY ? radius : 0.0D, radius), e -> e != me && e.isMergable()))
			{
				me.tryToMerge(ei);

				if(me.isRemoved())
					break;
			}

		}

		info.cancel(); //"return;" in the original method
	}
}
