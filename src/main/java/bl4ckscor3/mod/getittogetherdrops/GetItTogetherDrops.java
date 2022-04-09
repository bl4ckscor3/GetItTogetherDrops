package bl4ckscor3.mod.getittogetherdrops;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid=GetItTogetherDrops.MODID, name="Get It Together, Drops!", version="1.0.1", serverSideOnly=true, acceptableRemoteVersions="*")
@EventBusSubscriber(modid=GetItTogetherDrops.MODID)
public class GetItTogetherDrops
{
	public static final String MODID = "getittogetherdrops";

	@Config(modid=MODID)
	public static class Configuration
	{
		@Comment("The radius (in blocks) that dropped items should check around them for other dropped items to combine with. (\"0.5\" is vanilla behavior)")
		@RangeDouble(min=0.5D, max=500.0D)
		public static double radius = 2.0D;

		@Comment("Set to true if you want dropped items to also check above and below them, set to false if not (\"false\" is vanilla behavior)")
		public static boolean checkY = true;
	}

	@SubscribeEvent
	public static void onConfigChanged(OnConfigChangedEvent event)
	{
		if(event.getModID().equals(MODID))
			ConfigManager.sync(MODID, Config.Type.INSTANCE);
	}
}
