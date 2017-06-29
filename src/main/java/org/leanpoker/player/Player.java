package org.leanpoker.player;


import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

    static final String VERSION = "11.00";

    public static int betRequest(JsonElement request) {
        JsonObject json = request.getAsJsonObject();

        GameVO gameVO = getGameVO(json);


        int currentBet = 0;
        List<PlayerVO> players = getPlayerVOList(json);
        for (PlayerVO player : players) {
            if (player.name.contains("Gin")) {

                currentBet = player.bet;
                currentBet = gameVO.current_buy_in - currentBet;
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


        return currentBet;
    }
    
    public static GameVO getGameVO(JsonElement request) {
    	Gson gson = new GsonBuilder().create();
		return gson.fromJson(request, GameVO.class);
    }
    
    public static List<PlayerVO> getPlayerVOList(JsonElement request) {
    	Gson gson = new GsonBuilder().create();
    	PlayerVO[] playerVOs = gson.fromJson(request, PlayerVO[].class);
    	return Arrays.asList(playerVOs);
    }

    public static void showdown(JsonElement game) {
    }
}
