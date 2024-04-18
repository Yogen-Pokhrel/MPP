package Lab9.prob3;

import java.util.List;

public class Main {

    public static int countWords(List<String> words, char c, char d, int len) {
        return (int) words.stream()
                .filter(x -> x.length() == len)
                .filter(x -> x.contains(String.valueOf(c)))
                .filter(x -> !x.contains(String.valueOf(d)))
                .count();
    }

    public static void main(String[] args) {

        List<String> words = List.of("word", "words", "wordy", "wordz", "wordw", "wordd", "wordwd", "worddw", "worddd",
                "wordww");
        System.out.println(countWords(words, 'w', 'e', 5));
    }
}
