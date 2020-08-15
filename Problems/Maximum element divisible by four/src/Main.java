import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int numberElements = scanner.nextInt();
        int nextNumber;
        int maxDivisibleBy4 = 0;

        if (numberElements > 0) {
            for (int i = 1; i <= numberElements; i++) {
                nextNumber = scanner.nextInt();
                if (nextNumber % 4 == 0) {
                    if (nextNumber > maxDivisibleBy4) maxDivisibleBy4 = nextNumber;
                }
            }
        }
        System.out.println(maxDivisibleBy4);
    }
}