import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();

        int numberOfPositives = 0;

        if (number1 > 0) numberOfPositives++;
        if (number2 > 0) numberOfPositives++;
        if (number3 > 0) numberOfPositives++;

        if (numberOfPositives == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}