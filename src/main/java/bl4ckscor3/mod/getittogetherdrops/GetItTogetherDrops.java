package bl4ckscor3.mod.getittogetherdrops;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(GetItTogetherDrops.MODID)
public class GetItTogetherDrops
{
	public static final String MODID = "getittogetherdrops";

	public GetItTogetherDrops()
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Configuration.CONFIG_SPEC);
	}

	public static class Configuration
	{
		public static final ForgeConfigSpec CONFIG_SPEC;
		public static final Configuration CONFIG;

		static {
			Pair<Configuration,ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Configuration::new);

			CONFIG_SPEC = specPair.getRight();
			CONFIG = specPair.getLeft();
		}

		public DoubleValue radius;
		public BooleanValue checkY;

		Configuration(ForgeConfigSpec.Builder builder)
		{
			radius = builder.
					comment("The radius (in blocks) that dropped items should check around them for other dropped items to combine with. (\"0.5\" is vanilla behavior)")
					.defineInRange("radius", 2.0D, 0.5D, 500.0D);
			checkY = builder.
					comment("Set to true if you want dropped items to also check above and below them, set to false if not (\"false\" is vanilla behavior)")
					.define("checkY", true);
		}
	}
}
