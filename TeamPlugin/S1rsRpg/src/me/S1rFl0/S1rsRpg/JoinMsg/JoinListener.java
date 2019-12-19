package me.S1rFl0.S1rsRpg.JoinMsg;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.S1rFl0.S1rsRpg.Utils.Utils;

public class JoinListener implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) 
	{	
		Player p = e.getPlayer();
		if(!p.hasPlayedBefore()) 
		{
			Bukkit.broadcastMessage(Utils.chat("&6Please Welcome " + p.getName() + "To The Realm" ));
		}else 
		{
			Bukkit.broadcastMessage(Utils.chat( p.getName() + "&6 Joined The Realm" ));
		}
	}
}
