package me.S1rFl0.S1rsRpg.Events;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AirControlEnhanced {
	
	public static void trigger(Player player) {
		PotionEffect pot = new PotionEffect(PotionEffectType.SPEED, 600, 1);
		player.addPotionEffect(pot);
		PotionEffect pot2 = new PotionEffect(PotionEffectType.JUMP, 600, 2);
		player.addPotionEffect(pot2);
}}
