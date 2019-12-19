package me.S1rFl0.S1rsRpg.Items;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;

import me.S1rFl0.S1rsRpg.Main;
import me.S1rFl0.S1rsRpg.Utils.Utils;

public class IceFanCustom {
	public Plugin plugin = Main.getPlugin(Main.class);
	@SuppressWarnings("deprecation")
	public void customRecipe() 
	{
		
		ItemStack item = new MaterialData(Material.INK_SACK,(byte) 12).toItemStack(1);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Utils.chat("&3IceFan"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Shoot Freezing Cold Ice Daggers");
		meta.setLore(lore);
		meta.setLocalizedName("icefan");
		item.setItemMeta(meta);
		
		ShapedRecipe r = new ShapedRecipe(item);
		r.shape("IPI","PSP","IPI");
		r.setIngredient('I', Material.ICE);
		r.setIngredient('P', Material.PACKED_ICE);
		r.setIngredient('S', Material.IRON_SWORD);
		
		plugin.getServer().addRecipe(r);
		}
	
	@SuppressWarnings("deprecation")
	public static ItemStack custom() {
		ItemStack item = new MaterialData(Material.INK_SACK,(byte) 12).toItemStack(1);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Utils.chat("&3IceFan"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Shoot Freezing Cold Ice Daggers");
		meta.setLore(lore);
		meta.setLocalizedName("icefan");
		item.setItemMeta(meta);
		return item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack customE() 
	{
		ItemStack item = new MaterialData(Material.INK_SACK,(byte) 12).toItemStack(1);
		ItemMeta meta = item.getItemMeta();
		
		meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		meta.setDisplayName(Utils.chat("&3Enhanced IceFan"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Improved IceFan");
		meta.setLore(lore);
		meta.setLocalizedName("icefane");
		item.setItemMeta(meta);
		return item;
		
		
	}
	}

