package me.S1rFl0.S1rsRpg.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.S1rFl0.S1rsRpg.Main;
import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;

public class GroundSmash {
	public static Plugin plugin = Main.getPlugin(Main.class);
	public static void trigger(Player player) {
		PotionEffect pot = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30, 5);
		player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
		player.addPotionEffect(pot);
		player.getWorld().createExplosion(player.getLocation(), 3);
		
        new BukkitRunnable(){
            double t = Math.PI/4;
	        float red = 0,green = 0,blue = 0;
            Location loc = player.getLocation();
            public void run(){
                    t = t + 0.1*Math.PI;
                    for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32){
                            double x = t*Math.cos(theta);
                            double y = 0;
                            double z = t*Math.sin(theta);
                            loc.add(x,y,z);
                            PacketPlayOutWorldParticles part = new PacketPlayOutWorldParticles(EnumParticle.EXPLOSION_NORMAL,true,(float)loc.getX(),(float)loc.getY(),(float)loc.getZ(),red,green,blue,(float)255,0,10);
                            loc.subtract(x,y,z);
                            for(Player p : Bukkit.getOnlinePlayers()) {
                                ((CraftPlayer) p).getHandle().playerConnection.sendPacket(part);
                                }
                            if (t > 10){
                                this.cancel();
                        }
                    }
            }
        }.runTaskTimer(plugin, 0, 1);
}}