package me.S1rFl0.S1rsRpg.Items;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.S1rFl0.S1rsRpg.Main;
import me.S1rFl0.S1rsRpg.Utils.Utils;

public class FireBallCustom implements Listener {
	public Plugin plugin = Main.getPlugin(Main.class);
	public void customRecipe() 
	{
		ItemStack item = new ItemStack(Material.MAGMA_CREAM,1);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Utils.chat("&6FireBall"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Just A Plain Old FireBall");
		meta.setLore(lore);
		meta.setLocalizedName("fireball");
		item.setItemMeta(meta);
		
		@SuppressWarnings("deprecation")
		ShapedRecipe r = new ShapedRecipe(item);
		r.shape("CMC","MDM","CMC");
		r.setIngredient('M', Material.MAGMA);
		r.setIngredient('C', Material.MAGMA_CREAM);
		r.setIngredient('D', Material.DIAMOND);
		
		plugin.getServer().addRecipe(r);
		}
	
	public static ItemStack custom() {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM,1);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Utils.chat("&6FireBall"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Just A Plain Old FireBall");
		meta.setLore(lore);
		meta.setLocalizedName("fireball");
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack customE() {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM,1);
		ItemMeta meta = item.getItemMeta();

		meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		meta.setDisplayName(Utils.chat("&6Enhanced FireBall"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Improved FireBall");
		meta.setLore(lore);
		meta.setLocalizedName("fireballe");
		item.setItemMeta(meta);
		return item;
	}
}