package BankAccount;

import java.text.DecimalFormat;

public class CardAccount extends BankAccount {
    public void withdrawMoney() {
        if ((getMoneyAmount() * 1.01) > getCurrentMoneyAmount()) {
            System.out.println("\nНедостаточно средств для снятия наличных" +
                    "\nСумма с учетом комиссии, которую Вы хотите снять составляет: "
                    + new DecimalFormat("#0.00").format(getMoneyAmount() * 1.01) + "руб.");
            checkBalance();
        } else {
            setCurrentMoneyAmount(getCurrentMoneyAmount() - (getMoneyAmount() * 1.01));
        }
    }
}