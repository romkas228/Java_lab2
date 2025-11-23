import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Lab2 {

    public static void main(String[] args) {
        String initialString = "Java is an amazing language. Programming requires logic and creativity.";
        StringBuilder text = new StringBuilder(initialString);

        System.out.println("### Вхідний текст:");
        System.out.println(text);

        try {
            List<StringBuilder> words = splitToWords(text);

            if (words.isEmpty()) {
                System.out.println("Слів не знайдено.");
                return;
            }

            sortWordsByVowelCount(words);

            System.out.println("\n### Результат (відсортовано за кількістю голосних):");
            for (StringBuilder word : words) {
                System.out.println(word + " (голосних: " + countVowels(word) + ")");
            }

        } catch (Exception e) {
            System.err.println("Виникла помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<StringBuilder> splitToWords(StringBuilder text) {
        List<StringBuilder> wordsList = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                currentWord.append(c);
            } else {

                if (currentWord.length() > 0) {
                    wordsList.add(currentWord);
                    currentWord = new StringBuilder();
                }
            }
        }
        

        if (currentWord.length() > 0) {
            wordsList.add(currentWord);
        }
        
        return wordsList;
    }


    private static void sortWordsByVowelCount(List<StringBuilder> words) {

        Collections.sort(words, new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder w1, StringBuilder w2) {
                return Integer.compare(countVowels(w1), countVowels(w2));
            }
        });
    }


    private static int countVowels(StringBuilder sb) {
        int count = 0;
        String vowels = "AEIOUYaeiouyАЕЄИІЇОУЮЯаеєиіїоуюя";
        
        for (int i = 0; i < sb.length(); i++) {
            if (vowels.indexOf(sb.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }
}