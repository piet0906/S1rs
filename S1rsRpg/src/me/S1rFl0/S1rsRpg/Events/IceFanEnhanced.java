package me.S1rFl0.S1rsRpg.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.S1rFl0.S1rsRpg.Main;
import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;

public class IceFanEnhanced {
	public static Plugin plugin = Main.getPlugin(Main.class);
	public static void trigger(Player player) {
		
		new BukkitRunnable(){                          
    double t = 0;
    float red = 0,green = 0,blue = 0;
    Location loc = player.getLocation();
    Location loc2 = player.getLocation();
    public void run(){
            t = t + 1;
            Vector direction = loc.getDirection().normalize();
            double x = direction.getX() * t;
            double y = direction.getY() * t + 1.5;
            double z = direction.getZ() * t;
            double x2 = direction.getX() * t;
            double y2 = direction.getY() * 1.5 * t + 1.5;
            double z2 = direction.getZ() * t;
            loc.add(x,y,z);
            loc2.add(x2,y2,z2);
            PacketPlayOutWorldParticles part = new PacketPlayOutWorldParticles(EnumParticle.SPELL_INSTANT,true,(float) loc.getX(),(float) loc.getY(),(float) loc.getZ(),red, green, blue, (float)255, 0, 10);
            PacketPlayOutWorldParticles part2 = new PacketPlayOutWorldParticles(EnumParticle.SPELL_INSTANT,true,(float) loc2.getX(),(float) loc2.getY(),(float) loc2.getZ(),red, green, blue, (float)255, 0, 10);
            for(Entity e : loc.getChunk().getEntities()) 
            {
           	if (e.getLocation().distance(loc) < 1.0)
           	{
           		if(!e.equals(player)) 
           		{
        			PotionEffect pot = new PotionEffect(PotionEffectType.SLOW,20,1);
        			((LivingEntity) e).damage(2.5);
        			((LivingEntity) e).addPotionEffect(pot);
           		}
           	}
           	for(Entity e2 : loc2.getChunk().getEntities()) 
            {
           	if (e2.getLocation().distance(loc2) < 1.0)
           	{
           		if(!e.equals(player)) 
           		{
        			PotionEffect pot = new PotionEffect(PotionEffectType.SLOW,20,1);
        			((LivingEntity) e2).damage(2.5);
        			((LivingEntity) e2).addPotionEffect(pot);
           		}
           	}
            }
            }
            loc.subtract(x,y,z);
            loc2.subtract(x2,y2,z2);
            for(Player p : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(part);
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(part2);
            }

    if (t > 30){
            this.cancel();
    }
    }
}.runTaskTimer(plugin, 0, 1);
}


}

