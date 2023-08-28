package com.github.Katerina163;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CheckingCombinationTest {
    @Test
    public void whenStraightFlushInOrder() {
        String[] cards = {"2S", "3S", "4S", "5S", "6S"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.STRAIGHT_FLUSH));
    }

    @Test
    public void whenStraightFlush() {
        String[] cards = {"KS", "JS", "9S", "TS", "QS"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.STRAIGHT_FLUSH));
    }

    @Test
    public void whenFourInOrder() {
        String[] cards = {"6S", "6H", "6D", "6C", "5S"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FOUR_OF_A_KIND));
    }

    @Test
    public void whenFourAndDifferentFirst() {
        String[] cards = {"5S", "6S", "6H", "6D", "6C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FOUR_OF_A_KIND));
    }

    @Test
    public void whenFourAndDifferentInMiddle() {
        String[] cards = {"6S", "6H", "5S", "6D", "6C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FOUR_OF_A_KIND));
    }

    @Test
    public void whenFullHouse() {
        String[] cards = {"6S", "4D", "6H", "4C", "6C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FULL_HOUSE));
    }

    @Test
    public void whenFullHouseFirstThree() {
        String[] cards = {"6S", "6H", "6C", "4D", "4C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FULL_HOUSE));
    }

    @Test
    public void whenFullHouseLastThree() {
        String[] cards = {"4S", "4H", "5S", "5D", "5C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FULL_HOUSE));
    }

    @Test
    public void whenStraightInOrder() {
        String[] cards = {"2S", "3H", "4D", "5C", "6S"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.STRAIGHT));
    }

    @Test
    public void whenStraight() {
        String[] cards = {"TS", "6H", "8D", "7C", "9S"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.STRAIGHT));
    }

    @Test
    public void whenThreeInOrder() {
        String[] cards = {"6S", "6H", "6D", "4C", "5S"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.THREE_OF_A_KIND));
    }

    @Test
    public void whenThreeAndDifferentFirst() {
        String[] cards = {"5S", "4S", "6H", "6D", "6C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.THREE_OF_A_KIND));
    }

    @Test
    public void whenThreeAndDifferentInMiddle() {
        String[] cards = {"6S", "6H", "5S", "4D", "6C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.THREE_OF_A_KIND));
    }

    @Test
    public void whenTwoPairFirst() {
        String[] cards = {"KS", "KH", "4D", "4C", "5S"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.TWO_PAIRS));
    }

    @Test
    public void whenTwoPairLast() {
        String[] cards = {"5S", "6S", "6H", "AD", "AC"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.TWO_PAIRS));
    }

    @Test
    public void whenTwoPairMiddle() {
        String[] cards = {"2S", "5H", "TS", "TD", "5C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.TWO_PAIRS));
    }

    @Test
    public void whenTwoPair() {
        String[] cards = {"6S", "3H", "5S", "6D", "5C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.TWO_PAIRS));
    }

    @Test
    public void whenPairFirst() {
        String[] cards = {"KS", "KH", "6D", "4C", "5S"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.PAIR));
    }

    @Test
    public void whenPairLast() {
        String[] cards = {"5S", "4S", "6H", "AD", "AC"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.PAIR));
    }

    @Test
    public void whenPairMiddle() {
        String[] cards = {"2S", "5H", "TS", "TD", "6C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.PAIR));
    }

    @Test
    public void whenPair() {
        String[] cards = {"6S", "3H", "5S", "6D", "8C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.PAIR));
    }

    @Test
    public void whenHighCard() {
        String[] cards = {"10S", "4H", "7S", "TD", "2C"};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.HIGH_CARD));
    }
}