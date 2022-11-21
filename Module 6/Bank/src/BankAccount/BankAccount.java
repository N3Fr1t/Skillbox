package BankAccount;

import java.text.DecimalFormat;

public class BankAccount {
    protected double moneyAmount;
    protected double currentMoneyAmount;

    public BankAccount() {
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

    public boolean send(BankAccount receiver, double moneyAmount) {
        if (currentMoneyAmount >= moneyAmount) {
            currentMoneyAmount -= moneyAmount;

            receiver.currentMoneyAmount += moneyAmount;
            return true;
        }
        else {
            return false;
        }
    }
}