import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность массива: ");
        int n = scanner.nextInt();

        printX(n);
    }

    static void printX(int n) {
        char[][] x = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (n >= 3) {
                    x[i][j] = (j == i || j == x.length - i - 1) ? 'x' : ' ';
                    System.out.print(x[i][j]);
                } else {
                    System.out.println("Error");
                }
            }
            System.out.println();
        }
    }
}
