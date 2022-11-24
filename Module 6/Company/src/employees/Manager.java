package employees;

public class Manager implements Employee {
    private static final int FIXED_SALARY = 80000;

    @Override
    public int getMonthSalary() {
        return FIXED_SALARY + (int) (moneyCompanyGenerate() * 0.05);
    }

    public long moneyCompanyGenerate() {
        return Math.round(115000 + Math.random() * 140000);
    }
}