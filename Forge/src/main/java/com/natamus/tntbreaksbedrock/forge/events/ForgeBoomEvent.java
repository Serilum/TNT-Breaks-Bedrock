package com.natamus.tntbreaksbedrock.forge.events;

import com.natamus.tntbreaksbedrock.events.BoomEvent;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeBoomEvent {
	@SubscribeEvent
	public static void onExplosion(ExplosionEvent.Detonate e) {
		Explosion explosion = e.getExplosion();
		BoomEvent.onExplosion(e.getLevel(), explosion.getDirectSourceEntity(), explosion);
	}
}
