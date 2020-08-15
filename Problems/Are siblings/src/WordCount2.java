import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount2 {
    public static void main(String[] args) {
        File file = new File("F:\\Christus\\Flashcards\\Problems\\Are siblings\\src\\teste2.txt");
        System.out.println(file.getPath());
        int soma = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                int number = scanner.nextInt();
                if (number >= 9999) {
                    soma = soma + 1;
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getLocalizedMessage());
        }
        System.out.println(soma);
    }
}
