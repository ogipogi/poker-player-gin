package org.leanpoker.player;


import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

    static final String VERSION = "12.00";

    public static int betRequest(JsonElement request) {
        JsonObject json = request.getAsJsonObject();

        GameVO gameVO = getGameVO(json);


        PlayerVO currentPlayer = null;

        int currentBet = 0;
        List<PlayerVO> players = getPlayerVOList(json);
        for (PlayerVO player : players) {
            if (player.name.contains("Gin")) {
                currentPlayer = player;
                currentBet = player.bet;
                currentBet = gameVO.current_buy_in - currentBet;
            }
        }



        int found = 0;
        List<CardVO> hole_cards = currentPlayer.hole_cards;
        if (hole_cards.size() >= 2) {
            CardVO cardVO = currentPlayer.hole_cards.get(0);
            CardVO cardVO1 = currentPlayer.hole_cards.get(1);

            if (cardVO.rank.equals(cardVO1.rank)) {
                return Integer.MAX_VALUE;
            }

        }


//        for (JsonElement card: currentPlayer.hole_cards) {
//            JsonObject cardObject = card.getAsJsonObject();
//            if (cardObject.get("rank").getAsString().equals("10") || cardObject.get("rank").getAsString().equals("J") || cardObject.get("rank").getAsString().equals("Q") || cardObject.get("rank").getAsString().equals("K")) {
//
//                found++;
//            }
//
//
//
//        }
//        if (found == 2) {
//            return Integer.MAX_VALUE;
//        }


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
