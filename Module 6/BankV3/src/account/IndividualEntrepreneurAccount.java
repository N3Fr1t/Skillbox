package account;

public class IndividualEntrepreneurAccount extends Client {
    @Override
    public void depositMoney(double moneyAmount) {
        if (isCheckBalance(moneyAmount) && getCurrentMoney() > moneyAmount) {
            setCurrentMoney(getCurrentMoney() + moneyAmount * 0.99);
        } else {
            setCurrentMoney(getCurrentMoney() + moneyAmount * 0.995);
        }
    }

    @Override
    public void accountInfo() {
        for (String client : getClientAccount()) {
            System.out.println("���������� � ����� " + client +
                    "\n\t�������������� ���������������" +
                    "\n\t���������� � ��������� " + (isCheckBalance(getCurrentMoney()) ? "0.5%" : "1%") +
                    "\n\t������ ��� ��������" +
                    "\n\t������: " + getCurrentMoney() + '\n');
        }
    }

    private boolean isCheckBalance(double moneyAmount) {
        return (moneyAmount < 1000);
    }

}
