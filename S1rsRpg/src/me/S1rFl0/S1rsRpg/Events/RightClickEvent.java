package me.S1rFl0.S1rsRpg.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.S1rFl0.S1rsRpg.CombineGui;
import me.S1rFl0.S1rsRpg.SpellLibraryGui;
import me.S1rFl0.S1rsRpg.Entities.MagicZombie;
import me.S1rFl0.S1rsRpg.Items.AirControlCustom;
import me.S1rFl0.S1rsRpg.Items.FireBallCustom;
import me.S1rFl0.S1rsRpg.Items.GroundSmashCustom;
import me.S1rFl0.S1rsRpg.Items.IceFanCustom;
import me.S1rFl0.S1rsRpg.Items.LightningStrikeCustom;
import me.S1rFl0.S1rsRpg.Utils.Utils;

public class RightClickEvent implements Listener{
		@EventHandler		
		public void onRightClick(PlayerInteractEvent e)	{
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			Player p = e.getPlayer();
			if(getItem(p).getItemMeta().getLocalizedName() == "fireball") {FireBall.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "fireballe") {FireBallEnhanced.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "groundsmash") {GroundSmash.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "icefan") {IceFan.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "icefane") {IceFanEnhanced.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "aircontrol") {AirControl.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "aircontrole") {AirControlEnhanced.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "lightningstrike") {LightningStrike.trigger(p);}
		}}
		public ItemStack getItem(Player player) {
			ItemStack item = player.getInventory().getItemInMainHand();
			return item;
		}
		//Magic Anvil
		@EventHandler
		public void onRightClick2(PlayerInteractEvent e) 
		{
			if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				if(e.getClickedBlock().getType() == Material.BOOKSHELF)
				{
					Player p = e.getPlayer();
					Inventory inv = SpellLibraryGui.p1(p);
					p.openInventory(inv);
				}
				if(e.getClickedBlock().getType() == Material.IRON_BLOCK) 
				{
					Player p = e.getPlayer();
					Inventory inv = CombineGui.GUI(p);
					p.openInventory(inv);
				}
			}
		}
		//Magic Anvil Gui
		@EventHandler
		public void onMenuClick(InventoryClickEvent e) 
		{	Inventory inv = e.getClickedInventory();
			if(inv.getTitle().equals(Utils.chat("&5Magic Anvil"))) {
			{Player p = (Player) e.getWhoClicked();
					if(!(e.getCurrentItem().getItemMeta().getLocalizedName() == "NO")){
					if(inv.getItem(3).getItemMeta().getLocalizedName() == "fireball" && inv.getItem(5).getItemMeta().getLocalizedName() == "fireball") {
						clearMagicAnvil(inv, p);
						p.getWorld().dropItem(p.getLocation(), FireBallCustom.customE());
					}else if(inv.getItem(3).getItemMeta().getLocalizedName() == "groundsmash" && inv.getItem(5).getItemMeta().getLocalizedName() == "groundsmash") {
						clearMagicAnvil(inv, p);
						p.getWorld().dropItem(p.getLocation(), GroundSmashCustom.customE());
					}else if(inv.getItem(3).getItemMeta().getLocalizedName() == "icefan" && inv.getItem(5).getItemMeta().getLocalizedName() == "icefan") {
						clearMagicAnvil(inv, p);
						p.getWorld().dropItem(p.getLocation(), IceFanCustom.customE());
					}else if(inv.getItem(3).getItemMeta().getLocalizedName() == "aircontrol" && inv.getItem(5).getItemMeta().getLocalizedName() == "aircontrol") {
						clearMagicAnvil(inv, p);
						p.getWorld().dropItem(p.getLocation(), AirControlCustom.customE());
					}else if(inv.getItem(3).getItemMeta().getLocalizedName() == "lightningstrike" && inv.getItem(5).getItemMeta().getLocalizedName() == "lightningstrike") {
						clearMagicAnvil(inv, p);
						p.getWorld().dropItem(p.getLocation(), LightningStrikeCustom.customE());	
						
					}}else {
						p.getItemOnCursor().setType(Material.AIR);
						p.closeInventory();
						}

					}
			}}
		
		public void clearMagicAnvil(Inventory inv,Player p) 
		{	
			inv.clear();
			p.closeInventory();
		}
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
		
		//Summoning Handler
		@EventHandler
		public void summoningH(PlayerInteractEvent e)
		{
			Player p = e.getPlayer();
			Location loc = e.getClickedBlock().getLocation();
			loc.add(0,2,0);
			if(p.getInventory().getItemInMainHand().getItemMeta().getLocalizedName() == "cseed") {MagicZombie.MagicZombieCreate(p, loc);}

		}
}
			