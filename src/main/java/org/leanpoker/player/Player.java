package org.leanpoker.player;


import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

    static final String VERSION = "17.00";

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

        int found = 0;
        List<CardVO> hole_cards = currentPlayer.hole_cards;
        if (hole_cards.size() >= 2) {
            CardVO cardVO = currentPlayer.hole_cards.get(0);
            CardVO cardVO1 = currentPlayer.hole_cards.get(1);

            if (cardVO.rank.equals(cardVO1.rank)) {
                return Integer.MAX_VALUE;
            }

        }


        for (CardVO card: hole_cards) {
            if (card.rank.equals("10") || card.rank.equals("J") || card.rank.equals("Q") || card.rank.equals("K")) {
                found++;
            }



        }
//        if (found == 2) {
//            return Integer.MAX_VALUE;
//        }



        return currentBet + 100;
    }
    
    public static GameVO getGameVO(JsonElement request) {
    	Gson gson = new GsonBuilder().create();
		return gson.fromJson(request, GameVO.class);
    }

    public static void showdown(JsonElement game) {

    }
}
