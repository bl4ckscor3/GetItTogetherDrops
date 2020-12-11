package bl4ckscor3.mod.getittogetherdrops;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.network.FMLNetworkConstants;

@Mod(GetItTogetherDrops.MODID)
public class GetItTogetherDrops
{
	public static final String MODID = "getittogetherdrops";

	public GetItTogetherDrops()
	{
		//Make sure the mod being absent on the other network side does not cause the client to display the server as incompatible
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));

		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, GetItTogetherDropsConfig.CONFIG_SPEC);
	}
}
