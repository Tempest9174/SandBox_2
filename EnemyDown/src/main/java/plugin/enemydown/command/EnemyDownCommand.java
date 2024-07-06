package plugin.enemydown.command;

import java.util.ArrayList;
import org.bukkit.event.Listener;
import java.util.List;
import java.util.SplittableRandom;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import plugin.enemydown.data.PlayerScore;

public class EnemyDownCommand implements CommandExecutor, Listener{

    private List<PlayerScore> playerScoreList = new ArrayList<>();
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label,
      String[] args) {
    if (sender instanceof Player player){
      if(playerScoreList.isEmpty()) {
        PlayerScore newplayer = new PlayerScore();
        newplayer.setPlayerName(player.getName());
        playerScoreList.add(newplayer);
      }else{
        for(PlayerScore playerScore : playerScoreList )
          if(!playerScore.getPlayerName().equals(player.getName())){
            PlayerScore newplayer = new PlayerScore();
            newplayer.setPlayerName(player.getName());
            playerScoreList.add(newplayer);

          }
      World world = player.getWorld();

      player.setHealth(20);
      player.setFoodLevel(20);

      initPlayerStatus(player);

      //イベント修了

      List<EntityType> enemyList = List.of (EntityType.ZOMBIE,EntityType.SKELETON);
      int random = new SplittableRandom().nextInt(2) ;

      world.spawnEntity(getEnemySpawnLocation(player, world), enemyList.get(random));

    }
      return false;
  }

  @EventHandler
  public void onEnemyDeath(EntityDeathEvent e){
    Player player = e.getEntity().getKiller();
    if(this.player.getName().equals(player.getName())){
      score += 10;
      player.sendMessage("敵を倒した！スコアは"+ score + "点！");
    }
  }

  /**
   * ゲームを始める前の初期化
   * 体力・空腹満タン
   * 装備ダイア・ネザライト
   * @param player
   */
  private static void initPlayerStatus(Player player) {
    PlayerInventory inventory = player.getInventory();
    inventory.setHelmet(new ItemStack(Material.NETHERITE_HELMET));
    inventory.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
    inventory.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
    inventory.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
    inventory.setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
  }

  /**
   * 出現エリア取得
   * 出現X,Y軸で自分の位置からプラス、ランダム値-10～9
   * Yはプレイヤーと同じ
   * @param player コマンド実行者
   * @param world ワールド
   * @return 出現場所
   */
  private Location getEnemySpawnLocation(Player player, World world) {
    Location playerLocation = player.getLocation();
    int randomX = new SplittableRandom().nextInt(20) -10;
    int randomY = new SplittableRandom().nextInt(20) -10;

    double X = playerLocation.getX()+randomX;
    double Y = playerLocation.getY();
    double Z = playerLocation.getZ()+randomY;

    return new Location(world, X, Y, Z );
  }
}
