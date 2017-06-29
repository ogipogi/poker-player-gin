package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        JsonObject json = request.getAsJsonObject();
        int smallBlind = json.get("small_blind").getAsInt();

        return 0 + smallBlind * 2;
    }

    public static void showdown(JsonElement game) {
    }
}
