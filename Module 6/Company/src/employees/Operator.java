package employees;

public class Operator implements Employee {
    private static final int FIXED_SALARY = 40000;

    @Override
    public int getMonthSalary() {
        return FIXED_SALARY;
    }
}