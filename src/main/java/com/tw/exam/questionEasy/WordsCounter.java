package com.tw.exam.questionEasy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * <p>Please implement the {@link WordsCounter#countWord(String)} method with the help of
 * {@link WordsCounter#getWords(String)} method and {@link WordsCounter#isMatch(String)}
 * method.</p>
 *
 * <p>It would be nice if you implement the method in the following sequence:</p>
 *
 * <ol>
 *     <li>{@link WordsCounter#getWords(String)}</li>
 *     <li>{@link WordsCounter#isMatch(String)}</li>
 *     <li>{@link WordsCounter#countWord(String)}</li>
 * </ol>
 */
public class WordsCounter {
    /**
     * This method will try to split words from given <code>text</code>. The words in the
     * <code>text</code> are separated only by <code>' '</code> and <code>'\t'</code>.
     *
     * @param text The text which contains words.
     * @return <p>The split words. Please note that returned list should not contains empty word
     * (word which is an empty string).</p>
     * <p>If the input <code>text</code> is null, it will return empty list.</p>
     */
    static List<String> getWords(String text) {
        // TODO: please implement the method:
        // <-start-
        ArrayList<String> stringsArr = new ArrayList<>();

        if (text == null || text == "") {
            return stringsArr;
        }

        String[] split1 = text.split(" ");
        for (String s1 : split1) {
            String[] split2 = s1.split("\\t");
            for (String s2 : split2) {
                stringsArr.add(s2);
            }
        }


        return stringsArr;
        // --end-->
    }

    /**
     * <p>This method tries to determine if the given <code>word</code> satisfies the following
     * rules:</p>
     *
     * <ol>
     *     <li>The <code>word</code> is not <code>null</code>.</li>
     *     <li>The <code>word</code> should contain at least 3 characters</li>
     *     <li>The <code>word</code> should begins with any English letter (including upper-cased and
     *     lower-cased letters) and ends with digit. For example, <code>"word1"</code></li>
     *     <li>The <code>word</code> should contain no whitespace characters. (<code>'\r'</code>,
     *     <code>'\f'</code>, <code>'\n'</code>, <code>' '</code> and <code>'\t'</code> are
     *     whitespace characters)</li>
     * </ol>
     *
     * @param word The given <code>word</code>.
     * @return <code>true</code> if all rules are satisfied. Otherwise, <code>false</code>.
     */
    static boolean isMatch(String word) {
        // TODO: please implement the method:
        // <-start-
        if (word == null) {
            return false;
        }

        String pattern = "([A-Za-z])[A-Za-z0-9-,]+\\d$";

        return Pattern.matches(pattern, word);
        // --end-->
    }

    /**
     * <p>The method will count how many words (extracted by {@link WordsCounter#getWords(String)})
     * are there in the <code>text</code>, which satisfy the rules defined by
     * {@link WordsCounter#isMatch(String)} method.</p>
     *
     * @param text The input text.
     * @return The number of words which satisfy rules determined by {@link WordsCounter#isMatch(String)} method.
     * @throws IllegalArgumentException <code>text</code> is <code>null</code>.
     */
    public static int countWord(String text) {
        // TODO: please implement the method:
        // <-start-
        if (text == null) {
            throw new IllegalArgumentException();
        }

        if (text == "") {
            return 0;
        }

        List<String> words = getWords(text);

        String[] strings = words.stream().filter(p -> isMatch(p)).toArray(String[]::new);

        return strings.length;

        // --end-->
    }
}
