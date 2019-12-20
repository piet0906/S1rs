package me.S1rFl0.S1rsRpg.Events.Handlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.S1rFl0.S1rsRpg.Utils.Utils;

public class SpellLibraryHandler implements Listener {
	//Spell Library Gui
	@EventHandler
	public void onMenuClick2(InventoryClickEvent e) 
	{
		Inventory inv = e.getClickedInventory();
		if(inv.getTitle().contains(Utils.chat("&5Spell Library"))) 
		{Player p = (Player) e.getWhoClicked();
		if(!(e.getCurrentItem().getItemMeta().getLocalizedName() == "NO" || e.getCurrentItem().getItemMeta().getLocalizedName() == "BACK" || e.getCurrentItem().getItemMeta().getLocalizedName() == "NEXT")) 
		{
			spellLibraryEnd(p, e.getCurrentItem());
		}else if(e.getCurrentItem().getItemMeta().getLocalizedName() == "NO") {p.getItemOnCursor().setType(Material.AIR); p.closeInventory();
		}
			
		}
	}
	public void spellLibraryEnd(Player p,ItemStack i) 
	{
		p.getWorld().dropItem(p.getLocation(),i);
		p.getItemOnCursor().setType(Material.AIR);
		p.closeInventory();
	}
}
