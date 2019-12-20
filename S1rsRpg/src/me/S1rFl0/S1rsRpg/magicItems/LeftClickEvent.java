package me.S1rFl0.S1rsRpg.magicItems;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class LeftClickEvent implements Listener
{
	@EventHandler
	public void onLeftClick(PlayerInteractEvent e) 
	{
		if(e.getAction().equals(Action.LEFT_CLICK_BLOCK))
		{
			Player p = e.getPlayer();
		if(getItem(p).getItemMeta().getLocalizedName() == "minerspickaxe") {minersPickaxe.trigger(p);}
		}
	}
	public ItemStack getItem(Player player) 
	{
		ItemStack item = player.getInventory().getItemInMainHand();
		return item;
	}
}
