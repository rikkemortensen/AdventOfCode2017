import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day5_2 {
    public static void main(String[] args) throws IOException {

        int[] intArr = Files.lines(Paths.get("C:\\Users\\Rikke\\Dev\\src\\main\\java\\input5.txt"))
                .mapToInt(Integer::parseInt).toArray();

        int pos = 0;
        int oldPos;

        for (int i = 0; i < 999999999; i++) {
            oldPos = pos;
            pos += intArr[pos];

            if (pos >= intArr.length || pos < 0) {
                System.out.println(i + 1);
                break;
            }

            if(intArr[oldPos] >= 3) {
                intArr[oldPos] -= 1;
            } else {
                intArr[oldPos] += 1;
            }
        }
    }
}
