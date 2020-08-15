import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine().toLowerCase();
        String word2 = scanner.nextLine().toLowerCase();

        Map<Character, Integer> word1Count = new TreeMap<>();
        Map<Character, Integer> word2Count = new TreeMap<>();

        for (int i = 0; i < word1.length(); i++) {
            Character key = word1.charAt(i);
            word1Count.merge(key, 1, Integer::sum);
        }
        for (int i = 0; i < word2.length(); i++) {
            Character key = word2.charAt(i);
            word2Count.merge(key, 1, Integer::sum);
        }

        int numberOfDeleted = 0;
        Iterator<Character> charsWord1 =  word1Count.keySet().iterator();
        Iterator<Character> charsWord2 =  word2Count.keySet().iterator();
        // Steps through sequence 1 and verify if each character exists in sequence 2
        // If exists, verify if the quantity is the same. If it is, do nothing
        // If different, adds the difference to be deleted
        // If dont exist, add the value to be deleted
        //System.out.println(word1Count);
        //System.out.println(word2Count);
        while (charsWord1.hasNext()) {
            Character nextWord = charsWord1.next();
            if (word2Count.containsKey(nextWord)) {
                if (word1Count.get(nextWord) != word2Count.get(nextWord)) {
                    numberOfDeleted = numberOfDeleted + Math.abs(word1Count.get(nextWord) - word2Count.get(nextWord));
                }
            } else {
                numberOfDeleted = numberOfDeleted + word1Count.get(nextWord);
            }
        }

        // Catch the ones that exists only in sequence 2
        while (charsWord2.hasNext()) {
            Character nextWord = charsWord2.next();
            if (!word1Count.containsKey(nextWord)) {
                numberOfDeleted = numberOfDeleted + word2Count.get(nextWord);
            }
        }

        System.out.println(numberOfDeleted);

    }
}