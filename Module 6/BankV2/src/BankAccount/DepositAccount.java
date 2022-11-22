package BankAccount;

public class DepositAccount extends BankAccount {
    private long currentTimeMillis;
    private final long MONTH_MILLIS = (long) (2.592 * Math.pow(10, 9));

    public void withdrawMoney() {
        if (isTimeCheck()) {
            if (getMoneyAmount() > getCurrentMoneyAmount()) {
                System.out.println("Недостаточно средств для снятия наличных");
                checkBalance();
            } else {
                setCurrentMoneyAmount(getCurrentMoneyAmount() - getMoneyAmount());
            }
        } else {
            System.out.println("С момента последнего депозита не прошло 30 дней");
        }
    }

    public void depositMoney() {
        setCurrentMoneyAmount(getCurrentMoneyAmount() + getMoneyAmount());
        currentTimeMillis = System.currentTimeMillis();
    }

    private boolean isTimeCheck() {
        return (System.currentTimeMillis() - currentTimeMillis) > MONTH_MILLIS;
    }
}