package me.S1rFl0.S1rsRpg.Events;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AirControl {
	
	public static void trigger(Player player) {
		PotionEffect pot = new PotionEffect(PotionEffectType.SPEED, 600, 0);
		player.addPotionEffect(pot);
}}
