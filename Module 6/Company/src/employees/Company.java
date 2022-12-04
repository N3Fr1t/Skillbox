package employees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Company {
    public List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public static int getIncome() {
        return (int) Math.round(5000000 + Math.random() * 10000000);
    }

    public int countEmployees() {
        return employees.size();
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return sortedEmployees(count, (o1, o2) -> o2.getMonthSalary() - o1.getMonthSalary());
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return sortedEmployees(count, Comparator.comparingInt(Employee::getMonthSalary));
    }

    private List<Employee> sortedEmployees(int count, Comparator<Employee> comparator) {
        employees.sort(comparator);
        List<Employee> employeeCopy = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            employeeCopy.add(employees.get(i));
        }
        return employeeCopy;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
