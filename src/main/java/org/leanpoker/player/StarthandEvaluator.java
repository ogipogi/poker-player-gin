package org.leanpoker.player;

import java.util.List;

public class StarthandEvaluator {
	public enum StarthandQuality {
		VeryGood,
		Good,
		Middle,
		Bad
	}
	
	public StarthandQuality evaluate(List<CardVO> cardList) {
		CardVO card_1 = cardList.get(0);
		CardVO card_2 = cardList.get(1);
		if (card_1.rank.equals("A") && card_2.rank.equals("A") 
				|| card_1.rank.equals("K") && card_2.rank.equals("K")
				|| card_1.rank.equals("Q") && card_2.rank.equals("Q")
				|| card_1.rank.equals("A") && card_2.rank.equals("K")
				|| card_1.rank.equals("A") && card_2.rank.equals("Q")) {
			return StarthandQuality.VeryGood;
		}
		else if (card_1.rank.equals("J") && card_2.rank.equals("J")
				|| card_1.rank.equals("10") && card_2.rank.equals("10") 
				|| card_1.rank.equals("9") && card_2.rank.equals("9")
				|| card_1.rank.equals("8") && card_2.rank.equals("8")
				|| card_1.rank.equals("A") && card_2.rank.equals("Q")
				|| card_1.rank.equals("A") && card_2.rank.equals("J")
				|| card_1.rank.equals("A") && card_2.rank.equals("10")
				|| card_1.rank.equals("K") && card_2.rank.equals("Q")) {
			return StarthandQuality.Good;
		}
		else if (card_1.rank.equals("7") && card_2.rank.equals("7")
				|| card_1.rank.equals("6") && card_2.rank.equals("6") 
				|| card_1.rank.equals("5") && card_2.rank.equals("5")
				|| card_1.rank.equals("4") && card_2.rank.equals("4")
				|| card_1.rank.equals("3") && card_2.rank.equals("3")
				|| card_1.rank.equals("2") && card_2.rank.equals("2")
				
				|| card_1.rank.equals("A") && card_2.rank.equals("9")
				|| card_1.rank.equals("A") && card_2.rank.equals("8")
				|| card_1.rank.equals("A") && card_2.rank.equals("7")
				|| card_1.rank.equals("A") && card_2.rank.equals("6")
				|| card_1.rank.equals("A") && card_2.rank.equals("5")
				|| card_1.rank.equals("A") && card_2.rank.equals("4")
				|| card_1.rank.equals("A") && card_2.rank.equals("3")
				|| card_1.rank.equals("A") && card_2.rank.equals("2")
				
				|| card_1.rank.equals("K") && card_2.rank.equals("J")
				|| card_1.rank.equals("K") && card_2.rank.equals("10")
				|| card_1.rank.equals("K") && card_2.rank.equals("9")
				
				|| card_1.rank.equals("Q") && card_2.rank.equals("10")
				|| card_1.rank.equals("Q") && card_2.rank.equals("9")
				
				|| card_1.rank.equals("J") && card_2.rank.equals("10")) {
			return StarthandQuality.Middle;
		}
		return StarthandQuality.Bad;
	}

	public StarthandQuality evaluateFlop(List<CardVO> flopList, List<CardVO> cardList) {
		CardVO card_1 = cardList.get(0);
		CardVO card_2 = cardList.get(1);
		CardVO flop_1 = cardList.get(0);
		CardVO flop_2 = cardList.get(1);
		CardVO flop_3 = cardList.get(2);

		int A = evaluateCards("A", card_1, card_2, flop_1, flop_2, flop_3);
		int K = evaluateCards("K", card_1, card_2, flop_1, flop_2, flop_3);
		int Q = evaluateCards("Q", card_1, card_2, flop_1, flop_2, flop_3);
		int J = evaluateCards("J", card_1, card_2, flop_1, flop_2, flop_3);


		if (card_1.rank.equals("A") && card_2.rank.equals("A")
				|| card_1.rank.equals("K") && card_2.rank.equals("K")
				|| card_1.rank.equals("Q") && card_2.rank.equals("Q")
				|| card_1.rank.equals("A") && card_2.rank.equals("K")
				|| card_1.rank.equals("A") && card_2.rank.equals("Q")) {
			return StarthandQuality.VeryGood;
		}
		else if (card_1.rank.equals("J") && card_2.rank.equals("J")
				|| card_1.rank.equals("10") && card_2.rank.equals("10")
				|| card_1.rank.equals("9") && card_2.rank.equals("9")
				|| card_1.rank.equals("8") && card_2.rank.equals("8")
				|| card_1.rank.equals("A") && card_2.rank.equals("Q")
				|| card_1.rank.equals("A") && card_2.rank.equals("J")
				|| card_1.rank.equals("A") && card_2.rank.equals("10")
				|| card_1.rank.equals("K") && card_2.rank.equals("Q")) {
			return StarthandQuality.Good;
		}
		else if (card_1.rank.equals("7") && card_2.rank.equals("7")
				|| card_1.rank.equals("6") && card_2.rank.equals("6")
				|| card_1.rank.equals("5") && card_2.rank.equals("5")
				|| card_1.rank.equals("4") && card_2.rank.equals("4")
				|| card_1.rank.equals("3") && card_2.rank.equals("3")
				|| card_1.rank.equals("2") && card_2.rank.equals("2")

				|| card_1.rank.equals("A") && card_2.rank.equals("9")
				|| card_1.rank.equals("A") && card_2.rank.equals("8")
				|| card_1.rank.equals("A") && card_2.rank.equals("7")
				|| card_1.rank.equals("A") && card_2.rank.equals("6")
				|| card_1.rank.equals("A") && card_2.rank.equals("5")
				|| card_1.rank.equals("A") && card_2.rank.equals("4")
				|| card_1.rank.equals("A") && card_2.rank.equals("3")
				|| card_1.rank.equals("A") && card_2.rank.equals("2")

				|| card_1.rank.equals("K") && card_2.rank.equals("J")
				|| card_1.rank.equals("K") && card_2.rank.equals("10")
				|| card_1.rank.equals("K") && card_2.rank.equals("9")

				|| card_1.rank.equals("Q") && card_2.rank.equals("10")
				|| card_1.rank.equals("Q") && card_2.rank.equals("9")

				|| card_1.rank.equals("J") && card_2.rank.equals("10")) {
			return StarthandQuality.Middle;
		}
		return StarthandQuality.Bad;
	}

	private int evaluateCards(String card, CardVO card_1, CardVO card_2, CardVO flop_1, CardVO flop_2, CardVO flop_3) {
		int count = 0;
		if (card_1.rank.equals(card) || card_2.rank.equals(card) ||
				flop_1.rank.equals(card)||flop_2.rank.equals(card)||flop_3.rank.equals(card)) {
			count++;
		}
		return count;
	}

}
