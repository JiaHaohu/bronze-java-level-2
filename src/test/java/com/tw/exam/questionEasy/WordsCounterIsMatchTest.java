package com.tw.exam.questionEasy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterIsMatchTest {
    @ParameterizedTest
    @ValueSource(strings = {"word1", "Word1", "Word-1"})
    void should_match_word(String matched) {
        assertTrue(WordsCounter.isMatch(matched));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "w1", "w", "1"})
    void should_not_match_if_word_length_is_less_than_3(String notMatch) {
        assertFalse(WordsCounter.isMatch(notMatch));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "1word1", "-word1", "+_0"})
    void should_not_match_if_word_starts_with_non_english_characters(String notMatch) {
        assertFalse(WordsCounter.isMatch(notMatch));
    }

    @ParameterizedTest
    @ValueSource(strings = {"word1a", "word", "word$"})
    void should_not_match_if_word_ends_with_non_digit(String notMatch) {
        assertFalse(WordsCounter.isMatch(notMatch));
    }

    @ParameterizedTest
    @ValueSource(strings = {"word 1", "word\t1", "word\f1", "word\r1", "word\n1"})
    void should_not_match_if_word_contains_white_space(String notMatch) {
        assertFalse(WordsCounter.isMatch(notMatch));
    }

    @Test
    void should_not_match_if_word_is_null() {
        assertFalse(WordsCounter.isMatch(null));
    }
}
