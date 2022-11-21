import BankAccount.CardAccount;
import BankAccount.CheckingAccount;
import BankAccount.DepositAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        CheckingAccount checkingAccount = new CardAccount();
        System.out.println("Список доступных операций:" +
                "\n\t* внести" +
                "\n\t* снять" +
                "\n\t* баланс" +
                "\n\t* выйти");

        start(checkingAccount);
    }

    public static void start(CheckingAccount checkingAccount) throws IOException, InterruptedException {
        String operation = "";
        while (!operation.equals("выйти")) {
            System.out.print("Выберите операцию: ");
            operation = new BufferedReader(new InputStreamReader(System.in)).readLine();

            if (!operation.equalsIgnoreCase("баланс") && (operation.equalsIgnoreCase("внести") || operation.equalsIgnoreCase("снять"))) {
                System.out.print("Какую сумму Вы хотите " + operation + "? ");
                checkingAccount.setMoneyAmount(Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("\\D^.", "")));

                if (operation.equalsIgnoreCase("внести")) {
                    checkingAccount.depositMoney();
                } else if (operation.equalsIgnoreCase("снять")) {
                    checkingAccount.withdrawMoney();
                }
            } else if (operation.equalsIgnoreCase("баланс")) {
                checkingAccount.checkBalance();
            } else {
                System.out.println("Введена неверная операция");
                Thread.sleep(1500);
            }
            System.out.println();
        }
    }
}