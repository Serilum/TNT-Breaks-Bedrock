package com.natamus.tntbreaksbedrock.forge.events;

import com.natamus.tntbreaksbedrock.events.BoomEvent;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeBoomEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeBoomEvent.class);

		ExplosionEvent.Detonate.BUS.addListener(ForgeBoomEvent::onExplosion);
	}

	@SubscribeEvent
	public static void onExplosion(ExplosionEvent.Detonate e) {
		Explosion explosion = e.getExplosion();
		BoomEvent.onExplosion(e.getLevel(), explosion.getDirectSourceEntity(), explosion);
	}
}
