import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        String text = "Номер кредитной карты <4008 1234 5678> 8912";
        String placeholder = "***";

        String safe = searchAndReplaceDiamonds(text, placeholder);

        System.out.println(safe);
    }

    static String searchAndReplaceDiamonds(String text, String placeholder) {
        return Pattern.compile("<[^>]*>").matcher(text).replaceAll(placeholder);
    }
}
