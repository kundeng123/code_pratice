package ood_card;

import java.util.ArrayList;

public class Deck <T extends Card>{
	private ArrayList<T> cards;
	private int dealtIndex = 0; //dealt means 分掉了的牌
	public Deck() {
		// TODO Auto-generated constructor stub
	}
	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		this.cards = deckOfCards;
	}
	public void shuffle() {
		System.out.println("Shuffle cards");
	}
	public int remiainingCards() {
		return cards.size() - dealtIndex;
	}
	public T[] dealHand(int number) {
		//the cards held in a card game by a given player at any given time
	}
	

}
