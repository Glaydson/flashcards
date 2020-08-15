import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numElements = scanner.nextInt();
        int numElementosImpressos = 0;
        int elementoAtual = 1;
        boolean stop = false;

        while (!stop) {
            for (int i = 0; i < elementoAtual; i++) {
                if (numElementosImpressos == numElements) {
                    stop = true;
                    break;
                }
                System.out.print(elementoAtual + " ");
                numElementosImpressos++;
            }
            elementoAtual++;
        }
    }
}