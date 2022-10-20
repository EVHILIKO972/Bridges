package fr.evhiliko.bridge.listeners;

import fr.evhiliko.bridge.GameState;
import fr.evhiliko.bridge.utils.Respawn;
import fr.evhiliko.bridge.utils.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Parameters implements Listener {

    Location pos1 = new Location(Bukkit.getWorld("world"), 7, 80, 13);
    Location pos2 = new Location(Bukkit.getWorld("world"), -7, 105, -13);

    Cuboid cube = new Cuboid(pos1, pos2);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        if (GameState.isStatus(GameState.PREGAME)) {

            event.setCancelled(true);

        }

        if ((GameState.isStatus(GameState.GAME)) && (player.getLocation().getY() <= 80)) {

            new Respawn(player);

        }

    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent event) {

        event.setCancelled(true);

    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Block block = event.getBlock();

        Player player = event.getPlayer();

        if (!(block.getType().equals(Material.STAINED_CLAY)) || !(block.getType().equals(Material.QUARTZ_BLOCK)) || (block.getZ() >= -13) || (block.getZ() >= 13)) {

            event.setCancelled(true);

        }

    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {

        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (!(cube.contains(block.getLocation()))) {

            event.setCancelled(true);

        }

    }

}
