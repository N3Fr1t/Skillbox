public class Loader {
    private static final String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    public static void main(String[] args) {
        //String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        int vasyaMoney = getMoney("заработал", "рублей,");
        int petyaMoney = getMoney("Петя -", "рубля");
        int mashaMoney = getMoney("Маша -", "рублей");

        System.out.println("Сумма заработка всех ребят: " + (vasyaMoney + petyaMoney + mashaMoney));
    }

    public static int getMoney(String indexOf, String lastIndexOf) {
        int index = text.indexOf(indexOf) + indexOf.length();
        int lastIndex = text.lastIndexOf(lastIndexOf);

        return Integer.parseInt(text.substring(index, lastIndex).trim());
    }
}
