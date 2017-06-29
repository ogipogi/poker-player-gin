package org.leanpoker.player;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import junit.framework.Assert;

public class CardVOTest {

	public String request = "{\n" +
            "      \"rank\":\"K\",\n" +
            "      \"suit\":spades\n" +
            "    }";

	@Test
	public void test() {
		Gson gson = new GsonBuilder().create();
		CardVO cardVO = gson.fromJson(request, CardVO.class);
		
		Assert.assertEquals("K", cardVO.rank);
	}

}
