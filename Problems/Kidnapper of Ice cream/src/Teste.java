public class Teste {

    public static void main(String[] args) {
        int[] a = {4, 0, 9, 2, 1};
        int[] b = {6, 3, 2, 9, 0};

        for (int i = 0; i < a.length; i++) {
            if ((i % 2) == 0) {
                a[i] -= b[i];
            } else {
                b[i] -= a[i];
            }
        }

        for (int x: a) {
            System.out.print(x + " ");
        }
        System.out.println();

        for (int x: b) {
            System.out.print(x + " ");
        }

    }



}
