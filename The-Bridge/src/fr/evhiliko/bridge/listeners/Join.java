package fr.evhiliko.bridge.listeners;

import fr.evhiliko.bridge.GameState;
import fr.evhiliko.bridge.Main;
import fr.evhiliko.bridge.runnable.LobbyRunnable;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (!GameState.isStatus(GameState.LOBBY)) {

            event.setJoinMessage(null);
            player.kickPlayer("§c§lLa partie a commencé !");

        }

        new LobbyRunnable().runTaskTimer(Main.getInstance(), 0L, 20L);
        LobbyRunnable.start = true;

        event.setJoinMessage(Main.getPrefix() + "§6§l" + player.getName() + " §7a rejoint. (§a" + Bukkit.getOnlinePlayers().size() + "§7/§a2§7)");
        if (player.getName().equals("EVHILIKO972")) {

            player.getWorld().strikeLightningEffect(player.getLocation());

            for (Player p : Bukkit.getOnlinePlayers()) {

                p.playSound(player.getLocation(), Sound.WITHER_DEATH, 2f, 1f);

            }

        }

        player.teleport(new Location(Bukkit.getWorld("world"), 0.500, 116.500, 0.500, 90.0F, 0.0F));
        player.getInventory().clear();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);

        if (Main.getBlueTeam().size() == 0) {

            Main.getBlueTeam().add(player);

        } else if (Main.getBlueTeam().size() == 1) {

            Main.getRedTeam().add(player);

        }

    }

}
