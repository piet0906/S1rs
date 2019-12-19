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

public class GroundSmashCustom {
	public Plugin plugin = Main.getPlugin(Main.class);
	public void customRecipe() 
	{
		ItemStack item = new ItemStack(Material.CLAY_BALL);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Utils.chat("GroundSmash"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Smash The Ground With A Enhanced Pickaxe");
		meta.setLore(lore);
		meta.setLocalizedName("groundsmash");
		item.setItemMeta(meta);
		
		@SuppressWarnings("deprecation")
		ShapedRecipe r = new ShapedRecipe(item);
		r.shape("CIC","IPI","CIC");
		r.setIngredient('C', Material.COBBLESTONE);
		r.setIngredient('I', Material.IRON_INGOT);
		r.setIngredient('P', Material.DIAMOND_PICKAXE);
		
		plugin.getServer().addRecipe(r);
	}
	
	public static ItemStack custom() {
		ItemStack item = new ItemStack(Material.CLAY_BALL);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Utils.chat("GroundSmash"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Smash The Ground With A Enhanced Pickaxe");
		meta.setLore(lore);
		meta.setLocalizedName("groundsmash");
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack customE() {
		ItemStack item = new ItemStack(Material.CLAY_BALL,1);
		ItemMeta meta = item.getItemMeta();

		meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		meta.setDisplayName(Utils.chat("Enhanced GroundSmash"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Improved GroundSmash");
		meta.setLore(lore);
		meta.setLocalizedName("groundsmashe");
		item.setItemMeta(meta);
		return item;
	}
}
