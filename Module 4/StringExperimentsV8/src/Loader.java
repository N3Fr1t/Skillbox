import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();

        System.out.println(phoneCheck(phoneNumber));
    }

    static String phoneCheck(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\D", "");

        StringBuilder stringBuilder = new StringBuilder(phoneNumber);

        if (stringBuilder.length() == 10) {
            if (stringBuilder.indexOf("7") == 0 || stringBuilder.indexOf("8") == 0 || phoneNumber.indexOf("9") == 0) {
                phoneNumber = String.valueOf(stringBuilder.insert(0, "7"));
            } else {
                phoneNumber = "Неверный формат номера";
            }
        } else if (stringBuilder.length() == 11) {
            if (stringBuilder.indexOf("8") == 0) {
                phoneNumber = String.valueOf(stringBuilder.replace(0, 1, "7"));
            } else if (!(stringBuilder.indexOf("7") == 0)) {
                phoneNumber = "Неверный формат номера";
            }
        } else {
            phoneNumber = "Неверный формат номера";
        }
        return phoneNumber;
    }
}
