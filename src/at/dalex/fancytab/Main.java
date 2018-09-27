package at.dalex.fancytab;

import at.dalex.fancytab.config.Config;
import at.dalex.fancytab.util.TablistUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static String prefix = "§8[§5Fancy§6Tab§8] §7";
    private Config config;

    @Override
    public void onEnable() {
        saveResource("config.yml", false);

        config.load();
        getServer().getPluginManager().registerEvents(this, this);

        Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "§aPlugin has been loaded!");
    }

    @Override
    public void onDisable() {
        config.save();
        Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "The plugin has been disabled.");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        TablistUtil.sendTabList(e.getPlayer(), config.getHeader(), config.getFooter());
    }
}
