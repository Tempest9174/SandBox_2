package plugin.enemydown;



import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.ShowCoordsCommand;

import plugin.enemydown.command.EnemyDownCommand;

public class MyPlugin extends JavaPlugin {
  @Override
  public void onEnable() {
    // コマンドを登録
    this.getCommand("showcoords").setExecutor(new ShowCoordsCommand());
  }

/*
  @Override
  public void onDisable() {
    // プラグイン無効化時の処理（必要に応じて追加）
  }
*/
}


