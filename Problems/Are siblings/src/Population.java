import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Population {
    public static void main(String[] args) {
        File file = new File("F:\\Christus\\Flashcards\\Problems\\Are siblings\\src\\population.txt");
        int yearBiggestVariation = 0;
        double biggestVariation = 0;
        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            int previousYear = scanner.nextInt();
            double previousPop = Double.parseDouble(scanner.next().replaceAll(",", ""));
            biggestVariation = 0;
            yearBiggestVariation = 0;
            while (scanner.hasNext()) {
                int year = scanner.nextInt();
                double pop = Double.parseDouble(scanner.next().replaceAll(",", ""));
                if ((pop - previousPop) > biggestVariation) {
                    biggestVariation = pop - previousPop;
                    yearBiggestVariation = year;
                }
                previousPop = pop;
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getLocalizedMessage());
        }
        System.out.println(yearBiggestVariation);
    }
}
