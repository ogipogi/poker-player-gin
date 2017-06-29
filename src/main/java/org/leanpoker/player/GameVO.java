package org.leanpoker.player;

import java.util.List;

public class GameVO {
	public String tournament_id;
	public String game_id;
	public int round;
	public int bet_index;
	public int small_blind;
	public int orbits;
	public int dealer;
	public List<CardVO> community_cards;
	public int current_buy_in;
	public int pot;
}
