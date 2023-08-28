package com.github.Katerina163;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationCardTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "QS", "KS", "AS",
            "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH", "AH",
            "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD", "AD",
            "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC", "AC",
    })
    public void whenCorrect(String str) {
        ValidationCard.validate(str);
    }

    @Test
    public void whenLong() throws IllegalArgumentException {
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> ValidationCard.validate("WER"));
        assertThat(thr.getMessage(), is("Неверная карта WER"));
    }

    @Test
    public void whenFaceValue() throws IllegalArgumentException {
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> ValidationCard.validate("WW"));
        assertThat(thr.getMessage(), is("Неверный номинал карты W"));
    }

    @Test
    public void whenSuit() throws IllegalArgumentException {
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> ValidationCard.validate("4W"));
        assertThat(thr.getMessage(), is("Неверная масть W"));
    }
}