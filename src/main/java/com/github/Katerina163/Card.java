package com.github.Katerina163;

public class Card {
    private final char faceValue;
    private final char suit;

    public Card(String card) {
        ValidationCard.validate(card);
        faceValue = card.charAt(0);
        suit = card.charAt(1);
    }

    public char getFaceValue() {
        return faceValue;
    }

    public char getSuit() {
        return suit;
    }
}
