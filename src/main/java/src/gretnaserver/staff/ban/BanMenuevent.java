package src.gretnaserver.staff.ban;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class BanMenuevent implements Listener {
	
	public List<Player> customReason = new ArrayList<Player>();
	public String toBan; 
	public BanList banList;
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		InventoryView inventory = event.getView();
		ItemStack item = event.getCurrentItem();
		
		
		if (inventory.getTitle().equals(ChatColor.RED + "" + ChatColor.BOLD + "Ban Menu")) {
			String itemName = ChatColor.stripColor(item.getItemMeta().getDisplayName());
			banList = Bukkit.getBanList(BanList.Type.NAME);
			switch(itemName) {
				case "Cheating/Hacking":
					toBan = inventory.getItem(1).getItemMeta().getDisplayName(); 
					banList.addBan(toBan, "You were banned for Cheating/Hacking", null, null);
					Bukkit.getPlayer(toBan).kickPlayer(ChatColor.RED + "You were banned for Cheating / Hacking by " + ChatColor.GREEN + player.getName());
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ChatColor.GREEN + "Banned " + toBan + " for Cheating / Hacking!");
					break;
				case "Harassment / Threats":
					toBan = inventory.getItem(1).getItemMeta().getDisplayName(); 
					banList.addBan(toBan, "You were banned for Harassment / Threats", null, null);
					Bukkit.getPlayer(toBan).kickPlayer(ChatColor.RED + "You were banned for Harassment / Threats by " + ChatColor.GREEN + player.getName());
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ChatColor.GREEN + "Banned " + toBan + " for Harassment / Threats!");
					break;
				case "Swearing / Inappropriate topics":
					toBan = inventory.getItem(1).getItemMeta().getDisplayName(); 
					banList.addBan(toBan, "You were banned for Swearing / Inappropriate Topics", null, null);
					Bukkit.getPlayer(toBan).kickPlayer(ChatColor.RED + "You were banned for Harassment / Threats by " + ChatColor.GREEN + player.getName());
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ChatColor.GREEN + "Banned " + toBan + " for Swearing / Inappropriate Topics!");
					break;
				case "Custom Reason":
					customReason.add(player);
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ChatColor.RED + "Please type the reason for the ban.");
					toBan = inventory.getItem(1).getItemMeta().getDisplayName(); 
					break;
				default:
					event.setCancelled(true);
			}
			
		}
		
	}
	
	@EventHandler
	public void onMsg(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String msg = event.getMessage();
		if (customReason.contains(player)) {
			event.setCancelled(true);
			customReason.remove(player);
			banList.addBan(toBan, ChatColor.RED + msg + " by " + player.getName(), null, null);
			Bukkit.getPlayer(toBan).kickPlayer(ChatColor.RED + msg + " by " + player.getName());
			player.sendMessage(ChatColor.GREEN + "Banned " + toBan + " for " + msg);
		}
		
	}

}
