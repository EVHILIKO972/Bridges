package fr.evhiliko.bridge.utils;

import fr.evhiliko.bridge.Main;
import fr.evhiliko.bridge.items.GiveItems;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Respawn {

    public Respawn(Player player) {

        EntityDamageByEntityEvent damager = (EntityDamageByEntityEvent) player.getLastDamageCause();
        EntityDamageEvent damage = player.getLastDamageCause();

        if (Main.getRedTeam().contains(player)) {

            player.teleport(new Location(Bukkit.getWorld("world"), 0.500, 91, 13.500, 180.0F, 0.0F));
            new GiveItems(player);

        } else if (Main.getBlueTeam().contains(player)) {

            player.teleport(new Location(Bukkit.getWorld("world"), 0.500, 91, -13.500, 0.0F, 0.0F));
            new GiveItems(player);

        }

        if (damage != null) {

            Bukkit.broadcastMessage("§c" + player.getName() + " §7a été tué par " + damager.getDamager().getName());

        } else {

            Bukkit.broadcastMessage("§c" + player.getName() + " §7est mort.");

        }

        player.setHealth(20);

    }

}
