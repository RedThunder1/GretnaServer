package src.gretnaserver.staff;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import src.gretnaserver.utilities.Messages;

public class HealCommand implements CommandExecutor {
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

        if (args.length == 0) {
            player.setHealth(20);
            player.setFoodLevel(20);
            player.sendMessage(ChatColor.GREEN + "You have been healed!");
            return false;
        }

        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!(args[0].equals(p.getName()))) {
                player.sendMessage(Messages.NOTPLAYER);
            }
        }

        Player player1 = Bukkit.getPlayer(args[0]);
        player1.setHealth(20);
        player1.setFoodLevel(20);
        player1.sendMessage(ChatColor.GREEN + "You have been healed by " + player.getName() + "!");
        return false;
    }


}
