package me.S1rFl0.S1rsRpg.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.S1rFl0.S1rsRpg.Main;
import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;

public class FireBallEnhanced {
	public static Plugin plugin = Main.getPlugin(Main.class);
	public static void trigger(Player p) {
		 new BukkitRunnable(){                          
             double t = 0;
             double r = 16;
             float red = 0,green = 0,blue = 0;
             Location loc = p.getLocation();
             public void run(){
                     t = t + 1;
                     Vector direction = loc.getDirection().normalize();
                     int i = 0;
                     for(; i < 30; i++) {
                     double x = direction.getX() * t  * i / r;
                     double y = direction.getY() * t  * i * r / 6;
                     double z = direction.getZ() * t  * i / r;
                     loc.add(x,y,z);
                     PacketPlayOutWorldParticles part = new PacketPlayOutWorldParticles(EnumParticle.FLAME,true,(float) loc.getX(),(float) loc.getY(),(float) loc.getZ(),red, green, blue, (float)255, 0, 10);
                     loc.subtract(x,y,z);
                     for(Player p : Bukkit.getOnlinePlayers()) {
                     ((CraftPlayer) p).getHandle().playerConnection.sendPacket(part);
                     }}

             if (t > 30){
                     this.cancel();
             }
             }
     }.runTaskTimer(plugin, 0, 1);
	}
}
