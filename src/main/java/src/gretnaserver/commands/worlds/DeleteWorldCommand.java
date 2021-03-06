package src.gretnaserver.commands.worlds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import src.gretnaserver.utilities.Messages;

public class DeleteWorldCommand implements CommandExecutor {

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

        if (args == null) {
            player.sendMessage(ChatColor.RED + "Please provide a world to delete!");
            return false;
        }

        String name = args[0];
        if (Bukkit.getWorld(name) == null) {
            player.sendMessage(ChatColor.RED + "That is not a world!");
            return false;
        }

        Bukkit.unloadWorld(name, false);
        Bukkit.getWorld(name).getWorldFolder().delete();
        player.sendMessage(ChatColor.RED + "The world " + name + " was deleted!");

        return false;
    }

}
