package me.S1rFl0.S1rsRpg.Events.Handlers;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.S1rFl0.S1rsRpg.Utils.Utils;

public class MagicMinerHandler implements Listener{
	
	//Magic Miner Gui
	@EventHandler
	public void onMenuClick(InventoryClickEvent e) 
	{	Inventory inv = e.getClickedInventory();
		if(inv.getTitle().equals(Utils.chat("&5Magic Miner"))) {
		{Player p = (Player) e.getWhoClicked();
				if(!(e.getCurrentItem().getItemMeta().getLocalizedName() == "NO")){
					if(e.getCurrentItem().getType() == Material.IRON_PICKAXE) {
					double a = 16;
					for(; a > 0; a--) 
					{int tempint = new Random().nextInt((8 - 0) + 1) + 0;
						if(tempint == 0) {p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.COAL_ORE,1));}
						else if(tempint == 1) {p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.IRON_ORE,1));}
						else if(tempint == 2) {p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.GOLD_ORE,1));}
						else if(tempint == 3) {p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.REDSTONE_ORE,1));}
						else if(tempint == 4) {p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.LAPIS_ORE,1));}
						else if(tempint == 5) {p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.EMERALD_ORE,1));}
						else if(tempint == 6) {p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.DIAMOND_ORE,1));}
						else if(tempint == 7) {p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.STONE,1));}
						else if(tempint == 8) {p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.COBBLESTONE,1));}
					}}
						p.closeInventory();
				}
			}
		}
	}
}