import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше ФИО: ");

        String name = scanner.nextLine();
        name = name.trim();

        int wordAmount = name.split(" +").length;
        int firstSpaceIndex = name.indexOf(' ');
        int secondSpaceIndex = name.lastIndexOf(' ');

        if (wordAmount != 3) {
            System.out.println("ФИО введено неверно");
        } else if (!checkWords(name)) {
            System.out.println("ФИО может содержать только буквы");
        } else {
            System.out.println("Фамилия: " + name.substring(0, firstSpaceIndex).trim());
            System.out.println("Имя: " + name.substring(firstSpaceIndex, secondSpaceIndex).trim());
            System.out.println("Отчество: " + name.substring(secondSpaceIndex).trim());
        }
    }

    public static boolean checkWords(String name) {
        return name.replaceAll("\\s", "").matches("[a-zA-Zа-яА-Я]+");
    }
}
