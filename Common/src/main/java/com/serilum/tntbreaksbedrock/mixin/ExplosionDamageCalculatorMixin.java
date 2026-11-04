package com.serilum.tntbreaksbedrock.mixin;

import com.serilum.tntbreaksbedrock.config.ConfigHandler;
import com.serilum.tntbreaksbedrock.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(value = ExplosionDamageCalculator.class, priority = 1001)
public class ExplosionDamageCalculatorMixin {
	@Inject(method = "getBlockExplosionResistance(Lnet/minecraft/world/level/Explosion;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/material/FluidState;)Ljava/util/Optional;", at = @At(value = "HEAD"), cancellable = true)
	public void getBlockExplosionResistance(Explosion explosion, BlockGetter blockGetter, BlockPos pos, BlockState blockState, FluidState fluidState, CallbackInfoReturnable<Optional<Float>> cir) {
		if (Util.canExplosionBreakBedrock(explosion, blockState)) {
			cir.setReturnValue(Optional.of((float)ConfigHandler.bedrockExplosionResistance));
		}
	}
}
