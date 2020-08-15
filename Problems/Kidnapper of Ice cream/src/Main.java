import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String availableWords = scanner.nextLine();
        String myNote = scanner.nextLine();

        String[] arrayMyNote = myNote.split(" ");
        String[] arrayAvailableWords = availableWords.split(" ");
        List<String> listAvailableWords = new ArrayList<>();
        for (String word: arrayAvailableWords) {
            listAvailableWords.add(word);
        }

        List<String> listWordsNote = Arrays.asList(arrayMyNote);
        boolean canWrite = true;

        for (String word: listWordsNote) {
            if (listAvailableWords.contains(word)) {
                listAvailableWords.remove(word);
            } else {
                canWrite = false;
                break;
            }
        }

        if (canWrite) System.out.println("You get money");
        else System.out.println("You are busted");


    }
}