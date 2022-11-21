import BankAccount.CardAccount;
import BankAccount.BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BankAccount bankAccount = new CardAccount();
        System.out.println("Список доступных операций:" +
                "\n\t* внести" +
                "\n\t* снять" +
                "\n\t* баланс" +
                "\n\t* выйти");

        start(bankAccount);
    }

    public static void start(BankAccount bankAccount) throws IOException, InterruptedException {
        String operation = "";
        while (!operation.equals("выйти")) {
            System.out.print("Выберите операцию: ");
            operation = new BufferedReader(new InputStreamReader(System.in)).readLine();

            if (!operation.equalsIgnoreCase("баланс") && (operation.equalsIgnoreCase("внести") || operation.equalsIgnoreCase("снять"))) {
                System.out.print("Какую сумму Вы хотите " + operation + "? ");
                bankAccount.setMoneyAmount(Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("\\D^.", "")));

                if (operation.equalsIgnoreCase("внести")) {
                    bankAccount.depositMoney();
                } else if (operation.equalsIgnoreCase("снять")) {
                    bankAccount.withdrawMoney();
                }
            } else if (operation.equalsIgnoreCase("баланс")) {
                bankAccount.checkBalance();
            } else {
                System.out.println("Введена неверная операция");
                Thread.sleep(1500);
            }
            System.out.println();
        }
    }
}