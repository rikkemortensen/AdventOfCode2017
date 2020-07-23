import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day4_2 {

    private int totalLinesWithoutAnagrams = 0;

    public static void main(String[] args) {

        Day4_2 aocDay4 = new Day4_2();

        final String input = "C:\\Users\\Rikke\\Dev\\src\\main\\java\\input4.txt";

        try (Stream<String> stream = Files.lines(Paths.get(input))) {
            stream.forEach(aocDay4::validWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(aocDay4.totalLinesWithoutAnagrams);
    }

    public void validWords(String line) {
        String[] words = line.split(" ");
        Set<String> wordCollection = new HashSet<>();

        for (String word : words) {
            String sortedWord = sortingMethod(word);

            if(wordCollection.contains(sortedWord)){
                return;
            }
            wordCollection.add(sortedWord);
        }
        totalLinesWithoutAnagrams++;
    }

    public String sortingMethod(String word) {
        return word.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
