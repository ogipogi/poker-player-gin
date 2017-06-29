package org.leanpoker.player;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import junit.framework.Assert;

public class PlayerVOTest {

	public String request = "{\n" +
            "      \"name\":\"Player 1\",\n" +
            "      \"stack\":1000,\n" +
            "      \"status\":\"active\",\n" +
            "      \"bet\":0,\n" +
            "      \"hole_cards\":[" +
            "{\n" +
            "      \"rank\":\"K\",\n" +
            "      \"suit\":spades\n" +
            "    }" 
            + "],\n" +
            "      \"version\":\"Version name 1\",\n" +
            "      \"id\":0\n" +
            "    }";
	
	@Test
	public void test_des() {
		Gson gson = new GsonBuilder().create();
		PlayerVO playerVO = gson.fromJson(request, PlayerVO.class);
		
		Assert.assertEquals("Player 1", playerVO.name);
		Assert.assertEquals("K", playerVO.hole_cards.get(0).rank);
	}

}
