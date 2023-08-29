package com.github.Katerina163;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckingCombination {
    private static final List<Character> FACE_VALUE = List.of(
            '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'
    );

    public static Combination checkCards(Card[] cards) {
        if (straightFlush(cards)) {
            return Combination.STRAIGHT_FLUSH;
        } else if (four(cards)) {
            return Combination.FOUR_OF_A_KIND;
        } else if (fullHouse(cards)) {
            return Combination.FULL_HOUSE;
        } else if (flush(cards)) {
            return Combination.FLUSH;
        } else if (straight(cards)) {
            return Combination.STRAIGHT;
        } else if (three(cards)) {
            return Combination.THREE_OF_A_KIND;
        } else if (twoPair(cards)) {
            return Combination.TWO_PAIRS;
        } else if (pair(cards)) {
            return Combination.PAIR;
        } else {
            return Combination.HIGH_CARD;
        }
    }

    private static boolean straightFlush(Card[] cards) {
        return flush(cards) && straight(cards);
    }

    private static boolean four(Card[] cards) {
        return count(cards, 4);
    }

    private static boolean fullHouse(Card[] cards) {
        char twoValue = 0;
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].getFaceValue() != cards[0].getFaceValue()) {
                if (twoValue == 0) {
                    twoValue = cards[i].getFaceValue();
                } else {
                    if (cards[i].getFaceValue() != twoValue) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean flush(Card[] cards) {
        for (var card : cards) {
            if (card.getSuit() != cards[0].getSuit()) {
                return false;
            }
        }
        return true;
    }

    private static boolean straight(Card[] cards) {
        Set<Character> set = new HashSet<>();
        char ch = '0';
        for (var c : FACE_VALUE) {
            for (var card : cards) {
                set.add(card.getFaceValue());
                if (c == card.getFaceValue()) {
                    if (ch == '0') {
                        ch = card.getFaceValue();
                    }
                }
            }
        }
        int ind = FACE_VALUE.indexOf(ch);
        for (int i = ind; i < ind + 5; i++) {
            if (!set.contains(FACE_VALUE.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean three(Card[] cards) {
        return count(cards, 3);
    }

    private static boolean twoPair(Card[] cards) {
        char one = '0';
        char two = '0';
        char three = '0';
        for (var card : cards) {
            if (one == '0') {
                one = card.getFaceValue();
            } else {
                if (card.getFaceValue() != one) {
                    if (two == '0') {
                        two = card.getFaceValue();
                    } else {
                        if (two != card.getFaceValue()) {
                            if (three == '0') {
                                three = card.getFaceValue();
                            } else {
                                if (three != card.getFaceValue()) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean pair(Card[] cards) {
        return count(cards, 2);
    }

    private static boolean count(Card[] cards, int quantity) {
        for (int i = 0; i <= 5 - quantity; i++) {
            int quant = 1;
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[j].getFaceValue() == cards[i].getFaceValue()) {
                    quant++;
                }
            }
            if (quant == quantity) {
                return true;
            }
        }
        return false;
    }
}
