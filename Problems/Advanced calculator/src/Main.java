import java.util.ArrayList;
import java.util.List;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            numbers.add(Integer.parseInt(args[i]));
        }
        // write your code here
        switch (operator) {
            case "MAX": {
                System.out.println(numbers.stream().mapToInt(v -> v)
                        .max().getAsInt());
                break;
            }
            case "MIN": {
                System.out.println(numbers.stream().mapToInt(v -> v)
                        .min().getAsInt());
                break;
            }
            case "SUM": {
                System.out.println(numbers.stream().mapToInt(v -> v)
                        .sum());
                break;
            }
            default: {
                break;
            }
        }
    }
}