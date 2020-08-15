import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();
        Set<String> sequence = new TreeSet<>();

        for (int i = 0; i <= numberOfElements; i++) {
            sequence.add(scanner.nextLine());
        }

        sequence.stream().forEach(System.out::println);
    }
}