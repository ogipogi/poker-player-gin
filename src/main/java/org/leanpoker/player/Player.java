package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

    static final String VERSION = "1.00";

    public static int betRequest(JsonElement request) {
        JsonObject json = request.getAsJsonObject();

        int dealer = json.get("dealer").getAsInt();
        int small_blind_player = dealer + 1;
        int big_blind_player = dealer + 2;
        int we = 0;

        JsonArray players = json.get("players").getAsJsonArray();
        for (JsonElement player : players) {
            JsonObject playerObject = player.getAsJsonObject();
            if (playerObject.get("name").getAsString().equals("Gin")) {
                we = playerObject.get("id").getAsInt();
            }
        }

        int small_blind = json.get("small_blind").getAsInt();
        int big_blind = small_blind * 2;

        if (small_blind_player == we) {
            return small_blind;
        }
        else if (big_blind_player == we) {
            return big_blind;
        }
        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
