import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = readArrayList(scanner);
        int n = scanner.nextInt();

        Collections.sort(array);
        int distance = Integer.MAX_VALUE;
        ArrayList<Integer> output = new ArrayList<>();
        for (Integer x: array) {
            if (Math.abs(x - n) < distance) {
                distance = Math.abs(x - n);
            }
        }
        //System.out.println(distance);
        for (Integer x: array) {
            if (Math.abs(x - n) == distance) {
                output.add(x);
            }
        }
        output.forEach(x -> System.out.print(x + " "));
    }

    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}