import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day2_1 {

    public static void main(String[] args) {
        try {
            List<Integer> allResults = new ArrayList<>();

            int total = 0;
            while (true) {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rikke\\IdeaProjects\\src\\main\\java\\inputday2"));

                String line;
                int numIterations = 0;
                while ((line = br.readLine()) != null) {
                    total += Integer.parseInt(line);
                    if (allResults.contains(total)) {
                        System.out.println(total);
                        System.out.println(numIterations);
                        System.exit(0);
                    }
                    allResults.add(total);
                    numIterations++;
                }
                br.close();
            }
        } catch(Exception e) {
            e.printStackTrace();}
    }
}