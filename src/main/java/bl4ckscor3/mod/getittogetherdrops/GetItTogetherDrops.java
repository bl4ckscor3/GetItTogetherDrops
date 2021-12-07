package bl4ckscor3.mod.getittogetherdrops;

import net.minecraftforge.fml.IExtensionPoint.DisplayTest;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.network.NetworkConstants;

@Mod(GetItTogetherDrops.MODID)
public class GetItTogetherDrops
{
	public static final String MODID = "getittogetherdrops";

	public GetItTogetherDrops()
	{
		//make sure the mod being absent on the other network side does not cause the client to display the server as incompatible
		ModLoadingContext.get().registerExtensionPoint(DisplayTest.class, () -> new DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, GetItTogetherDropsConfig.CONFIG_SPEC);
	}
}
