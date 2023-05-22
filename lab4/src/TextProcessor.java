import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextProcessor {
    public static void main(String[] args) {
        String filename = "C:\\java\\lab4\\files\\TextFile.txt";
        char targetChar = 'a';

        // Чтение текста из файла
        String text = readFile(filename);

        // Разбиение текста на составные части
        List<Word> words = splitIntoWords(text);

        // Подсчет количества вхождений символа в каждом слове
        Map<Word, Integer> wordCountMap = countCharOccurrences(words, targetChar);

        // Сортировка слов по убыванию количества вхождений символа и по алфавиту
        List<Word> sortedWords = sortWords(wordCountMap);

        // Вывод отсортированных слов
        for (Word word : sortedWords) {
            System.out.println(word.getValue());
        }
    }

    private static String readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString().replaceAll("\\s+", " ").trim();
    }

    private static List<Word> splitIntoWords(String text) {
        List<Word> words = new ArrayList<>();
        String[] wordArray = text.split("\\s+"); // Разделение по пробелам
        for (String word : wordArray) {
            // Исключение знаков препинания и лишних символов
            word = word.replaceAll("[^a-яА-Яa-zA-Z]", "");
            if (!word.isEmpty()) {
                words.add(new Word(word));
            }
        }
        return words;
    }

    private static Map<Word, Integer> countCharOccurrences(List<Word> words, char targetChar) {
        Map<Word, Integer> wordCountMap = new HashMap<>();
        for (Word word : words) {
            int count = 0;
            for (char c : word.getValue().toCharArray()) {
                if (Character.toLowerCase(c) == Character.toLowerCase(targetChar)) {
                    count++;
                }
            }
            wordCountMap.put(word, count);
        }
        return wordCountMap;
    }

    private static List<Word> sortWords(Map<Word, Integer> wordCountMap) {
        List<Word> sortedWords = new ArrayList<>(wordCountMap.keySet());
        Collections.sort(sortedWords, new Comparator<Word>() {
            @Override
            public int compare(Word word1, Word word2) {
                int countCompare = Integer.compare(wordCountMap.get(word2), wordCountMap.get(word1));
                if (countCompare == 0) {
                    return word1.getValue().compareToIgnoreCase(word2.getValue());
                } else {
                    return countCompare;
                }
            }
        });
        return sortedWords;
    }
}