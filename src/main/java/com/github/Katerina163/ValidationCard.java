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
        var chars = card.toCharArray();
        if (!FACE_VALUE.contains(chars[0])) {
            throw new IllegalArgumentException("Неверный номинал карты " + chars[0]);
        }
        if (!SUIT.contains(chars[1])) {
            throw new IllegalArgumentException("Неверная масть " + chars[1]);
        }
    }
}
