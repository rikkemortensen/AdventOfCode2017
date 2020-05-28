import static java.lang.Math.abs;

public class Day3_1 {

    public static void main(String[] args) {
        int stepsToNextCorner = 0;
        int spiralCoordinate = 1;
        double x = 0;
        double y = 0;
        int target = 368078;
        int diff;
        double manhattanDistance;

        while (spiralCoordinate < target) {
            stepsToNextCorner += 1;
            x += stepsToNextCorner * Math.pow(-1, stepsToNextCorner + 1);
            spiralCoordinate += stepsToNextCorner;

            if(spiralCoordinate > target) {
                break;
            }

            y += stepsToNextCorner * Math.pow(-1, stepsToNextCorner + 1);
            spiralCoordinate += stepsToNextCorner;
        }

        diff = spiralCoordinate - target;
        if(x == y) {
            y += diff * Math.pow(-1, stepsToNextCorner);
        } else {
            x += diff * Math.pow(-1, stepsToNextCorner);
        }

        manhattanDistance = abs(x) + abs(y);
        System.out.println(x + " " + y + " " + spiralCoordinate + " " + diff);
        System.out.println(manhattanDistance);
    }
}
