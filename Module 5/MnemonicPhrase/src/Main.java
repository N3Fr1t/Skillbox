public class Main {
    public static void main(String[] args) {
        String phrase = "Каждый охотник желает знать, где сидит фазан.";
        String[] arrPhrase = phrase.split("\\s+");

        for (int i = arrPhrase.length - 1; i >= 0; i--) {
            System.out.println(arrPhrase[i]);
        }
    }
}