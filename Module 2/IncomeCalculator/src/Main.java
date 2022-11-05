import java.util.Scanner;

/*
Менеджер забирает 15% дохода компании
Налог компании равен 24%
Минимальнаня сумма инвестирования компании 100к денег

Аренда + телефония + доступ в интернет + зарплата ассистента + зарплата финансового менеджера  = 294200 денег

294200 - ежемесячная трата без учета дохода манагера

!!! Найти точку безубыточности компании?
При доходе компании в 0, сумма налога будет равна нулю.
Точка безубыточности имеет место быть при: доход - выплата_зарплаты_манагеру = 0.
Зарплата манагера = 15% от суммы дохода компании.
294200 = 85% от необходимой суммы дохода компании.
294200 / 85 * 100 = точка безубыточности.

Ответ: точка безубыточности компании ~346118


!!!Найти минимальную сумму дохода, при вводе которой программа ответит, что инвестировать можно?
При доходе компании выше нуля, сумма налога будет равна 24% от дохода.

точка безубыточности + ((минимальная сумма инвестиций / ((100 - 24) * 100)) / (100 - 15) * 100) = компания может инвестировать

346118 + (100000 / 0.76) / 0.85 = 500,916.7616099071

Ответ: 500917
*/

public class Main {
    private static int minIncome = 200000;
    private static int maxIncome = 900000;

    private static int officeRentCharge = 140000; //аренда помещения
    private static int telephonyCharge = 12000; //телефония
    private static int internetAccessCharge = 7200; //доступ в интернет

    private static int assistantSalary = 45000; //зарплата ассистента
    private static int financeManagerSalary = 90000; //зарплата финансового менеджера

    private static double mainTaxPercent = 0.24; //основной налоговый процент
    private static double managerPercent = 0.15; //процент менеджера

    private static double minInvestmentsAmount = 100000; //минимальная сумма инвестиций

    public static void main(String[] args) {
        while (true) {
            System.out.print("Введите сумму доходов компании за месяц " +
                    "(от 200 до 900 тысяч рублей): ");
            int income = (new Scanner(System.in)).nextInt();

            if (!checkIncomeRange(income)) {
                continue;
            }

            //из введенной суммы сразу вычитается налог для манагера 15%
            double managerSalary = income * managerPercent; //зарплата менеджера

            //чистый доход = введенная сумма - доход манагера - (officeRentCharge + telephonyCharge +
            // + internetAccessCharge + assistantSalary + financeManagerSalary)
            double pureIncome = income - managerSalary - calculateFixedCharges(); //чистый доход

            //налог вычитается после вычета зарплаты для манагера
            double taxAmount = mainTaxPercent * pureIncome; //сумма налога
            double pureIncomeAfterTax = pureIncome - taxAmount; //сумма дохода после вычета налога

            boolean canMakeInvestments = pureIncomeAfterTax >= minInvestmentsAmount; //возможность инвестирования

            System.out.println("Зарплата менеджера: " + managerSalary);
            System.out.println("Общая сумма налогов: " +
                    (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Компания может инвестировать: " +
                    (canMakeInvestments ? "да" : "нет"));
            if (pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }
        }
    }

    private static boolean checkIncomeRange(int income) {
        if (income < minIncome) {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if (income > maxIncome) {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges() {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
