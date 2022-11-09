public class Loader {
    public static void main(String[] args) {
        String enAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ruAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЗЖИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        System.out.println("-----English-----");
        printCode(enAlphabet);

        System.out.println("-----Russian-----");
        printCode(ruAlphabet);
    }

    public static void printCode(String alphabet) {
        for (int i = 0; i < alphabet.length(); i++) {
            System.out.println("\t" + alphabet.charAt(i) + " = " + (int) alphabet.charAt(i));
        }
    }
}
