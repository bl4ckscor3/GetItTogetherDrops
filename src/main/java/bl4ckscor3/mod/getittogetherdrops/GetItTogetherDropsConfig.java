package bl4ckscor3.mod.getittogetherdrops;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = GetItTogetherDrops.MODID)
public class GetItTogetherDropsConfig implements ConfigData {
	@Comment("The radius (in blocks) that dropped items should check around them for other dropped items to combine with (\"0.5\" is vanilla behavior). Can be between 0.5 and 500.0")
	public double radius = 2.0D;
	@Comment("Set to true if you want dropped items to also check above and below them, set to false if not (\"false\" is vanilla behavior)")
	public boolean checkY = true;

	@Override
	public void validatePostLoad() throws ValidationException {
		if (radius < 0.5D || radius > 500.0D)
			radius = 2.0D;
	}
}