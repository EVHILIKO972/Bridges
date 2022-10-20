package fr.evhiliko.bridge;

import fr.evhiliko.bridge.listeners.ListenersManager;
import fr.evhiliko.bridge.runnable.LobbyRunnable;
import fr.evhiliko.bridge.utils.WorldManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    private static Main instance;

    public static List<Player> blueTeam;
    public static List<Player> redTeam;

    private static int redGoal;
    private static int blueGoal;

    @Override
    public void onEnable() {
        instance = this;
        setup();
    }

    private void setup() {

        new ListenersManager(this).registerListeners();
        GameState.setStatus(GameState.LOBBY);
        new LobbyRunnable().runTaskTimer(this, 0L, 20L);
        LobbyRunnable.start = true;
        blueTeam = new ArrayList<>();
        redTeam = new ArrayList<>();

        redGoal = 0;
        blueGoal = 0;

    }

    @Override
    public void onDisable() {

        WorldManager.replaceWorld(true);

    }

    public static Main getInstance() {
        return instance;
    }

    public static String getPrefix() {

        return "§0§l [ §5§lNERIO §0§l] ";

    }

    public static List<Player> getBlueTeam() {
        return blueTeam;
    }

    public static List<Player> getRedTeam() {
        return redTeam;
    }

    public static int getRedGoal() {
        return redGoal;
    }

    public static void setRedGoal(int redGoal) {
        Main.redGoal = redGoal;
    }

    public static int getBlueGoal() {
        return blueGoal;
    }

    public static void setBlueGoal(int blueGoal) {
        Main.blueGoal = blueGoal;
    }
}
