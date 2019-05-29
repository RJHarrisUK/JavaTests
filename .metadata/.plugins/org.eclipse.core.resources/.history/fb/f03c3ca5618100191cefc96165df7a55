package com.bae.blackjack.mainapp;

public class Blackjack{

	int card1 = 0;
	
	public static void main(String[] args) {
	
	}
	public int play(int player, int dealer) {
		if (player == 21) {
			return player;
		}
		else if ((player >3 && player <=21) && (dealer !=21 && (dealer >3 && dealer <30)) && player > dealer) {	
			return player;
		}
		else if (dealer == 21) {
			return dealer;
		}

		else if ((player<3 || dealer<3) || (player<3 && dealer <3)) {
			return -1;
		}
		else if ((player>30 || dealer>30) || (player>30 && dealer >30)) {
			return -1;
		}
		else if ((player>21 && player<30) && (dealer>21 && dealer<30)) {
			return 0;
		}
		else {
			return dealer;
		}
	
		}
	public int twist() {
		return card1=((int)(Math.random()*11)+1);
	}}