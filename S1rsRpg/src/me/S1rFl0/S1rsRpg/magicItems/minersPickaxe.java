package me.S1rFl0.S1rsRpg.magicItems;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class minersPickaxe 
{
	public static void trigger(Player player) 
	{
		PotionEffect pot = new PotionEffect(PotionEffectType.FAST_DIGGING, 10, 9);
		player.addPotionEffect(pot);
	}
}
