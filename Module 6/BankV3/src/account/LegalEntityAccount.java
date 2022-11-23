package account;

public class LegalEntityAccount extends Client {
    @Override
    public void withdrawMoney(double moneyAmount) {
        if (getCurrentMoney() >= moneyAmount * 1.01) {
            setCurrentMoney(getCurrentMoney() - moneyAmount * 1.01);
        } else {
            System.out.println("�� ������� ������ ����� ������������ ������� ��� ���������� ������ ��������");
            System.out.println("����� � ������ ��������, ������� �� ������ ����� ���������� " + moneyAmount * 1.01);
            checkMoney();
        }
    }

    @Override
    public void accountInfo() {
        for (String client : getClientAccount()) {
            System.out.println("���������� � ����� " + client +
                    "\n\t����������� ����" +
                    "\n\t���������� ��� ��������" +
                    "\n\t������ � ��������� 1%" +
                    "\n\t������: " + getCurrentMoney() + '\n');
        }
    }
}
