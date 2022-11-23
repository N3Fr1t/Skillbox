import account.Client;
import account.IndividualAccount;
import account.IndividualEntrepreneurAccount;
import account.LegalEntityAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String operation = "";

        Client individualAccount = new IndividualAccount();
        Client individualEntrepreneurAccount = new IndividualEntrepreneurAccount();
        Client individualEntrepreneurAccount2 = new IndividualEntrepreneurAccount();
        Client legalEntityAccount = new LegalEntityAccount();

        System.out.println("Список доступных операций:\n\tВНЕСТИ\n\tСНЯТЬ\n\tПЕРЕВЕСТИ\n\tБАЛАНС\n\tВЫЙТИ");

        while (!operation.equals("выйти")) {
            System.out.print("\nВыберите операцию: ");
            operation = reader.readLine().toLowerCase();

            operationCheck(operation);

            switch (operation) {
                case "внести":
                    deposit(reader, individualAccount, individualEntrepreneurAccount, individualEntrepreneurAccount2, legalEntityAccount);
                    break;
                case "снять":
                    withdraw(reader, individualAccount, individualEntrepreneurAccount, individualEntrepreneurAccount2, legalEntityAccount);
                    break;
                case "перевести":
                    send(reader, individualAccount, individualEntrepreneurAccount, individualEntrepreneurAccount2, legalEntityAccount);
                    break;
                case "баланс":
                    balance(individualAccount, individualEntrepreneurAccount, individualEntrepreneurAccount2, legalEntityAccount);
                    break;
                case "инфо":
                    info(individualAccount, individualEntrepreneurAccount, individualEntrepreneurAccount2, legalEntityAccount);
                    break;
                case "выйти":
                    break;
                default:
                    System.out.println("Введена неверная операция");
            }
        }
    }

    private static void operationCheck(String operation) {
        if (!(operation.equals("баланс") ||  operation.equals("инфо") || operation.equals("выйти")) && (operation.equals("внести") || operation.equals("снять") || operation.equals("перевести"))) {
            System.out.print("Какую сумму Вы хотите " + operation + "? ");
        }
    }

    private static double readerDouble(BufferedReader reader) throws IOException {
        return Double.parseDouble(reader.readLine().replaceAll("\\D^[.?]", ""));
    }

    private static void deposit(BufferedReader reader, Client individualAccount, Client individualEntrepreneurAccount, Client individualEntrepreneurAccount2, Client legalEntityAccount) throws IOException {
        individualAccount.depositMoney(readerDouble(reader));
        individualEntrepreneurAccount.depositMoney(readerDouble(reader));
        individualEntrepreneurAccount2.depositMoney(readerDouble(reader));
        legalEntityAccount.depositMoney(readerDouble(reader));
    }

    private static void withdraw(BufferedReader reader, Client individualAccount, Client individualEntrepreneurAccount, Client individualEntrepreneurAccount2, Client legalEntityAccount) throws IOException {
        individualAccount.withdrawMoney(readerDouble(reader));
        individualEntrepreneurAccount.withdrawMoney(readerDouble(reader));
        individualEntrepreneurAccount2.withdrawMoney(readerDouble(reader));
        legalEntityAccount.withdrawMoney(readerDouble(reader));
    }

    private static void send(BufferedReader reader, Client individualAccount, Client individualEntrepreneurAccount, Client individualEntrepreneurAccount2, Client legalEntityAccount) throws IOException {
        individualAccount.send(legalEntityAccount, readerDouble(reader));
        legalEntityAccount.send(individualEntrepreneurAccount, readerDouble(reader));
        individualEntrepreneurAccount.send(individualEntrepreneurAccount2, readerDouble(reader));
    }

    private static void balance(Client individualAccount, Client individualEntrepreneurAccount, Client individualEntrepreneurAccount2, Client legalEntityAccount) {
        individualAccount.checkMoney();
        individualEntrepreneurAccount.checkMoney();
        individualEntrepreneurAccount2.checkMoney();
        legalEntityAccount.checkMoney();
    }

    private static void info(Client individualAccount, Client individualEntrepreneurAccount, Client individualEntrepreneurAccount2, Client legalEntityAccount) {
        individualAccount.accountInfo();
        individualEntrepreneurAccount.accountInfo();
        individualEntrepreneurAccount2.accountInfo();
        legalEntityAccount.accountInfo();
    }
}
