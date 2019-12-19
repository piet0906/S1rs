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

public class IceFan {
	public static Plugin plugin = Main.getPlugin(Main.class);
	public static void trigger(Player player) {
		
		new BukkitRunnable(){                          
    double t = 0;
    float red = 0,green = 0,blue = 0;
    Location loc = player.getLocation();
    public void run(){
            t = t + 1;
            Vector direction = loc.getDirection().normalize();
            double x = direction.getX() * t;
            double y = direction.getY() * t + 1.5;
            double z = direction.getZ() * t;
            loc.add(x,y,z);
            PacketPlayOutWorldParticles part = new PacketPlayOutWorldParticles(EnumParticle.SPELL_INSTANT,true,(float) loc.getX(),(float) loc.getY(),(float) loc.getZ(),red, green, blue, (float)255, 0, 10);
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
            }
            loc.subtract(x,y,z);
            for(Player p : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(part);
            }

    if (t > 30){
            this.cancel();
    }
    }
}.runTaskTimer(plugin, 0, 1);
}


}

