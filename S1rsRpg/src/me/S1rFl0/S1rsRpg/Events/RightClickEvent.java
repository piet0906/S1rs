package me.S1rFl0.S1rsRpg.Events;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.S1rFl0.S1rsRpg.CombineGui;
import me.S1rFl0.S1rsRpg.MagicGrowthChamberGui;
import me.S1rFl0.S1rsRpg.MagicMinerGui;
import me.S1rFl0.S1rsRpg.SpellLibraryGui;

public class RightClickEvent implements Listener{
		@EventHandler		
		public void onRightClick(PlayerInteractEvent e)	{
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			Player p = e.getPlayer();
			if(getItem(p).getItemMeta().getLocalizedName() == "fireball") {FireBall.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "groundsmash") {GroundSmash.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "icefan") {IceFan.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "icefane") {IceFanEnhanced.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "aircontrol") {AirControl.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "aircontrole") {AirControlEnhanced.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "lightningstrike") {LightningStrike.trigger(p);}
			else if(getItem(p).getItemMeta().getLocalizedName() == "lightningstrikee") {LightningStrikeEnhanced.trigger(p);}
		}}
		public ItemStack getItem(Player player) {
			ItemStack item = player.getInventory().getItemInMainHand();
			return item;
		}
		//Magic WorkBenches
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
				if(e.getClickedBlock().getType() == Material.DIAMOND_BLOCK && e.getClickedBlock().getRelative(BlockFace.DOWN).getType() == Material.HOPPER && e.getClickedBlock().getRelative(BlockFace.UP).getType() == Material.ANVIL) 
				{
					Player p = e.getPlayer();
					Inventory inv = MagicMinerGui.GUI(p);
					p.openInventory(inv);
				}
				if(e.getClickedBlock().getType() == Material.CAULDRON && e.getClickedBlock().getRelative(BlockFace.UP).getType() == Material.STAINED_GLASS) 
				{
					Player p = e.getPlayer();
					Inventory inv = MagicGrowthChamberGui.GUI(p);
					p.openInventory(inv);
				}
			}
		}
		
}
			