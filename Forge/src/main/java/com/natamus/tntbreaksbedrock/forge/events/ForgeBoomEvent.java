package com.natamus.tntbreaksbedrock.forge.events;

import com.natamus.tntbreaksbedrock.events.BoomEvent;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeBoomEvent {
	@SubscribeEvent
	public void onExplosion(ExplosionEvent.Detonate e) {
		Explosion explosion = e.getExplosion();
		BoomEvent.onExplosion(e.getWorld(), explosion.getExploder(), explosion);
	}
}
