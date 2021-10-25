package src.gretnaserver.staff.ban;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class BanMenu {

	
	public static void banMenu(Player player, String banedName) {
		
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.RED + "" + ChatColor.BOLD + "Ban Menu");
		for (int i = 0; i < 54; i++) {
			ItemStack blackGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getData());
			ItemMeta meta = blackGlass.getItemMeta();
			meta.setDisplayName("-");
			blackGlass.setItemMeta(meta);
			inventory.setItem(i, blackGlass);
		}
		
		ItemStack senderName = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta senderMeta = senderName.getItemMeta();
		senderMeta.setDisplayName(player.getName());
		senderName.setItemMeta(senderMeta);
		inventory.setItem(0, senderName);
		
		
		ItemStack toBanName = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta toBanMeta = toBanName.getItemMeta();
		toBanMeta.setDisplayName(banedName);
		toBanName.setItemMeta(toBanMeta);
		inventory.setItem(1, toBanName);
		
		ItemStack cheating = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta cheatingMeta = cheating.getItemMeta();
        cheatingMeta.setDisplayName(ChatColor.RED + "Cheating/Hacking");
        cheating.setItemMeta(cheatingMeta);
        inventory.setItem(22, cheating);

        ItemStack Harassment = new ItemStack(Material.REDSTONE, 1);
        ItemMeta harassmentMeta = Harassment.getItemMeta();
        harassmentMeta.setDisplayName(ChatColor.RED + "Harassment / Threats");
        Harassment.setItemMeta(harassmentMeta);
        inventory.setItem(24, Harassment);

        ItemStack swearing = new ItemStack(Material.INK_SACK, 1);
        ItemMeta swearingMeta = swearing.getItemMeta();
        swearingMeta.setDisplayName(ChatColor.RED + "Swearing / Inappropriate topics");
        swearing.setItemMeta(swearingMeta);
        inventory.setItem(20, swearing);
        
        
        ItemStack custom = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta customMeta = custom.getItemMeta();
        customMeta.setDisplayName(ChatColor.RED + "Custom Reason");
        custom.setItemMeta(customMeta);
        inventory.setItem(54, custom);
        
        player.openInventory(inventory);
        
	}
	
	
}
