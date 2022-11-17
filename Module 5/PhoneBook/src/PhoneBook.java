import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class PhoneBook {
    private String subscriber = "";
    private final TreeMap<String, String> SUBSCRIBERS = new TreeMap<>();

    public PhoneBook() {
    }

    public boolean isCorrectPhoneNumber() {
        return subscriber.trim().matches(".*\\d.*") && (subscriber.length() == 11 && subscriber.indexOf("7") == 0);
    }

    public boolean isCorrectName() {
        return subscriber.trim().matches(".*\\D+.*");
    }

    public boolean isCorrectData() {
        return !(isCorrectName() && isCorrectPhoneNumber());
    }

    public void printMap() {
        if (!SUBSCRIBERS.isEmpty()) {
            for (String key : SUBSCRIBERS.keySet()) {
                System.out.println("\t" + key + " - " + SUBSCRIBERS.get(key));
            }
        } else {
            System.out.println("Телефонная книга пуста\n");
        }
    }

    public boolean isDuplicate(String value) {
        for (String key : SUBSCRIBERS.keySet()) {
            return SUBSCRIBERS.containsKey(value) || SUBSCRIBERS.containsValue(value);
        }
        return false;
    }

    public void printContactInfo() {
        for (String key : SUBSCRIBERS.keySet()) {
            if (SUBSCRIBERS.get(key).equals(subscriber) && isCorrectPhoneNumber()) {
                System.out.println("\t" + key + " - " + SUBSCRIBERS.get(key));
                break;
            } else if (SUBSCRIBERS.containsKey(subscriber) && isCorrectName()) {
                System.out.println("\t" + subscriber + " - " + SUBSCRIBERS.get(subscriber));
                break;
            }
        }
    }

    public void addName() throws IOException {
        System.out.print("Введите имя: ");
        String subscriberName = new BufferedReader(new InputStreamReader(System.in)).readLine();

        if (isDuplicate(subscriberName)) {
            System.out.println("Такое имя уже существует");
        } else if (subscriberName.trim().matches(".*\\d.*")) {
            System.out.println("Имя введено некорректно");
        } else {
            SUBSCRIBERS.put(subscriberName, subscriber);
        }
    }

    public void addPhoneNumber() throws IOException {
        System.out.print("Введите номер телефона: ");
        String subscriberPhoneNumber = new BufferedReader(new InputStreamReader(System.in)).readLine();

        if (isDuplicate(subscriberPhoneNumber)) {
            System.out.println("Такой номер телефона уже существует");
        } else if (subscriberPhoneNumber.trim().matches(".*\\D.*") || !(subscriberPhoneNumber.length() == 11 && subscriberPhoneNumber.indexOf("7") == 0)) {
            System.out.println("Номер телефона введен некорректно. Допустимый формат номера телефона 79991234567\n");
        } else {
            SUBSCRIBERS.put(subscriber, subscriberPhoneNumber);
        }
    }

    public void start() throws IOException {
        while (!subscriber.equals("exit")) {
            System.out.print("Введите имя или номер: ");
            subscriber = new BufferedReader(new InputStreamReader(System.in)).readLine();

            if (subscriber.equalsIgnoreCase("list")) {
                printMap();
            } else if (!isDuplicate(subscriber) && !subscriber.equals("exit")) {
                if (isCorrectData()) {
                    if (isCorrectName()) {
                        addPhoneNumber();
                    } else if (isCorrectPhoneNumber()) {
                        addName();
                    } else {
                        System.out.println("Номер телефона введен некорректно. Допустимый формат номера телефона 79991234567\n");
                    }
                } else {
                    System.out.println("Данные введены некорректно\n");
                }
            } else {
                printContactInfo();
            }
        }
    }
}