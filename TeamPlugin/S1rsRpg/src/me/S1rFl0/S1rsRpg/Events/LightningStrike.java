package me.S1rFl0.S1rsRpg.Events;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class LightningStrike {
	public static void trigger(Player player) {
		Location loc = player.getEyeLocation();
		Vector dir = loc.getDirection();
		double x = dir.getX()* 5;
		double y = dir.getY()* 5;
		double z = dir.getZ()* 5;
		loc.add(x,y,z);
		Location strike = player.getWorld().getHighestBlockAt(loc).getLocation();
		player.getWorld().strikeLightningEffect(strike);
		for(Entity e : strike.getChunk().getEntities()) 
		{
			if(!(e == player)) 
			{
    			((LivingEntity) e).damage(2.5);
			}
		}
}}
