package fr.evhiliko.bridge.utils;

import fr.evhiliko.bridge.GameState;
import fr.evhiliko.bridge.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;

public class EndGame {

    public EndGame() {

        if (GameState.isStatus(GameState.LOBBY)) {

            return;

        }

        GameState.setStatus(GameState.END);

        if (Main.getRedGoal() == 5) {

            Bukkit.getOnlinePlayers().forEach(p -> {

                if (Main.getRedTeam().contains(p)) {

                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.getWorld().strikeLightningEffect(p.getLocation());

                    TitleManager.sendTitle(p, "§6§lVICTOIRE", "§7§lVous avez gagné la partie !", 200);

                } else if (Main.getBlueTeam().contains(p)) {

                    p.setGameMode(GameMode.SPECTATOR);

                    TitleManager.sendTitle(p, "§c§lDEFAITE", "§7§lVous avez perdu la partie !", 200);

                }

            });

        } else if (Main.getBlueGoal() == 5) {

            Bukkit.getOnlinePlayers().forEach(p -> {

                if (Main.getBlueTeam().contains(p)) {

                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.getWorld().strikeLightningEffect(p.getLocation());

                    TitleManager.sendTitle(p, "§6§lVICTOIRE", "§7§lVous avez gagné la partie !", 200);

                } else if (Main.getRedTeam().contains(p)) {

                    p.setGameMode(GameMode.SPECTATOR);

                    TitleManager.sendTitle(p, "§c§lDEFAITE", "§7§lVous avez perdu la partie !", 200);

                }

            });

        }

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                Bukkit.spigot().restart();

            }
        }, 220L);

    }


}
