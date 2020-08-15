import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int numberReady = 0, numberFixed = 0, numberRejects = 0;

        Scanner scanner = new Scanner(System.in);
        int numberOfParts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfParts; i++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            if (size == 1) {
                numberFixed++;
            }
            if (size == 0) {
                numberReady++;
            }
            if (size == -1) {
                numberRejects++;
            }
        }

        System.out.println(numberReady + " " + numberFixed + " " + numberRejects);

    }
}