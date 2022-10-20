package fr.evhiliko.bridge.runnable;

import fr.evhiliko.bridge.GameState;
import fr.evhiliko.bridge.Main;
import fr.evhiliko.bridge.utils.Respawn;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LobbyRunnable extends BukkitRunnable {

    public static int timer = 5;
    public static boolean start = false;

    public Player player;

    @Override
    public void run() {

        if (start == false) {

            this.cancel();
            timer = 6;

        }

        timer--;

        if(Bukkit.getOnlinePlayers().size() <= 1 || !(GameState.isStatus(GameState.LOBBY))) {

            this.cancel();
            Bukkit.broadcastMessage(Main.getPrefix() + "§c§lIl n'y a pas assez de joueurs pour débuter !");
            timer = 6;
            start = false;
            return;

        } else {

            start = true;

        }

        if ((timer == 5) || (timer == 4) || (timer == 3) || (timer == 2) || (timer == 1)) {


            Bukkit.broadcastMessage(Main.getPrefix() + "§eLa partie commence dans §a§l" + timer + " " + getSecond(timer));

            for (Player players : Bukkit.getOnlinePlayers()) {

                players.playSound(players.getLocation(), Sound.CHICKEN_EGG_POP, 1f, 1f);

            }

        }

        setLevel();

        if (timer == 0) {

            this.cancel();

            start = false;
            GameState.setStatus(GameState.GAME);

            for (Player players : Bukkit.getOnlinePlayers()) {

                timer = 6;
                new Respawn(players);

            }

        }

    }

    public void setLevel() {

        for(Player players : Bukkit.getOnlinePlayers()) {

            players.setLevel(timer);
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
