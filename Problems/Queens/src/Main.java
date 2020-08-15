import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        boolean hit = false;
        if ((x1 == x2) || (y1 == y2)) hit = true;

        double slope = (y2 - y1)/(x2 - x1);
        if (slope == 1 || slope == -1) hit = true;

        if (hit == true) System.out.println("YES");
        else System.out.println("NO");
    }
}