import java.util.HashSet;

public class WIthRecursion {

    static public boolean takeCorrectWords(String word) {

        boolean isCorrect = false;
        if (word.isEmpty()) {
            return isCorrect;
        }

        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i + 1);
            if (Main.words.contains(newWord)) {

                if ("a".equalsIgnoreCase(newWord) || "i".equalsIgnoreCase(newWord)) {
                    System.out.println(newWord);
                    System.out.println(word);
                    return true;
                }

                isCorrect = takeCorrectWords(newWord);
                if(isCorrect){
                    System.out.println(word);
                }
                if (i == word.length() - 1 || isCorrect) {
                    return isCorrect;
                }
            }

        }

        return false;
    }
}
