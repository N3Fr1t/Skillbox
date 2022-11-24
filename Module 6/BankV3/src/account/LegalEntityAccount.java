package account;

public class LegalEntityAccount extends Client {
    @Override
    public void withdrawMoney(double moneyAmount) {
        if (getCurrentMoney() >= moneyAmount * 1.01) {
            setCurrentMoney(getCurrentMoney() - moneyAmount * 1.01);
        } else {
            System.out.println("На балансе Вашего счета недостаточно средств для совершения данной операции");
            System.out.println("Сумма с учетом комиссии, которую Вы хотите снять составляет " + moneyAmount * 1.01);
            checkMoney();
        }
    }

    @Override
    public void accountInfo() {
        for (String client : getClientAccount()) {
            System.out.println("Информация о счете " + client +
                    "\n\tЮридическое лицо" +
                    "\n\tПополнение без комиссии" +
                    "\n\tСнятие с комиссией 1%" +
                    "\n\tБаланс: " + getCurrentMoney() + '\n');
        }
    }
}
