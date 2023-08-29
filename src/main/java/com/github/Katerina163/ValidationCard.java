package com.github.Katerina163;

import java.util.Set;

public class ValidationCard {
    private final static Set<Character> FACE_VALUE = Set.of(
            '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'
    );
    private final static Set<Character> SUIT = Set.of('S', 'H', 'D', 'C');

    public static void validate(String card) throws IllegalArgumentException {
        if (card.length() != 2) {
            throw new IllegalArgumentException("Неверная карта " + card);
        }
        if (!FACE_VALUE.contains(card.charAt(0))) {
            throw new IllegalArgumentException("Неверный номинал карты " + card.charAt(0));
        }
        if (!SUIT.contains(card.charAt(1))) {
            throw new IllegalArgumentException("Неверная масть " + card.charAt(1));
        }
    }
}
