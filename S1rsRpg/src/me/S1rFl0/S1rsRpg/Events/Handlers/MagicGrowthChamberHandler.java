package me.S1rFl0.S1rsRpg.Events.Handlers;
 
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.S1rFl0.S1rsRpg.Utils.Utils;

public class MagicGrowthChamberHandler implements Listener{
	public ItemStack i;
	
	@EventHandler
	public void onMenuClick(InventoryClickEvent e) 
	{Inventory inv = e.getClickedInventory();
	if(inv.getTitle().equals(Utils.chat("&5Magic Growth Chamber"))) {
		Player p = (Player) e.getWhoClicked();
		if(!(e.getCurrentItem().getItemMeta().getLocalizedName() == "NO")){
			if(e.getCurrentItem().getType() == Material.SEEDS) {i = new ItemStack(Material.WHEAT);}
			else if(e.getCurrentItem().getType() == Material.MELON_SEEDS) {i = new ItemStack(Material.MELON);}
			else if(e.getCurrentItem().getType() == Material.PUMPKIN_SEEDS) {i = new ItemStack(Material.PUMPKIN);}
			else if(e.getCurrentItem().getType() == Material.BEETROOT_SEEDS) {i = new ItemStack(Material.BEETROOT);}
			for(double am = e.getCurrentItem().getAmount() / 4; am > 0; am--) {
				
				p.getWorld().dropItem(p.getLocation(), i);
			}
	}
		p.closeInventory();
	}
		
	}
	


}
