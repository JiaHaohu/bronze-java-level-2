package com.tw.exam.questionEasy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterGetWordsTest {
    @Test
    void should_get_empty_list_if_input_is_null() {
        assertEquals(0, WordsCounter.getWords(null).size());
    }

    @Test
    void should_get_empty_list_if_input_is_empty_string() {
        assertEquals(0, WordsCounter.getWords("").size());
    }

    @Test
    void should_get_single_word() {
        assertIterableEquals(
            Collections.singletonList("word"),
            WordsCounter.getWords("word"));
    }

    @Test
    void should_get_multiple_words() {
        assertIterableEquals(
            Arrays.asList("How", "do", "you", "do"),
            WordsCounter.getWords("How do you do"));
    }

    @Test
    void should_get_words_separated_by_different_separators() {
        assertIterableEquals(
            Arrays.asList("How", "do", "you", "do"),
            WordsCounter.getWords("How do you\tdo"));
    }

    @Test
    void should_split_words_if_the_separator_is_not_space_or_tab() {
        assertIterableEquals(
            Collections.singletonList("word\rcount"),
            WordsCounter.getWords("word\rcount"));
    }

    @Test
    void should_eliminate_empty_words_if_separators_are_connected() {
        assertIterableEquals(
            Arrays.asList("word", "count"),
            WordsCounter.getWords("word     count"));
    }
}
