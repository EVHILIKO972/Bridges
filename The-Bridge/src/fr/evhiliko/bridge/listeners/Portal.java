package fr.evhiliko.bridge.listeners;

import fr.evhiliko.bridge.GameState;
import fr.evhiliko.bridge.Main;
import fr.evhiliko.bridge.utils.Respawn;
import fr.evhiliko.bridge.runnable.PreGameRunnable;
import fr.evhiliko.bridge.utils.EndGame;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class Portal implements Listener {

    @EventHandler
    public void onPortal(PlayerPortalEvent event) {

        event.setCancelled(true);

        Player player = event.getPlayer();

        if (Main.getRedTeam().contains(player)) {

            Main.setRedGoal(Main.getRedGoal() + 1);

        } else if (Main.getBlueTeam().contains(player)) {

            Main.setBlueGoal(Main.getBlueGoal() + 1);

        }

        if ((Main.getBlueGoal() == 5) || (Main.getRedGoal() == 5)) {

            new EndGame();

        }

        for (Player players : Bukkit.getOnlinePlayers()) {

            new Respawn(players);
            GameState.setStatus(GameState.PREGAME);
            new PreGameRunnable().runTaskTimer(Main.getInstance(), 0L, 20L);

        }

    }

}
