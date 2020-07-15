package ood_card;

public enum Suit {
	Club(0), Diamod(1), Heart(2), Spade(3);
	private int value;
	private Suit(int v) {
		this.value = v;
	}
	public int getValue() {
		return this.value;
	}
}
