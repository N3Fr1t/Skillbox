package account;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Client {
    private double currentMoney;
    private ArrayList<String> clientAccount = new ArrayList<>();

    public Client() {
        currentMoney = 0;
        clientAccount = clientAccountGenerate();
    }

    public ArrayList<String> clientAccountGenerate() {
        clientAccount.add(Math.round(405 + Math.random() * 3) + "" + Math.round(Math.pow(10, 16) + Math.random() * 89999999999999999.0));
        return clientAccount;
    }

    double getCurrentMoney() {
        return Double.parseDouble(new DecimalFormat("#0.00").format(currentMoney));
    }

    void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }

    public void withdrawMoney(double moneyAmount) {
        if (currentMoney >= moneyAmount) {
            currentMoney -= moneyAmount;
        } else {
            notMoneyEnough();
        }
    }

    void notMoneyEnough() {
        System.out.println("На балансе Вашего счета недостаточно средств для совершения данной операции");
    }

    public void send(Client receiver, double moneyAmount) {
        if (currentMoney >= moneyAmount) {
            currentMoney -= moneyAmount;
            receiver.setCurrentMoney(receiver.getCurrentMoney() + moneyAmount);
            System.out.println("Средства успешно переведены на лицевой счет " + receiver.getClientAccount());
        } else {
            notMoneyEnough();
        }
    }

    ArrayList<String> getClientAccount() {
        return clientAccount;
    }

    public void depositMoney(double moneyAmount) {
        currentMoney += moneyAmount;
    }

    public void checkMoney() {
        System.out.println("На балансе Вашего счета " + getCurrentMoney() + "руб.");
    }

    public abstract void accountInfo();
}