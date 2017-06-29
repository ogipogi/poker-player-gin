package org.leanpoker.player;

import java.util.List;

public class StarthandEvaluator {
	public enum StarthandQuality {
		VeryGood
	}
	
	
	/*
	 * Very good 
	 * A & A
	 * K & K
	 * Q & Q
	 * A & K
	 * A & K
	 */
	
	public void evaluate(List<CardVO> cardList) {
		if (cardList.get(0).rank.equals("A") && cardList.get(1).rank.equals("A")) {
			//StarthandQuality.VeryGood;
		}
		
		
		
	}
}
