import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day4_1 {

    private int totalLinesWithoutDuplicates = 0;

    public static void main(String[] args) {
        Day4_1 aocDay4 = new Day4_1();

        final String input = "C:\\Users\\rikke\\IdeaProjects\\src\\main\\java\\inputday4.txt";

        try (Stream<String> stream = Files.lines(Paths.get(input))) {
            stream.forEach(aocDay4::validWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(aocDay4.totalLinesWithoutDuplicates);
    }

    private void validWords(String line) {
        String[] words = line.split(" ");

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(i == j) {
                    continue;
                }
                if (words[i].equals(words[j])) {
                    return;
                }
            }
        }
        totalLinesWithoutDuplicates++;
    }
}

