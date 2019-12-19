package me.S1rFl0.S1rsRpg;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.S1rFl0.S1rsRpg.Utils.Utils;

public class CombineGui {

	public static Inventory GUI (Player p) 
	{
		String invName = Utils.chat("&5Magic Anvil");
		int invBoxes = 1;
		int total = invBoxes * 9;
		

		Inventory toReturn = Bukkit.createInventory(p, total, invName);
		
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName("Cancel");
		meta.setLocalizedName("NO");
		item.setItemMeta(meta);
		
		toReturn.setItem(0, item);
		toReturn.setItem(1, item);
		toReturn.setItem(2, item);
		toReturn.setItem(4, item);
		toReturn.setItem(6, item);
		toReturn.setItem(7, item);
		toReturn.setItem(8, item);
		
		toReturn.setContents(toReturn.getContents());
		return toReturn;
	}
}
