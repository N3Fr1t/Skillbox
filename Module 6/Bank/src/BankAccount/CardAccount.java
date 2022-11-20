package BankAccount;

import java.text.DecimalFormat;

public class CardAccount extends CheckingAccount {
    public void withdrawMoney() {
        if ((moneyAmount * 1.01) > currentMoneyAmount) {
            System.out.println("\nНедостаточно средств для снятия наличных" +
                    "\nСумма с учетом комиссии, которую Вы хотите снять составляет: "
                    + new DecimalFormat("#0.00").format(moneyAmount * 1.01) + "руб.");
            checkBalance();
        } else {
            currentMoneyAmount -= (moneyAmount * 1.01);
        }
    }
}
