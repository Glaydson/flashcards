import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        File file = new File("F:\\Christus\\Flashcards\\Problems\\Are siblings\\src\\teste.txt");
        System.out.println(file.getPath());
        int soma = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                int number = Integer.parseInt(scanner.nextLine());
                soma = soma + number;
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getLocalizedMessage());
        }
        System.out.println(soma);
    }
}
