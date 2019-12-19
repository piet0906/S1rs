package me.S1rFl0.S1rsRpg.Items;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.S1rFl0.S1rsRpg.Main;
import me.S1rFl0.S1rsRpg.Utils.Utils;

public class AirControlCustom {
	public Plugin plugin = Main.getPlugin(Main.class);
	public void customRecipe() 
	{
		ItemStack item = new ItemStack(Material.FEATHER,1);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Utils.chat("AirControl"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Master The Air");
		meta.setLore(lore);
		meta.setLocalizedName("aircontrol");
		item.setItemMeta(meta);
		
		@SuppressWarnings("deprecation")
		ShapedRecipe r = new ShapedRecipe(item);
		r.shape("FWF","WEW","FWF");
		r.setIngredient('F', Material.FEATHER);
		r.setIngredient('W', Material.WOOL);
		r.setIngredient('E', Material.ENDER_PEARL);
		
		plugin.getServer().addRecipe(r);
		}
	
	public static ItemStack custom() {
		ItemStack item = new ItemStack(Material.FEATHER,1);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Utils.chat("AirControl"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Master The Air");
		meta.setLore(lore);
		meta.setLocalizedName("aircontrol");
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack customE() {
		ItemStack item = new ItemStack(Material.FEATHER,1);
		ItemMeta meta = item.getItemMeta();

		meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		meta.setDisplayName(Utils.chat("Enhanced AirControl"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Improved AirControl");
		meta.setLore(lore);
		meta.setLocalizedName("aircontrole");
		item.setItemMeta(meta);
		return item;
	}
}
