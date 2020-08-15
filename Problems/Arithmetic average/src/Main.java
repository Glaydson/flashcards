import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double minLimit = scanner.nextDouble();
        double maxLimit = scanner.nextDouble();
        int qtyNumbers = 0;
        double sum = 0;

        for (double i = minLimit; i <= maxLimit; i++) {
            if ((i % 3) == 0) {
                qtyNumbers++;
                sum = sum + i;
            }
        }

        System.out.println(sum / qtyNumbers);

    }
}