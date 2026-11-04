package com.serilum.tntbreaksbedrock.util;

import com.serilum.tntbreaksbedrock.config.ConfigHandler;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class Util {
	public static boolean canExplosionBreakBedrock(Explosion explosion, BlockState blockState) {
		if (!blockState.is(Blocks.BEDROCK)) {
			return false;
		}

		if (ConfigHandler.anyExplosionBreaksBedrock) {
			return true;
		}

		return explosion.getDirectSourceEntity() instanceof PrimedTnt;
	}
}
