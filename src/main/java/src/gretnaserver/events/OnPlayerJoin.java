package src.gretnaserver.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!(player.hasPlayedBefore())) {
            event.setJoinMessage(ChatColor.GREEN + player.getName() + " has joined the server for the first time!");
        } else {
            event.setJoinMessage(ChatColor.GREEN + player.getName() + " has joined the server!");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage(ChatColor.RED + player.getName() + " has left the game!");

    }

}
