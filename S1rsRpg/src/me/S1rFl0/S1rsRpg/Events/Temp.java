package me.S1rFl0.S1rsRpg.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;

public class Temp {
	public static void trigger(Player p) {
		Location loc = p.getLocation();
		Vector dir = loc.getDirection();
		double yaw = p.getLocation().getYaw();
		double pitch = p.getLocation().getPitch();
		double t = 3;
		double r = 1;
		
		double d = Math.sin(pitch) * r; 
		
        float red = 0,green = 0,blue = 0;
		
		double x = dir.getX() * t;
		double y = dir.getY() * t + 1.5;
		double z = dir.getZ() * t;
		loc.add(x,y,z);
		//set punt op loc
		PacketPlayOutWorldParticles part = new PacketPlayOutWorldParticles(EnumParticle.FLAME,true,(float) loc.getX(),(float) loc.getY(),(float) loc.getZ(),red, green, blue, (float)255, 0, 10);
		
		//linker puntje
		double x2 = loc.getX() + Math.sin(yaw) * r;
		double y2 = loc.getY();
		double z2 = loc.getZ() - Math.cos(yaw) * r;
		
		Location loc2 = new Location(p.getWorld(),x2,y2,z2);
		
		PacketPlayOutWorldParticles part2 = new PacketPlayOutWorldParticles(EnumParticle.FLAME,true,(float) loc2.getX(),(float) loc2.getY(),(float) loc2.getZ(),red, green, blue, (float)255, 0, 10);
		
		//rechter puntje
		double x3 = loc.getX() - Math.sin(yaw) * r;
		double y3 = loc.getY();
		double z3 = loc.getZ() + Math.cos(yaw) * r;
		
		Location loc3 = new Location(p.getWorld(),x3,y3,z3);
		
		PacketPlayOutWorldParticles part3 = new PacketPlayOutWorldParticles(EnumParticle.FLAME,true,(float) loc3.getX(),(float) loc3.getY(),(float) loc3.getZ(),red, green, blue, (float)255, 0, 10);
		
		//boven puntje
		double x4 = loc.getX() + Math.sin(yaw) * d;
		double y4 = loc.getY() + Math.sin(pitch) * r - Math.cos(pitch) * r;
		double z4 = loc.getZ() + Math.sin(yaw) * d;
		
		Location loc4 = new Location(p.getWorld(),x4,y4,z4);
		
		PacketPlayOutWorldParticles part4 = new PacketPlayOutWorldParticles(EnumParticle.FLAME,true,(float) loc4.getX(),(float) loc4.getY(),(float) loc4.getZ(),red, green, blue, (float)255, 0, 10);
		
		//onder puntje
		double x5 = loc.getX() - Math.sin(yaw) * d;
		double y5 = loc.getY() - Math.sin(pitch) * r+ Math.cos(pitch) * r;
		double z5 = loc.getZ() - Math.sin(yaw) * d;
		
		Location loc5 = new Location(p.getWorld(),x5,y5,z5);
		
		PacketPlayOutWorldParticles part5 = new PacketPlayOutWorldParticles(EnumParticle.FLAME,true,(float) loc5.getX(),(float) loc5.getY(),(float) loc5.getZ(),red, green, blue, (float)255, 0, 10);
		
        for(Player p1 : Bukkit.getOnlinePlayers()) {
        ((CraftPlayer) p1).getHandle().playerConnection.sendPacket(part);
        ((CraftPlayer) p1).getHandle().playerConnection.sendPacket(part2);
        ((CraftPlayer) p1).getHandle().playerConnection.sendPacket(part3);
        ((CraftPlayer) p1).getHandle().playerConnection.sendPacket(part4);
        ((CraftPlayer) p1).getHandle().playerConnection.sendPacket(part5);
        }}}
