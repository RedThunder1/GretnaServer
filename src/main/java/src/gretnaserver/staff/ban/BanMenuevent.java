package src.gretnaserver.staff.ban;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class BanMenuevent implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		String toBan;
		InventoryView inventory = event.getView();
		ItemStack item = event.getCurrentItem();
		
		
		if (inventory.getTitle().equals(ChatColor.RED + "" + ChatColor.BOLD + "Ban Menu")) {
			if (item.getItemMeta().getDisplayName().equals(ChatColor.RED + "Cheating/Hacking")) {
				toBan = inventory.getItem(1).getItemMeta().getDisplayName(); 
				BanList banList = Bukkit.getBanList(BanList.Type.NAME);
				banList.addBan(toBan, "You were banned for Cheating/Hacking", null, null);
				Bukkit.getPlayer(toBan).kickPlayer(ChatColor.RED + "You were banned for cheating/hacking by " + ChatColor.GREEN + player.getName());
				
			}
		}
		
	}
	
	

}
