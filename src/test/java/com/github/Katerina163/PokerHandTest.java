package com.github.Katerina163;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PokerHandTest {
    private PokerHand highCart = new PokerHand("TS 4H 7D KC 2S");
    private PokerHand pair = new PokerHand("KC KH 7D 2C 5S");
    private PokerHand twoPairs = new PokerHand("KC KH 7D 7C 5S");
    private PokerHand three = new PokerHand("KC KH KD 7C 5S");
    private PokerHand straight = new PokerHand("3S 4H 5D 6C 7S");
    private PokerHand flush = new PokerHand("KC QC 9C 8C 2C");
    private PokerHand fullHouse = new PokerHand("KC KH KD 7C 7S");
    private PokerHand four = new PokerHand("6S 6H 6D 6C KS");
    private PokerHand straightFlush = new PokerHand("2H 3H 4H 5H 6H");

    @Test
    public void whenSort() {
        List<PokerHand> hands = new ArrayList<>();
        hands.add(highCart);
        hands.add(straightFlush);
        hands.add(pair);
        hands.add(flush);
        hands.add(four);
        hands.add(straight);
        hands.add(twoPairs);
        hands.add(fullHouse);
        hands.add(three);

        Collections.sort(hands);

        assertThat(hands.get(0), is(highCart));
        assertThat(hands.get(1), is(pair));
        assertThat(hands.get(2), is(twoPairs));
        assertThat(hands.get(3), is(three));
        assertThat(hands.get(4), is(straight));
        assertThat(hands.get(5), is(flush));
        assertThat(hands.get(6), is(fullHouse));
        assertThat(hands.get(7), is(four));
        assertThat(hands.get(8), is(straightFlush));
    }

    @Test
    public void whenCheckCombination() {
        assertThat(highCart.getCombination(), is(Combination.HIGH_CARD));
        assertThat(pair.getCombination(), is(Combination.PAIR));
        assertThat(twoPairs.getCombination(), is(Combination.TWO_PAIRS));
        assertThat(three.getCombination(), is(Combination.THREE_OF_A_KIND));
        assertThat(straight.getCombination(), is(Combination.STRAIGHT));
        assertThat(flush.getCombination(), is(Combination.FLUSH));
        assertThat(fullHouse.getCombination(), is(Combination.FULL_HOUSE));
        assertThat(four.getCombination(), is(Combination.FOUR_OF_A_KIND));
        assertThat(straightFlush.getCombination(), is(Combination.STRAIGHT_FLUSH));
    }

    @Test
    public void whenEmptyHand() throws IllegalArgumentException {
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> {
            var poker = new PokerHand("");
        });
        assertThat(thr.getMessage(), is("Неверный набор карт"));
    }

    @Test
    public void whenIncorrectHand() throws IllegalArgumentException {
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> {
            var poker = new PokerHand("2H 3Hy4H 5H 6H");
        });
        assertThat(thr.getMessage(), is("Неверное количество карт"));
    }
}