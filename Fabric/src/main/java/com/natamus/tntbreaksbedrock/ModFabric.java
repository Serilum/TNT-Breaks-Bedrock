package com.natamus.tntbreaksbedrock;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.fabric.callbacks.CollectiveExplosionEvents;
import com.natamus.tntbreaksbedrock.events.BoomEvent;
import com.natamus.tntbreaksbedrock.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		CollectiveExplosionEvents.EXPLOSION_DETONATE.register((Level world, Entity sourceEntity, Explosion explosion) -> {
			BoomEvent.onExplosion(world, sourceEntity, explosion);
		});
	}

	private static void setGlobalConstants() {

	}
}
