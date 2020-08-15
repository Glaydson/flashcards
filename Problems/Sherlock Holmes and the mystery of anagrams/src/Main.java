import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine().toLowerCase();
        String word2 = scanner.nextLine().toLowerCase();

        Map<Character, Integer> word1Count = new HashMap<>();
        Map<Character, Integer> word2Count = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            Character key = word1.charAt(i);
            word1Count.merge(key, 1, Integer::sum);
        }
        for (int i = 0; i < word2.length(); i++) {
            Character key = word2.charAt(i);
            word2Count.merge(key, 1, Integer::sum);
        }
        if (Objects.equals(word1Count, word2Count)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}