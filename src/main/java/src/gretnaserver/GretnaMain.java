package src.gretnaserver;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import src.gretnaserver.commands.worlds.CreateWorldCommand;
import src.gretnaserver.commands.worlds.DeleteWorldCommand;
import src.gretnaserver.commands.worlds.WorldTeleport;
import src.gretnaserver.events.OnPlayerJoin;
import src.gretnaserver.events.StaffChat;
import src.gretnaserver.staff.HealCommand;
import src.gretnaserver.staff.Launch;
import src.gretnaserver.staff.Vanish;
import src.gretnaserver.staff.ban.BanCommand;
import src.gretnaserver.staff.ban.BanMenuevent;

import java.util.Objects;

public class GretnaMain extends JavaPlugin {
    public static GretnaMain plugin;
    public static GretnaMain get() { return plugin; }

    //TOOD Make duel game
    //TODO Make CakeWars like game
    
    
    
    
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[!] Gretna Main has been ENABLED [!]");
        loadCommands();
        loadEvents();

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[!] Gretna Main has been DISABLED [!]");

    }

    @Override
    public void onLoad() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[!] Gretna Main has been LOADED [!]");

    }

    public void loadCommands() {
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new Vanish());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("launch")).setExecutor(new Launch());
        Objects.requireNonNull(getCommand("wcreate")).setExecutor(new CreateWorldCommand());
        Objects.requireNonNull(getCommand("wdelete")).setExecutor(new DeleteWorldCommand());
        Objects.requireNonNull(getCommand("wtp")).setExecutor(new WorldTeleport());
        Objects.requireNonNull(getCommand("ban")).setExecutor(new BanCommand());
    }

    public void loadEvents() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new OnPlayerJoin(), this);
        pluginManager.registerEvents(new StaffChat(), this);
        pluginManager.registerEvents(new BanMenuevent(), this);
    }

}
