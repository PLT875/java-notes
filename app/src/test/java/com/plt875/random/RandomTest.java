package com.plt875.random;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomTest {

    @Test
    void random() {
        Stream<String> s = Stream.of("apple", "banana", "apricot", "orange", "apple");
        LinkedHashMap<Character, String> m = s.collect(
                Collectors.toMap(
                        s1 -> s1.charAt(0),
                        s1 -> s1,
                        (s1, s2) -> s1 + "|" + s2,
                        LinkedHashMap::new)
        );

        assertEquals("apple|apricot|apple", m.get('a'));
        assertEquals("banana", m.get('b'));
        assertEquals("orange", m.get('o'));
    }

    @Test
    void random2() {
        Map<Integer, Integer> playerScore = new HashMap<>();
        playerScore.put(1, 6);
        playerScore.put(2, 8);
        playerScore.put(3, 5);
        playerScore.put(4, 4);

        List<Map.Entry<Integer,Integer>> player = playerScore.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        assertEquals(2, player.get(0).getKey());
        assertEquals(1, player.get(1).getKey());
        assertEquals(3, player.get(2).getKey());
        assertEquals(4, player.get(3).getKey());
    }

    @Test
    void random3() {
        List<String> words = Arrays.asList("hello", "world", "how", "world", "world");
        Map<String, Integer> wordCount = words.stream()
                .collect(Collectors.toMap(w -> w, w -> 1, (w1, w2) -> w1 + 1));

        assertEquals(wordCount.get("world"), 3);
        assertEquals(wordCount.get("hello"), 1);
        assertEquals(wordCount.get("how"), 1);
    }
}
