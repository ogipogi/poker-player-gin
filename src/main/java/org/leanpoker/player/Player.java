package org.leanpoker.player;


import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

    static final String VERSION = "19.00";

    public static int betRequest(JsonElement request) {
        JsonObject json = request.getAsJsonObject();

        GameVO gameVO = getGameVO(json);




        PlayerVO currentPlayer = null;

        int currentBet = 0;
        List<PlayerVO> players = gameVO.players;
        for (PlayerVO player : players) {
            if (player.name.contains("Gin")) {
                currentPlayer = player;
                currentBet = player.bet;
                currentBet = gameVO.current_buy_in - currentBet;

            }
        }

        StarthandEvaluator evaluator = new StarthandEvaluator();

        StarthandEvaluator.StarthandQuality evaluate = evaluator.evaluate(currentPlayer.hole_cards);


        switch (evaluate) {

            case VeryGood:
            case Good:
                return Integer.MAX_VALUE;

            case Middle:
                return currentBet;

            case Bad:
                return 0;
        }

    return 0;
    }
    
    public static GameVO getGameVO(JsonElement request) {
    	Gson gson = new GsonBuilder().create();
		return gson.fromJson(request, GameVO.class);
    }

    public static void showdown(JsonElement game) {

    }
}
