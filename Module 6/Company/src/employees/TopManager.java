package employees;

public class TopManager implements Employee {
    private static final int FIXED_SALARY = 120000;

    @Override
    public int getMonthSalary() {
        return (FIXED_SALARY + (Company.getIncome() > 10000000 ? (int) (FIXED_SALARY * 1.5) : 0));
    }
}