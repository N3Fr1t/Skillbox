public class TicketsNumber {
    public static void main(String[] args) {
        int condition = 200000;

        for (int i = 200000; i <= 210000; i++) {
            System.out.println("Билет № " + i);
        }

        System.out.println();

        for (int i = 220000; i <= 235000; i++) {
            System.out.println("Билет № " + i);
        }

        System.out.println();

        while (condition <= 210000) {
            System.out.println("Билет № " + condition);
            condition++;
        }

        System.out.println();
        condition = 220000;

        while (condition <= 235000) {
            System.out.println("Билет № " + condition);
            condition++;
        }
    }
}
