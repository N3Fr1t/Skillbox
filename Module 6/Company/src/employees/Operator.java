package employees;

public class Operator implements Employee {
    @Override
    public int getMonthSalary() {
        return 40000;
    }

    @Override
    public String toString() {
        return "ТИП: Оператор" +
                "\n\tЗ/П " + getMonthSalary() + " руб.";
    }
}
