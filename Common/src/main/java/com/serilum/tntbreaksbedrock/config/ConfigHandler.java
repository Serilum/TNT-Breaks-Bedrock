package com.serilum.tntbreaksbedrock.config;

import com.natamus.collective.config.DuskConfig;
import com.serilum.tntbreaksbedrock.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<>();

	@Entry(min = 0, max = 1200) public static double bedrockExplosionResistance = 9.0;
	@Entry public static boolean anyExplosionBreaksBedrock = false;

	public static void initConfig() {
		configMetaData.put("bedrockExplosionResistance", Arrays.asList(
			"How resistant bedrock is to explosions that can break it. Stone has 6, end stone 9 and obsidian 1200, which TNT can't break."
		));
		configMetaData.put("anyExplosionBreaksBedrock", Arrays.asList(
			"Whether every explosion can break bedrock, instead of only TNT."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}
