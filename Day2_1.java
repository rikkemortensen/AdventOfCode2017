import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Day2_1 {

    private int total = 0;

    public static void main(String[] args) {

        Day2_1 aocDay2 = new Day2_1();

        final String file = "C:\\Users\\rikke\\IdeaProjects\\src\\main\\java\\inputday2.txt";

        try (Stream<String> stream = Files.lines(Paths.get(file))) {
            stream.forEach(str -> {aocDay2.processLine(str);});
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(aocDay2.total);
    }

    private void processLine(String line) {
        Scanner sc = new Scanner(line);
        int max = 0;
        int min = 0;
        boolean isFirst = true;

        while(sc.hasNext()) {
            int next = sc.nextInt();
            if(isFirst) {
                max = next;
                min = next;
                isFirst = false;
            }
            if(next > max) {
                max = next;
            }
            if(next < min) {
                min = next;
            }
        }
        int dif = max - min;
        total += dif;
    }
}