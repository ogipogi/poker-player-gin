package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

    static final String VERSION = "8.00";

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




        JsonArray hole_cards = json.get("hole_cards").getAsJsonArray();


        int found = 0;
        JsonObject card1 = hole_cards.get(0).getAsJsonObject();
        JsonObject card2 = hole_cards.get(1).getAsJsonObject();

        if (card1.get("rank").getAsString().equals(card2.get("rank").getAsString())) {
            return Integer.MAX_VALUE;
        }

        for (JsonElement card: hole_cards) {
            JsonObject cardObject = card.getAsJsonObject();
            if (cardObject.get("rank").getAsString().equals("10") || cardObject.get("rank").getAsString().equals("J") || cardObject.get("rank").getAsString().equals("Q") || cardObject.get("rank").getAsString().equals("K")) {

                found++;
            }



        }
        if (found == 2) {
            return Integer.MAX_VALUE;
        }

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
