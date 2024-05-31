import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.*;

public class Main {
    static Set<String> words = new TreeSet<>();

    public static void main(String[] args) throws MalformedURLException {
        loadAllWords();

        TreeSet<String> correctWords = new TreeSet<>();
        for (String word : words) {
            boolean isTrue;
            if (word.length() == 9) {
                isTrue = WIthRecursion.takeCorrectWords(word);
                if (isTrue) {
                    correctWords.add(word);
                }
            }
        }

        System.out.println();
        System.out.println("correct words :");
        for (String correctWord : correctWords) {
            System.out.println(correctWord);
        }

        System.out.println();
        System.out.println("count correct words: "+ correctWords.size());

    }

    private static Set<String> loadAllWords() throws MalformedURLException {
        URL wordsUrl = new URL("https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(wordsUrl.openStream()))) {
            String line = reader.readLine();
            while (line != null) {
                words.add(line);
                line = reader.readLine();
            }
            words.add("A");
            words.add("I");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
