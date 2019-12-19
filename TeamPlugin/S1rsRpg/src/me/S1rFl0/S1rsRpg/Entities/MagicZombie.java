package me.S1rFl0.S1rsRpg.Entities;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;

import me.S1rFl0.S1rsRpg.Main;
import me.S1rFl0.S1rsRpg.Utils.Utils;

public class MagicZombie {
	public Plugin plugin = Main.getPlugin(Main.class);
	public void MagicZombieCreate(Player player,Location spawnloc) {
	Zombie z = (Zombie) player.getWorld().spawnEntity(spawnloc, EntityType.ZOMBIE);
	z.setTarget(player);
	z.setAI(true);
	z.setHealth(40);
	z.setGlowing(true);
	z.setCustomName("Magic Zombie");
	z.setCustomNameVisible(true);
	
	//Armor
	ItemStack boots = new ItemStack(Material.IRON_BOOTS,1);
	ItemStack legs = new ItemStack(Material.IRON_LEGGINGS,1);
	ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE, 1);
	ItemStack helmet = new ItemStack(Material.IRON_HELMET,1);
	ItemStack weapon = new ItemStack(Material.IRON_SPADE,1);
	
	ItemMeta meta = boots.getItemMeta();
	ItemMeta meta2 = legs.getItemMeta();
	ItemMeta meta3 = chest.getItemMeta();
	ItemMeta meta4 = helmet.getItemMeta();
	ItemMeta meta5 = weapon.getItemMeta();
	
	meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
	meta.setLocalizedName("cboots");
	meta.setDisplayName(Utils.chat("&8Corrupted Boots"));
	
	meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
	meta2.setLocalizedName("clegs");
	meta2.setDisplayName(Utils.chat("&8Corrupted Leggings"));
	
	meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
	meta3.setLocalizedName("cchest");
	meta3.setDisplayName(Utils.chat("&8Corrupted Chestplate"));
	
	meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
	meta4.setLocalizedName("chelmet");
	meta4.setDisplayName(Utils.chat("&8Corrupted Helmet"));
	
	meta5.addEnchant(Enchantment.DAMAGE_UNDEAD, 1, true);
	meta5.setLocalizedName("cweapon");
	meta5.setDisplayName("Corrupted Shovel Of Doom");
	
	boots.setItemMeta(meta);
	legs.setItemMeta(meta2);
	chest.setItemMeta(meta3);
	helmet.setItemMeta(meta4);
	weapon.setItemMeta(meta5);
	
	z.getEquipment().setBoots(boots);
	z.getEquipment().setLeggings(legs);
	z.getEquipment().setChestplate(chest);
	z.getEquipment().setHelmet(helmet);
	z.getEquipment().setItemInMainHand(weapon);
	}
	
	public ItemStack summonI() 
	{
		@SuppressWarnings("deprecation")
		ItemStack i = new MaterialData(Material.INK_SACK,(byte) 5).toItemStack(1);
		ItemMeta m = i.getItemMeta();
		
		m.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		m.setDisplayName("Seed Of Corruption");
		m.setLocalizedName("cseed");
		i.setItemMeta(m);
		return i;
	}
	
	public void summonICraft() {
	@SuppressWarnings("deprecation")
	ItemStack i = new MaterialData(Material.INK_SACK,(byte) 5).toItemStack(1);
	ItemMeta m = i.getItemMeta();
	
	m.addEnchant(Enchantment.ARROW_FIRE, 1, true);
	m.setDisplayName("Seed Of Corruption");
	m.setLocalizedName("cseed");
	i.setItemMeta(m);
	
	@SuppressWarnings("deprecation")
	ShapedRecipe r = new ShapedRecipe(i);
	r.shape("ICI","ICI","ICI");
	r.setIngredient('C', Material.COAL_BLOCK);
	r.setIngredient('I', Material.IRON_INGOT);
	
	plugin.getServer().addRecipe(r);
	}
}
