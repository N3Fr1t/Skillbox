public class Loader {
    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");

        System.out.println(safe);
    }

    static String searchAndReplaceDiamonds(String text, String placeholder) {
        return text.replaceAll(text.substring(text.indexOf("<"), text.indexOf(">") + 1), placeholder);
    }
}
