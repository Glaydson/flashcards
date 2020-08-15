import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;
        while (number != 0) {
            sum = sum + number;
            if (sum >= 1000) {
                sum = sum - 1000;
                break;
            }
            number = scanner.nextInt();
        }
        System.out.println(sum);
    }
}