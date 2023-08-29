package com.github.Katerina163;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CheckingCombinationTest {
    @Test
    public void whenStraightFlushInOrder() {
        Card[] cards = {
                new Card("2S"), new Card("3S"), new Card("4S"), new Card("5S"), new Card("6S")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.STRAIGHT_FLUSH));
    }

    @Test
    public void whenStraightFlush() {
        Card[] cards = {
                new Card("KS"), new Card("JS"), new Card("9S"), new Card("TS"), new Card("QS")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.STRAIGHT_FLUSH));
    }

    @Test
    public void whenFourInOrder() {
        Card[] cards = {
                new Card("6S"), new Card("6H"), new Card("6D"), new Card("6C"), new Card("5S")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FOUR_OF_A_KIND));
    }

    @Test
    public void whenFourAndDifferentFirst() {
        Card[] cards = {
                new Card("5S"), new Card("6S"), new Card("6H"), new Card("6D"), new Card("6C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FOUR_OF_A_KIND));
    }

    @Test
    public void whenFourAndDifferentInMiddle() {
        Card[] cards = {
                new Card("6S"), new Card("6H"), new Card("5S"), new Card("6D"), new Card("6C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FOUR_OF_A_KIND));
    }

    @Test
    public void whenFullHouse() {
        Card[] cards = {
                new Card("6S"), new Card("4D"), new Card("6H"), new Card("4C"), new Card("6C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FULL_HOUSE));
    }

    @Test
    public void whenFullHouseFirstThree() {
        Card[] cards = {
                new Card("6S"), new Card("6H"), new Card("6C"), new Card("4D"), new Card("4C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FULL_HOUSE));
    }

    @Test
    public void whenFullHouseLastThree() {
        Card[] cards = {
                new Card("4S"), new Card("4H"), new Card("5S"), new Card("5D"), new Card("5C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.FULL_HOUSE));
    }

    @Test
    public void whenStraightInOrder() {
        Card[] cards = {
                new Card("2S"), new Card("3H"), new Card("4D"), new Card("5C"), new Card("6S")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.STRAIGHT));
    }

    @Test
    public void whenStraight() {
        Card[] cards = {
                new Card("TS"), new Card("6H"), new Card("8D"), new Card("7C"), new Card("9S")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.STRAIGHT));
    }

    @Test
    public void whenThreeInOrder() {
        Card[] cards = {
                new Card("6S"), new Card("6H"), new Card("6D"), new Card("4C"), new Card("5S")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.THREE_OF_A_KIND));
    }

    @Test
    public void whenThreeAndDifferentFirst() {
        Card[] cards = {
                new Card("5S"), new Card("4S"), new Card("6H"), new Card("6D"), new Card("6C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.THREE_OF_A_KIND));
    }

    @Test
    public void whenThreeAndDifferentInMiddle() {
        Card[] cards = {
                new Card("6S"), new Card("6H"), new Card("5S"), new Card("4D"), new Card("6C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.THREE_OF_A_KIND));
    }

    @Test
    public void whenTwoPairFirst() {
        Card[] cards = {
                new Card("KS"), new Card("KH"), new Card("4D"), new Card("4C"), new Card("5S")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.TWO_PAIRS));
    }

    @Test
    public void whenTwoPairLast() {
        Card[] cards = {
                new Card("5S"), new Card("6S"), new Card("6H"), new Card("AD"), new Card("AC")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.TWO_PAIRS));
    }

    @Test
    public void whenTwoPairMiddle() {
        Card[] cards = {
                new Card("2S"), new Card("5H"), new Card("TS"), new Card("TD"), new Card("5C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.TWO_PAIRS));
    }

    @Test
    public void whenTwoPair() {
        Card[] cards = {
                new Card("6S"), new Card("3H"), new Card("5S"), new Card("6D"), new Card("5C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.TWO_PAIRS));
    }

    @Test
    public void whenPairFirst() {
        Card[] cards = {
                new Card("KS"), new Card("KH"), new Card("6D"), new Card("4C"), new Card("5S")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.PAIR));
    }

    @Test
    public void whenPairLast() {
        Card[] cards = {
                new Card("5S"), new Card("4S"), new Card("6H"), new Card("AD"), new Card("AC")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.PAIR));
    }

    @Test
    public void whenPairMiddle() {
        Card[] cards = {
                new Card("2S"), new Card("5H"), new Card("TS"), new Card("TD"), new Card("6C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.PAIR));
    }

    @Test
    public void whenPair() {
        Card[] cards = {
                new Card("6S"), new Card("3H"), new Card("5S"), new Card("6D"), new Card("8C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.PAIR));
    }

    @Test
    public void whenHighCard() {
        Card[] cards = {
                new Card("3S"), new Card("4H"), new Card("7S"), new Card("TD"), new Card("2C")};
        var result = CheckingCombination.checkCards(cards);
        assertThat(result, is(Combination.HIGH_CARD));
    }
}