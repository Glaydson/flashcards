import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while(!line.equals("0")) {
            try {
                int number = Integer.parseInt(line);
                System.out.println(number * 10);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid user input: " + line);
            }
            line = scanner.nextLine();
        }
    }
}