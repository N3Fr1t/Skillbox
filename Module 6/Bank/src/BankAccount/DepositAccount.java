package BankAccount;

public class DepositAccount extends CheckingAccount {
    private long currentTimeMillis;
    private final long MONTH_MILLIS = (long) (2.592 * Math.pow(10, 9));

    public void withdrawMoney() {
        if (isTimeCheck()) {
            if (moneyAmount > currentMoneyAmount) {
                System.out.println("Недостаточно средств для снятия наличных");
                checkBalance();
            } else {
                currentMoneyAmount -= moneyAmount;
            }
        } else {
            System.out.println("С момента последнего депозита не прошло 30 дней");
        }
    }

    public void depositMoney() {
        currentMoneyAmount += moneyAmount;
        currentTimeMillis = System.currentTimeMillis();
    }

    private boolean isTimeCheck() {
        return (System.currentTimeMillis() - currentTimeMillis) > MONTH_MILLIS;
    }
}