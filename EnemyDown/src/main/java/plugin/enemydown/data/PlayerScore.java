package plugin.enemydown.data;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

/**
 * ゲームを実行する際のスコアを扱うオブジェクト
 */
@Getter
@Setter
public class PlayerScore {
  private  int score;
  private String playerName;


}
