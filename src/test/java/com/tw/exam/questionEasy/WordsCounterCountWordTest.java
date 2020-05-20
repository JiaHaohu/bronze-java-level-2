package com.tw.exam.questionEasy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsCounterCountWordTest {
    @Test
    void should_get_0_if_input_is_empty() {
        assertEquals(0, WordsCounter.countWord(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"word0", "Word0", "wa0","word0count00"})
    void should_get_word_count_if_pattern_matches(String oneMatch) {
        assertEquals(1, WordsCounter.countWord(oneMatch));
    }

    @ParameterizedTest
    @ValueSource(strings = {"word", "0word", "word0d", "-rd0", "word-", "w0", "$a0", "word0w"})
    void should_not_get_word_count_if_pattern_not_match(String noMatch) {
        assertEquals(0, WordsCounter.countWord(noMatch));
    }

    @Test
    void should_get_word_counts_for_certain_separator() {
        assertEquals(2, WordsCounter.countWord("two word2 count2"));
        assertEquals(2, WordsCounter.countWord("two\tword2\tcount2"));
        assertEquals(2, WordsCounter.countWord("two\t\tword2\t\t\tcount2"));
        assertEquals(2, WordsCounter.countWord("two\tword2 count2"));
        assertEquals(2, WordsCounter.countWord("two\tword2     count2"));
        assertEquals(0, WordsCounter.countWord("two\tword2\rcount2"));
        assertEquals(0, WordsCounter.countWord("two\tword2\ncount2"));
        assertEquals(0, WordsCounter.countWord("two\tword2\fcount2"));
        assertEquals(0, WordsCounter.countWord("two\tword2\r\ncount2"));
        assertEquals(1, WordsCounter.countWord("two\r\nword2 count2"));
        assertEquals(1, WordsCounter.countWord("two\fword2 count2"));
        assertEquals(1, WordsCounter.countWord("two\nword2 count2"));
    }

    @Test
    void should_get_word_counts_mixed() {
        assertEquals(1, WordsCounter.countWord("one word2 count"));
        assertEquals(2, WordsCounter.countWord("two word2 count2"));
        assertEquals(0, WordsCounter.countWord("no word count at all"));
        assertEquals(0, WordsCounter.countWord("no 0 word 1 count 2 at 3 all 4"));
        assertEquals(1, WordsCounter.countWord("one 0 word-1 count 2 at 3 all 4"));
        assertEquals(0, WordsCounter.countWord("no 0 word\r\n1 count 2 at 3 all 4"));
        assertEquals(1, WordsCounter.countWord("Hello. This is Mark,1"));
    }

    @Test
    void should_throw_if_input_is_null() {
        assertThrows(IllegalArgumentException.class, () -> WordsCounter.countWord(null));
    }
}
