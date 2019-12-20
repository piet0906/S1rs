package me.S1rFl0.S1rsRpg.magicItems.itemRecipes;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.S1rFl0.S1rsRpg.Main;
import me.S1rFl0.S1rsRpg.Utils.Utils;

public class MinersPickaxe 
{
	public Plugin plugin = Main.getPlugin(Main.class);
	public void customRecipe() 
	{
		ItemStack item = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Utils.chat("Miners Pickaxe"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Move your pickaxe at HYPER speed");
		meta.setLore(lore);
		meta.setLocalizedName("minerspickaxe");
		item.setItemMeta(meta);
		
		@SuppressWarnings("deprecation")
		ShapedRecipe r = new ShapedRecipe(item);
		r.shape("CIC","IPI","CIC");
		r.setIngredient('C', Material.SUGAR);
		r.setIngredient('I', Material.IRON_INGOT);
		r.setIngredient('P', Material.IRON_PICKAXE);
		
		plugin.getServer().addRecipe(r);
	}
	public static ItemStack custom() 
	{
		ItemStack item = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Utils.chat("Miners Pickaxe"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Move your pickaxe at HYPER speed");
		meta.setLore(lore);
		meta.setLocalizedName("minerspickaxe");
		item.setItemMeta(meta);
		return item;
	}
}
