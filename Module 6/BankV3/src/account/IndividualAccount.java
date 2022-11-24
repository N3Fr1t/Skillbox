package account;

public class IndividualAccount extends Client {
    @Override
    public void accountInfo() {
        for (String client : getClientAccount()) {
            System.out.println("Информация о счете " + client +
                    "\n\tФизическое лицо" +
                    "\n\tПополнение без комиссии" +
                    "\n\tСнятие без комиссии" +
                    "\n\tБаланс: " + getCurrentMoney() + '\n');
        }
    }
}
