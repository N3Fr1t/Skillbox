package employees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Company {
    private static int income;
    private final List<Employee> employees = new ArrayList<>();
    public Company() {
        income = (int) Math.round(5000000 + Math.random() * 10000000);
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public static int getIncome() {
        return income;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public int getEmployeesCount() {
        return employees.size();
    }

    private List<Employee> sortedEmployees(int count, Comparator<Employee> comparator) {
        employees.sort(comparator);

        List<Employee> copyEmployee = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            copyEmployee.add(employees.get(i));
        }
        return copyEmployee;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return sortedEmployees(count, (o1, o2) -> o2.getMonthSalary() - o1.getMonthSalary());
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return sortedEmployees(count, Comparator.comparingInt(Employee::getMonthSalary));
    }

//    public void printEmployees() {
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
//        System.out.println("============================");
//    }
}
