import employees.*;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        System.out.println("Доход компании составил " + Company.getIncome() + " руб.\n");

        hireEmployee(company);
        hireAllEmployee(company);
        System.out.println("Всего в компании " + company.getEmployeesCount() + " сотрудников\n");

        printTopSalary(company);
        printLowestSalary(company);

        fireHalfEmployees(company);
        printTopSalary(company);
        printLowestSalary(company);
    }

    public static void hireEmployee(Company company) {
        int employeesCount = company.getEmployeesCount();
        company.hire(new Operator());
        company.hire(new Manager());
        company.hire(new TopManager());

        System.out.println("Добавлено " + (company.getEmployeesCount() - employeesCount) + " сотрудников");
    }

    public static void hireAllEmployee(Company company) {
        Collection<Employee> employees = new ArrayList<>();
        int employeesCount = company.getEmployeesCount();

        for (int i = 0; i < 179; i++) {
            employees.add(new Operator());
        }

        for (int i = 0; i < 79; i++) {
            employees.add(new Manager());
        }

        for (int i = 0; i < 9; i++) {
            employees.add(new TopManager());
        }
        company.hireAll(employees);

        System.out.println("Добавлено " + (company.getEmployeesCount() - employeesCount) + " сотрудников");
    }

    public static void printTopSalary(Company company) {
        System.out.println("Список самых высоких зарплат");
        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }
        System.out.println();
    }

    public static void printLowestSalary(Company company) {
        System.out.println("Список самых низких зарплат");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }
    }

    public static void fireHalfEmployees(Company company) {
        int firedEmployeesCount = company.getEmployeesCount();

        for (int i = 0; i < company.getEmployeesCount() / 2; i++) {
            company.fire(company.getEmployees().get((int) (Math.random() * company.getEmployeesCount())));
        }
        System.out.println("\nУволено " + firedEmployeesCount / 2 + " сотрудников\n");
    }
}
