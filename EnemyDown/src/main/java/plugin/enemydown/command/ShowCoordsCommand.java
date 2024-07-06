package plugin.enemydown.command;



import static org.bukkit.Bukkit.getLogger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShowCoordsCommand implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    // コマンドがプレイヤーによって実行されたかどうかを確認
    if (sender instanceof Player) {
      Player player = (Player) sender;
      double x = player.getLocation().getX();
      double y = player.getLocation().getY();
      double z = player.getLocation().getZ();
      getLogger().info("MyPlugin has been disabled");  // デバッグログ

      // コンソールに座標を表示
      player.getServer().getLogger().info("Player " + player.getName() + " is at: X=" + x + " Y=" + y + " Z=" + z);

      // プレイヤーに座標を送信
      player.sendMessage("Your coordinates: X=" + x + " Y=" + y + " Z=" + z);
      return true;
    } else {
      sender.sendMessage("This command can only be run by a player.");
      return false;
    }
  }
}


