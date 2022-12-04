import employees.*;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        hireEmployees(company);
        printHighestSalaries(company);
        printLowestSalaries(company);
        fireHalfEmployees(company);
        printHighestSalaries(company);
        printLowestSalaries(company);
    }

    public static void hireEmployees(Company company) {
        for (int i = 0; i < 180; i++) {
            company.hire(new Operator());
        }

        for (int i = 0; i < 80; i++) {
            company.hire(new Manager());
        }

        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager());
        }
        System.out.println("Добавлено " + company.countEmployees() + " сотрудников");
        System.out.println("============================");
    }

    private static void printHighestSalaries(Company company) {
        System.out.println("Список самых высоких зарплат");
        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("============================");
    }

    private static void printLowestSalaries(Company company) {
        System.out.println("Список самых низких зарплат");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("============================");
    }

    private static void fireHalfEmployees(Company company) {
        int firedEmployeesCount = company.countEmployees();

        for (int i = 0; i < company.countEmployees() / 2; i++) {
            int index = (int) (Math.random() * company.countEmployees());
            Employee firedEmployee = company.getEmployees().get(index);
            company.fire(firedEmployee);
        }
        System.out.println("Уволено " + firedEmployeesCount / 2  + " сотрудников");
        System.out.println("============================");
    }
}
