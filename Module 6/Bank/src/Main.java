import BankAccount.CardAccount;
import BankAccount.BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BankAccount bankAccount = new CardAccount();
        System.out.println("Список доступных операций:" +
                "\n\tВНЕСТИ\t\t - позволяет внести средства на счет" +
                "\n\tСНЯТЬ\t\t - позволяет снять средства со счета" +
                "\n\tПЕРЕВЕСТИ\t - позволяет перевести средства на другой счет" +
                "\n\tБАЛАНC\t\t - позволяет узнать баланс счета" +
                "\n\tВЫЙТИ");

        start(bankAccount);
    }

    private static void start(BankAccount bankAccount) throws IOException {
        String operation = "";
        while (!operation.equals("выйти")) {
            System.out.print("\nВыберите операцию: ");
            operation = new BufferedReader(new InputStreamReader(System.in)).readLine().toLowerCase();

            operationCheck(bankAccount, operation);
        }
    }

    private static void operationCheck(BankAccount bankAccount, String operation) throws IOException {
        if (!operation.equals("баланс") && (operation.equals("внести") || operation.equals("снять"))) {
           moneyManipulation(bankAccount, operation);

           depositOrWithdraw(bankAccount, operation);
        } else if (operation.equals("баланс")) {
            bankAccount.checkBalance();
        } else if (operation.equals("перевести")) {
            System.out.print("Какую сумму Вы хотите перевести? ");
            sendMoney(bankAccount);
        } else
            System.out.println("Неверная операция");
    }

    private static void moneyManipulation(BankAccount bankAccount, String operation) throws IOException {
        System.out.print("Какую сумму Вы хотите " + operation + "? ");
        bankAccount.setMoneyAmount(readerDouble());
    }

    private static void depositOrWithdraw(BankAccount bankAccount, String operation) {
        if (operation.equals("внести")) {
            bankAccount.depositMoney();
        } else {
            bankAccount.withdrawMoney();
        }
    }

    private static boolean isSend(BankAccount bankAccount) throws IOException {
        return bankAccount.send(new BankAccount(), readerDouble());
    }

    private static void sendMoney(BankAccount bankAccount) throws IOException {
        if (isSend(bankAccount)) {
            System.out.println("Денежные средства успешно переведены");
        } else {
            System.out.println("На Вашем счете недостаточно средств");
        }
    }

    private static double readerDouble() throws IOException {
        return Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("\\D", ""));
    }
}