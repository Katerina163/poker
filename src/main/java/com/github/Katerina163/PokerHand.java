package com.github.Katerina163;

public class PokerHand implements Comparable<PokerHand> {
    private final Combination combination;
    private final Card[] cards = new Card[5];

    public PokerHand(String hand) {
        if (hand.length() != 14) {
            throw new IllegalArgumentException("Неверный набор карт");
        }
        String[] handCard = hand.split(" ");
        if (handCard.length != 5) {
            throw new IllegalArgumentException("Неверное количество карт");
        }
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(handCard[i]);
        }
        combination = CheckingCombination.checkCards(cards);
    }

    public Combination getCombination() {
        return combination;
    }

    @Override
    public int compareTo(PokerHand ph) {
        return this.combination.compareTo(ph.combination);
    }
}