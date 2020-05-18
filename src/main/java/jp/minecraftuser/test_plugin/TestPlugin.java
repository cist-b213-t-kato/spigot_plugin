package jp.minecraftuser.test_plugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {
    /**
     * 起動時処理
     */
    @Override
    public void onEnable() {
        getLogger().info("test enable: OMMC");
        // イベントリスナーの登録
        getServer().getPluginManager().registerEvents(new KanbanListener(this), this);
    }

    /**
     * 終了時処理
     */
    @Override
    public void onDisable() {
        getLogger().info("test disable");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Command, Test Plugin!");
        return true;
    }
}
