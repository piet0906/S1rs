package me.S1rFl0.S1rsRpg;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.S1rFl0.S1rsRpg.Events.RightClickEvent;
import me.S1rFl0.S1rsRpg.Events.Handlers.MagicAnvilHandler;
import me.S1rFl0.S1rsRpg.Events.Handlers.MagicGrowthChamberHandler;
import me.S1rFl0.S1rsRpg.Events.Handlers.MagicMinerHandler;
import me.S1rFl0.S1rsRpg.Events.Handlers.SpellLibraryHandler;
import me.S1rFl0.S1rsRpg.Items.AirControlCustom;
import me.S1rFl0.S1rsRpg.Items.FireBallCustom;
import me.S1rFl0.S1rsRpg.Items.GroundSmashCustom;
import me.S1rFl0.S1rsRpg.Items.IceFanCustom;
import me.S1rFl0.S1rsRpg.Items.LightningStrikeCustom;
import me.S1rFl0.S1rsRpg.JoinMsg.JoinListener;
import me.S1rFl0.S1rsRpg.magicItems.LeftClickEvent;
import me.S1rFl0.S1rsRpg.magicItems.itemRecipes.MinersPickaxe;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("(!) S1rsRpg Starting");

		Bukkit.getPluginManager().registerEvents(new RightClickEvent(),this);
		Bukkit.getPluginManager().registerEvents(new LeftClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new MagicAnvilHandler(),this);
		Bukkit.getPluginManager().registerEvents(new SpellLibraryHandler(),this);
		Bukkit.getPluginManager().registerEvents(new MagicMinerHandler(),this);
		Bukkit.getPluginManager().registerEvents(new MagicGrowthChamberHandler(), this);
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		
		FireBallCustom fireball = new FireBallCustom();
		fireball.customRecipe();
		GroundSmashCustom groundsmash = new GroundSmashCustom();
		groundsmash.customRecipe();
		IceFanCustom icefan = new IceFanCustom();
		icefan.customRecipe();
		AirControlCustom aircontrol = new AirControlCustom();
		aircontrol.customRecipe();
		LightningStrikeCustom lightningstrike = new LightningStrikeCustom();
		lightningstrike.customRecipe();
		
		MinersPickaxe minerspickaxe = new MinersPickaxe();
		minerspickaxe.customRecipe();


	}

	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public void onDisable() {
		System.out.println("(!) S1rsRpg Shutting Down");		
	}
}
