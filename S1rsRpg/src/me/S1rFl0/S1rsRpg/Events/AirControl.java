package me.S1rFl0.S1rsRpg.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.S1rFl0.S1rsRpg.Main;
import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;

public class AirControl {
	public static Plugin plugin = Main.getPlugin(Main.class);
	static int t = 0;
	public static void trigger(Player player) {
		PotionEffect pot = new PotionEffect(PotionEffectType.SPEED, 600, 1);
		player.addPotionEffect(pot);
		
		new BukkitRunnable() 
		{
            float red = 0,green = 0,blue = 0;
			@Override
			public void run() {
				t = t + 1;
				  Location loc = player.getLocation();
		            int radius = 2;
		            for(double y = 0; y <= 2; y+=0.05) {
		                double x = radius * Math.cos(y);
		                double z = radius * Math.sin(y);
		                loc.add(x,y,z);
		                PacketPlayOutWorldParticles part = new PacketPlayOutWorldParticles(EnumParticle.SPELL_INSTANT,true,(float) loc.getX(),(float) loc.getY(),(float) loc.getZ(),red, green, blue, (float)255, 0, 10);
		                loc.subtract(x,y,z);
	                     for(Player p : Bukkit.getOnlinePlayers()) {
	                         ((CraftPlayer) p).getHandle().playerConnection.sendPacket(part);
	                         }
				
			}
		
			if(t > 30) {
			this.cancel();	
			}
			}
		}.runTaskTimer(plugin, 0, 1);
	}
}