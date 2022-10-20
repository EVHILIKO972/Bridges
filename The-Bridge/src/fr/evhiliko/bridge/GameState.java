package fr.evhiliko.bridge;

public enum GameState {

    LOBBY(), PREGAME(), GAME(), END();

    private static GameState status;

    public static void setStatus(GameState statusS) {

        status = statusS;

    }

    public static boolean isStatus(GameState statusS) {

        return status == statusS;

    }

    public static GameState getStatus() {

        return status;

    }

}
