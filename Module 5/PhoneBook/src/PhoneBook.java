import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class PhoneBook {
    private String subscriber = "";
    private String subscriberName = "";
    private String subscriberNumber = "";
    private final TreeMap<String, String> SUBSCRIBERS = new TreeMap<>();

    public PhoneBook() {
    }

    public boolean isCorrectPhoneNumber() {
        return subscriberNumber.trim().matches(".*\\d.*") && ((subscriberNumber.length() == 11 &&
                (subscriberNumber.indexOf("7") == 0 || subscriberNumber.indexOf("8") == 0)) ||
                (subscriberNumber.length() == 10 && subscriberNumber.indexOf("9") == 0)
        );
    }

    public boolean isCorrectName() {
        return subscriberName.trim().matches(".*^[a-zA-Zа-яА-Я].*$");
    }

    public boolean isCorrectData() {
        return isCorrectName() || isCorrectPhoneNumber();
    }

    public void printMap() {
        if (!SUBSCRIBERS.isEmpty()) {
            for (String key : SUBSCRIBERS.keySet()) {
                System.out.println("\t" + key + " - " + SUBSCRIBERS.get(key));
            }
        } else {
            System.out.println("Телефонная книга пуста");
        }
    }

    public boolean isDuplicate(String value) {
        for (String ignored : SUBSCRIBERS.keySet()) {
            return SUBSCRIBERS.containsKey(value) || SUBSCRIBERS.containsValue(value);
        }
        return false;
    }

    public boolean isDuplicateNameOrNumber () {
        return isDuplicate(subscriberName) || isDuplicate(subscriberNumber);
    }

    public void printContactInfo() {
        for (String key : SUBSCRIBERS.keySet()) {
            if (SUBSCRIBERS.get(key).equals(subscriberNumber) && isCorrectPhoneNumber()) {
                System.out.println("\t" + key + " - " + SUBSCRIBERS.get(key));
                break;
            } else if (SUBSCRIBERS.containsKey(subscriberName) && isCorrectName()) {
                System.out.println("\t" + subscriber + " - " + SUBSCRIBERS.get(subscriber));
                break;
            }
        }
    }

    public void addName() throws IOException {
        System.out.print("Введите имя: ");
        subscriberName = new BufferedReader(new InputStreamReader(System.in)).readLine();

        if (isDuplicate(subscriberName)) {
            System.out.println("Такое имя уже существует");
        } else if (subscriberName.trim().matches(".*\\d.*")) {
            System.out.println("Имя введено некорректно");
        } else {
            SUBSCRIBERS.put(subscriberName, subscriberNumber);
        }
    }

    public void addPhoneNumber() throws IOException {
        System.out.print("Введите номер телефона: ");
        subscriberNumber = new BufferedReader(new InputStreamReader(System.in)).readLine();
        checkNumberFormat();

        if (isDuplicate(subscriberNumber)) {
            System.out.println("Такой номер телефона уже существует");
        } else if (!isCorrectPhoneNumber()) {
            System.out.println("Неверный формат номера");
        } else {
            SUBSCRIBERS.put(subscriberName, subscriberNumber);
        }
    }

    public void subscriberIsNameOrNumber() {
        if (subscriber.trim().matches(".*\\d+.*")) {
            subscriberNumber = subscriber;
            subscriberName = "";

            checkNumberFormat();
        } else if (subscriber.trim().matches("^[a-zA-Zа-яА-Я]*$")) {
            subscriberName = subscriber;
            subscriberNumber = "";
        }
    }

    public void checkNumberFormat() {
        StringBuilder stringBuilder;
        subscriberNumber = subscriberNumber.replaceAll("\\D", "");

        for (; ; ) {
            stringBuilder = new StringBuilder(subscriberNumber);
            if (isCorrectPhoneNumber()) {
                if (subscriberNumber.indexOf("7") == 0) {
                    break;
                } else if (subscriberNumber.indexOf("8") == 0) {
                    subscriberNumber = String.valueOf(stringBuilder.replace(0, 1, "7"));
                    break;
                } else if (stringBuilder.indexOf("9") == 0) {
                    subscriberNumber = String.valueOf(stringBuilder.insert(0, "7"));
                    break;
                }
            } else {
                break;
            }
        }
    }

    public void start() throws IOException {
        while (!subscriber.equals("exit")) {
            System.out.print("Введите имя или номер: ");
            subscriber = new BufferedReader(new InputStreamReader(System.in)).readLine();

            subscriberIsNameOrNumber();
            if (subscriber.equalsIgnoreCase("list")) {
                printMap();
            } else if (!isDuplicateNameOrNumber() && !subscriber.equals("exit")) {
                if (isCorrectData()) {
                    if (isCorrectName()) {
                        addPhoneNumber();
                    } else if (isCorrectPhoneNumber()) {
                        addName();
                    }
                } else {
                    System.out.println("Данные введены некорректно");
                }
            } else {
                printContactInfo();
            }
            System.out.println();
        }
    }
}