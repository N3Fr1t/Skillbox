package account;

public class IndividualAccount extends Client {
    @Override
    public void accountInfo() {
        for (String client : getClientAccount()) {
            System.out.println("���������� � ����� " + client +
                    "\n\t���������� ����" +
                    "\n\t���������� ��� ��������" +
                    "\n\t������ ��� ��������" +
                    "\n\t������: " + getCurrentMoney() + '\n');
        }
    }
}
