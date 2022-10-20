package fr.evhiliko.bridge.runnable;

import fr.evhiliko.bridge.GameState;
import fr.evhiliko.bridge.Main;
import fr.evhiliko.bridge.utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PreGameRunnable extends BukkitRunnable {


    private static int waitingTimer = 5;
    public static boolean start = false;

    @Override
    public void run() {

        waitingTimer--;

        if (start == true) {

            if (waitingTimer == 3 || waitingTimer == 2 || waitingTimer == 1) {

                for (Player players : Bukkit.getOnlinePlayers()) {

                    TitleManager.sendTitle(players, "§6§l" + waitingTimer, "§7La partie (re)commence dans §e" + waitingTimer + " §7" + getSecond(waitingTimer), 20);
                    players.playSound(players.getLocation(), Sound.NOTE_PIANO, 1f, 1f);

                }

            } else if (waitingTimer == 0) {

                this.cancel();
                start = false;

                GameState.setStatus(GameState.GAME);

                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.setLevel(0);
                    players.playSound(players.getLocation(), Sound.LEVEL_UP, 1f, 1f);

                        TitleManager.sendTitle(players, Main.getPrefix(), "§eBonne chance !", 40);

                    players.setGameMode(GameMode.SURVIVAL);

                }

            }

            setLevel();

        }

    }

    public void setLevel() {

        for(Player players : Bukkit.getOnlinePlayers()) {

            players.setLevel(waitingTimer);
            /*if (ScoreboardManager.scoreboardGame.containsKey(players)) {

                ((ScoreboardSign) ScoreboardManager.scoreboardGame.get(players)).setLine(6, "§eDébut dans §a" + new SimpleDateFormat("mm:ss").format(new Date(LobbyRunnable.timer * 1000)));


            }*/

        }

    }

    private String getSecond(int time) {

        if (time == 1) { return "seconde";}
        return "secondes";

    }

}
