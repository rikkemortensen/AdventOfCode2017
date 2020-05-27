import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Day2_2 {

    private int total = 0;

    public static void main(String[] args) {

        Day2_2 aocDay2_2 = new Day2_2();

        final String file = "C:\\Users\\rikke\\IdeaProjects\\src\\main\\java\\inputday2.txt";

        try (Stream<String> stream = Files.lines(Paths.get(file))) {
            stream.forEach(aocDay2_2::processLine2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(aocDay2_2.total);
    }

    private void processLine2(String line) {
        Scanner sc = new Scanner(line);
        List<Integer> numbers = new ArrayList<>();

        while(sc.hasNext()) {
            int next = sc.nextInt();
            numbers.add(next);
        }

        for (int i = 0; i < numbers.size(); i++) {
            Integer dividend = numbers.get(i);

            for (int j = 0; j < numbers.size(); j++) {
                Integer divisor = numbers.get(j);
                if(i == j) {
                    continue;
                }
                if (dividend % divisor == 0) {
                    total += (dividend / divisor);
                    return;
                }
            }
        }
    }
}
