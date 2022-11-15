import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private String email = "";
    private String[] emailArr;
    private static final TreeSet<String> EMAILS = new TreeSet<>();

    private static final String EMAIL_REGEX = "(?:[a-z\\d!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z\\d!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z\\d](?:[a-z\\d-]*[a-z\\d])?\\.)+[a-z\\d](?:[a-z\\d-]*[a-z\\d])?|\\[(?:(?:25[0-5]|2[0-4][\\d+]|[01]?[\\d+][\\d+]?)\\.){3}(?:25[0-5]|2[0-4][\\d+]|[01]?[\\d+][\\d+]?|[a-z\\d-]*[a-z\\d]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    public Email() {
    }

    public void printList() {
        if (!EMAILS.isEmpty()) {
            System.out.println("Список электронных почт:");
            for (String s : EMAILS) {
                System.out.println(s);
            }
        } else
            System.out.println("Список адресов электронных почт пуст");
    }

    public String emailWithoutPrefix() {
        return email.substring(emailArr[0].length()).trim();
    }

    public void addNewEmail() {
        if (emailArr.length > 1) {
            if (emailValidator()) {
                EMAILS.add(emailWithoutPrefix());
                System.out.println("Почта успешно сохранена");
            } else
                System.out.println("Вы ввели некорректный адрес электронной почты");
        } else
            System.out.println("Вы не ввели адрес электронной почты");
    }

    public boolean emailValidator() {
        if (emailArr[1] == null)
            return false;

        Matcher matcher = EMAIL_PATTERN.matcher(emailArr[1]);
        return matcher.matches();
    }

    public void printCommandList() {
        System.out.println("Список доступных команд: LIST, ADD" +
                "\nLIST — выводит список электронных адресов" +
                "\nADD — проверяет и, если формат адреса верный, добавляет в множество\n");
    }

    public void start() throws IOException {
        printCommandList();

        while (!email.equals("exit")) {
            System.out.print("Введите команду: ");

            email = new BufferedReader(new InputStreamReader(System.in)).readLine();
            emailArr = email.split("\\s+");

            if (emailArr[0].equalsIgnoreCase("list"))
                printList();
            else if (emailArr[0].equalsIgnoreCase("add"))
                addNewEmail();
            else if (emailArr[0].equalsIgnoreCase("exit"))
                break;
            else {
                System.out.println("Введена неверная команда");
                printCommandList();
            }
            System.out.println();
        }
    }
}