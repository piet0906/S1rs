package me.S1rFl0.S1rsRpg;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.S1rFl0.S1rsRpg.Items.AirControlCustom;
import me.S1rFl0.S1rsRpg.Items.FireBallCustom;
import me.S1rFl0.S1rsRpg.Items.GroundSmashCustom;
import me.S1rFl0.S1rsRpg.Items.IceFanCustom;
import me.S1rFl0.S1rsRpg.Items.LightningStrikeCustom;
import me.S1rFl0.S1rsRpg.Utils.Utils;

public class SpellLibraryGui {
	public static Inventory GUI (Player p,int page) 
	{
		String invName = Utils.chat("&5Spell Library " + page);
		int invBoxes = 5;
		int total = invBoxes * 9;
		

		Inventory toReturn = Bukkit.createInventory(p, total, invName);
		
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName("Cancel");
		meta.setLocalizedName("NO");
		item.setItemMeta(meta);
		
		ItemStack back = new ItemStack(Material.ARROW,1);
		ItemMeta metab = back.getItemMeta();
		
		metab.setDisplayName("Back");
		metab.setLocalizedName("BACK");
		back.setItemMeta(metab);
		
		ItemStack next = new ItemStack(Material.ARROW,1);
		ItemMeta metan = next.getItemMeta();
		
		metan.setDisplayName("Next");
		metan.setLocalizedName("NEXT");
		next.setItemMeta(metan);
		
		toReturn.setItem(0, item);
		toReturn.setItem(1, item);
		toReturn.setItem(2, item);
		toReturn.setItem(3, item);
		toReturn.setItem(4, item);
		toReturn.setItem(5, item);
		toReturn.setItem(6, item);
		toReturn.setItem(7, item);
		toReturn.setItem(8, item);
		
		toReturn.setItem(9, item);
		toReturn.setItem(17, item);
		
		toReturn.setItem(18, item);
		toReturn.setItem(26, item);
		
		toReturn.setItem(27, item);
		toReturn.setItem(35, item);
		
		toReturn.setItem(36, item);
		toReturn.setItem(37, item);
		toReturn.setItem(38, back);
		toReturn.setItem(39, item);
		toReturn.setItem(40, item);
		toReturn.setItem(41, item);
		toReturn.setItem(42, next);
		toReturn.setItem(43, item);
		toReturn.setItem(44, item);
		
		toReturn.setContents(toReturn.getContents());
		return toReturn;
	}
	
	public static Inventory p1(Player p) 
	{
		Inventory inv = GUI(null, 1);
		inv.addItem(FireBallCustom.custom());
		inv.addItem(FireBallCustom.customE());
		inv.addItem(GroundSmashCustom.custom());
		inv.addItem(GroundSmashCustom.customE());
		inv.addItem(IceFanCustom.custom());
		inv.addItem(IceFanCustom.customE());
		inv.addItem(AirControlCustom.custom());
		inv.addItem(AirControlCustom.customE());
		inv.addItem(LightningStrikeCustom.custom());
		inv.addItem(LightningStrikeCustom.customE());
		
		return inv;
	}
}
