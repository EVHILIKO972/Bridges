package fr.evhiliko.bridge.utils;

import fr.evhiliko.bridge.Main;
import fr.evhiliko.bridge.items.GiveItems;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;

public class CagesUtils {


    public static List<Location> cages = new ArrayList<>();

    public CagesUtils() {

        cages.add(new Location(Bukkit.getWorld("world"), 0.500, 91, -13.500, 0.0F, 0.0F));
        cages.add(new Location(Bukkit.getWorld("world"), 0.500, 91, 13.500, 180.0F, 0.0F));

    }

    public static void teleportPlayerToCages(Player player){

        int listMax = cages.size();
        Random random = new Random();
        int choice = random.nextInt(listMax);


        Location cage = cages.get(choice);
        player.teleport(cage);



        if (player.getLocation().equals(new Location(Bukkit.getWorld("world"), 0.500, 91, -13.500))) {

            Main.getBlueTeam().add(player);
            new GiveItems(player);

        } else if (player.getLocation().equals(new Location(Bukkit.getWorld("world"), 0.500, 91, 13.500))) {

            Main.getRedTeam().add(player);
            new GiveItems(player);

        }

        cages.remove(cage);

    }

}
