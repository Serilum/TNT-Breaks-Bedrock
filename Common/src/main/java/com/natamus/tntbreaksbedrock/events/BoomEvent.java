package com.natamus.tntbreaksbedrock.events;

import com.natamus.collective.functions.ExplosionFunctions;
import com.natamus.tntbreaksbedrock.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class BoomEvent {
	public static void onExplosion(Level world, Entity sourceEntity, Explosion explosion) {
		if (world.isClientSide) {
			return;
		}
		
		List<BlockPos> affected = ExplosionFunctions.getAffectedBlockPositions(explosion);
		if (affected.size() == 0) {
			return;
		}
		
		if (!(sourceEntity instanceof PrimedTnt)) {
			return;
		}
		
		List<BlockPos> bedrocks = new ArrayList<BlockPos>();
		for (BlockPos pos : affected) {
			for (BlockPos bedpos : Util.getBedrocks(world, pos.immutable())) {
				if (!bedrocks.contains(bedpos.immutable())) {
					bedrocks.add(bedpos.immutable());
				}
			}
		}
		
		BlockState air = Blocks.AIR.defaultBlockState();
		for (BlockPos bedrock : bedrocks) {
			world.setBlockAndUpdate(bedrock, air);
		}
	}
}
