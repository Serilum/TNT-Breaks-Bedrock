package com.natamus.tntbreaksbedrock.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class Util {
	public static List<BlockPos> getBedrocks(Level world, BlockPos p) {
		List<BlockPos> bedrocks = new ArrayList<BlockPos>();

		for (BlockPos bp : BlockPos.betweenClosed(p.getX(), p.getY() - 1, p.getZ(), p.getX(), p.getY() + 1, p.getZ())) {
			if (world.getBlockState(bp).getBlock().equals(Blocks.BEDROCK)) {
				bedrocks.add(bp.immutable());
			}
		}
		
		return bedrocks;
	}
}
