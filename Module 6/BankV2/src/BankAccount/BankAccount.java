package BankAccount;

import java.text.DecimalFormat;

public class BankAccount {
    private double moneyAmount;
    private double currentMoneyAmount;

    public BankAccount() {
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    double getMoneyAmount() {
        return moneyAmount;
    }

    double getCurrentMoneyAmount() {
        return currentMoneyAmount;
    }

    void setCurrentMoneyAmount(double currentMoneyAmount) {
        this.currentMoneyAmount = currentMoneyAmount;
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