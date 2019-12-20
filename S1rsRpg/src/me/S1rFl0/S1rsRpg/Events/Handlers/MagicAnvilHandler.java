package me.S1rFl0.S1rsRpg.Events.Handlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.S1rFl0.S1rsRpg.Items.AirControlCustom;
import me.S1rFl0.S1rsRpg.Items.FireBallCustom;
import me.S1rFl0.S1rsRpg.Items.GroundSmashCustom;
import me.S1rFl0.S1rsRpg.Items.IceFanCustom;
import me.S1rFl0.S1rsRpg.Items.LightningStrikeCustom;
import me.S1rFl0.S1rsRpg.Utils.Utils;

public class MagicAnvilHandler implements Listener {
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
}
