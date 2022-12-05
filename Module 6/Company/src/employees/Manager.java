package employees;

public class Manager implements Employee {
    private final int FIXED_SALARY = 80000;
    private final int BONUS;
    public Manager() {
        BONUS = (int) Math.round((115000 + Math.random() * 35000) * 0.05);
    }
    @Override
    public int getMonthSalary() {
        return FIXED_SALARY + getBONUS();
    }

    public int getBONUS() {
        return BONUS;
    }

    @Override
    public String toString() {
        return "ТИП: менеджер" +
                "\n\tЗ/П " + FIXED_SALARY + " руб. + бонус(" + getBONUS() + ") руб.";
    }
}
