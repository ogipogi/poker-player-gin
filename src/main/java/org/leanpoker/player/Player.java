package org.leanpoker.player;


import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

    static final String VERSION = "14.00";

    public static int betRequest(JsonElement request) {
        return Integer.MAX_VALUE;
    }
    
    public static GameVO getGameVO(JsonElement request) {
    	Gson gson = new GsonBuilder().create();
		return gson.fromJson(request, GameVO.class);
    }

    public static void showdown(JsonElement game) {
    }
}
