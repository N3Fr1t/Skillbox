import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество ящиков: ");
        int boxes = scanner.nextInt();

        TrucksContainersBoxes trucksContainersBoxes = new TrucksContainersBoxes(boxes);
        trucksContainersBoxes.printResult();
    }
}
