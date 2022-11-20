package BankAccount;

import java.text.DecimalFormat;

public class CheckingAccount {
    protected double moneyAmount;
    protected double currentMoneyAmount;

    public CheckingAccount() {
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void depositMoney() {
        currentMoneyAmount += moneyAmount;
    }

    public void withdrawMoney() {
        if (moneyAmount > currentMoneyAmount) {
            System.out.println("Недостаточно средств для снятия наличных");
            checkBalance();
        } else {
            currentMoneyAmount -= moneyAmount;
        }
    }

    public void checkBalance() {
        System.out.println("На Вашем счете " + new DecimalFormat("#0.00").format(currentMoneyAmount) + "руб.");
    }
}