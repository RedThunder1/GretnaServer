package src.gretnaserver.staff.ban;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import src.gretnaserver.utilities.Messages;

public class BanCommand implements CommandExecutor {

	private String toBan;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.CONSOLECANTUSE);
			return false;
		}
		Player player = (Player) sender;
		
		if (!(player.isOp())) {
			player.sendMessage(Messages.NOPERMS);
			return false;
		}
		
		if (!(args.length > 0)) {
			player.sendMessage(ChatColor.RED + "Please provide a player to ban!");
			return false;
		}
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (args[0].equals(p.getName())) {
				toBan = p.getName();
			} else {
				player.sendMessage(Messages.NOTPLAYER);
				return false;
			}
		}
		
		BanMenu.banMenu(player, toBan);
		
		
		return false;
	}
	
	

}
