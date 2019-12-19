package me.S1rFl0.S1rsRpg.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class S1rsRpgHelpMenu implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		p.sendMessage("-S1rsRpgHelp-");
		p.sendMessage("Nothing Yet");
		return true;
	}

}
