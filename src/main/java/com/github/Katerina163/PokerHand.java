package com.github.Katerina163;

public class PokerHand implements Comparable<PokerHand> {
    private final Combination combination;
    private final String[] cards;

    public PokerHand(String hand) {
        if (hand.length() != 14) {
            throw new IllegalArgumentException("Неверный набор карт");
        }
        cards = hand.split(" ");
        if (cards.length != 5) {
            throw new IllegalArgumentException("Неверное количество карт");
        }
        for (var card : cards) {
            ValidationCard.validate(card);
        }
        combination = CheckingCombination.checkCards(cards);
    }

    @Override
    public int compareTo(PokerHand ph) {
        return this.combination.compareTo(ph.combination);
    }
}