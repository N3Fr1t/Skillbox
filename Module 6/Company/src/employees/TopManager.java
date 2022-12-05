package employees;

public class TopManager implements Employee {
    @Override
    public int getMonthSalary() {
        int FIXED_SALARY = 150000;

        if (Company.getIncome() > 10000000) {
            return FIXED_SALARY + (int) (FIXED_SALARY * 1.5);
        } else
            return 150000;
    }

    @Override
    public String toString() {
        return "ТИП: топ менеджер" +
                "\n\tЗ/П " + getMonthSalary() + " руб.";
    }
}
