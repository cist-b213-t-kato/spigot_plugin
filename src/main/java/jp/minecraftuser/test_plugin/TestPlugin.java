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

public class TestPlugin extends JavaPlugin implements Listener {
    /**
     * 起動時処理
     */
    @Override
    public void onEnable() {
        getLogger().info("test enable: OMMC");
        // イベントリスナーの登録
        getServer().getPluginManager().registerEvents(this, this);
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

    /**
     * プレイヤーがクリックした時に呼び出されるメソッド
     * @param event
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        getLogger().info("execute!!!");
        // ブロック左クリックでもブロック右クリックでもなければ無視する
        if ( event.getAction() != Action.RIGHT_CLICK_BLOCK &&
                event.getAction() != Action.LEFT_CLICK_BLOCK ) {
        	getLogger().info("" + event.getAction());
            return;
        }

        // クリック先が看板でなければ無視する
        Block block = event.getClickedBlock();
        if ( block == null) {
        	getLogger().info("block == null");
        	return;
        }

        if (block.getType() != Material.ACACIA_SIGN) {
        	getLogger().info("block.getType(): " + block.getType());
            return;
        }

        getLogger().info("block.getState");
        Sign sign = (Sign)block.getState();
        getLogger().info("sign: " + sign);
        sign.setLine(0, "hogehoge");
        sign.setLine(1, "piyopiyo");
        sign.update();
    }
}
