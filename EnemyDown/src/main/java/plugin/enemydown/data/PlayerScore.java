package plugin.enemydown.data;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

/**
 * ゲームを実行する際のスコアを扱うオブジェクト
 */

public class PlayerScore {
  private  int score;
  private String playerName;

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }
}