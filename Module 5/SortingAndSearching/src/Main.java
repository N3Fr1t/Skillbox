import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    private static final String[] XYZ = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    private static final String[] REGION_LIST = {"01", "02", "102", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "113",
            "14", "15", "16", "116", "17", "18", "19", "20", "20", "95", "21", "121", "22", "23", "93", "123",
            "24", "84", "88", "124", "25", "125", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35",
            "36", "136", "37", "38", "85", "39", "91", "40", "41", "82", "42", "142", "43", "44", "45", "46",
            "47", "48", "49", "50", "90", "150", "190", "51", "52", "152", "53", "54", "154", "55", "56", "57",
            "58", "59", "81", "159", "60", "61", "161", "62", "63", "163", "64", "164", "65", "66", "96", "67",
            "68", "69", "70", "71", "72", "73", "173", "74", "174", "75", "80", "76", "77", "97", "99", "177",
            "199", "197", "777", "78", "98", "178", "79", "83", "86", "87", "89", "94", "95"};
    private static final ArrayList<String> arrayList = new ArrayList<>();
    private static final HashSet<String> hashSet = new HashSet<>();
    private static final TreeSet<String> treeSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        System.out.print("Сколько номеров сгенерировать? ");
        long n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("\\D", ""));
        numGenerator(n);

        System.out.print("Какой номер искать? ");
        String number = new BufferedReader(new InputStreamReader(System.in)).readLine();

        directSearch(number);
        binarySearchArrayList(number);
        hashSetSearch(number);
        treeSetSearch(number);
    }

    private static void numGenerator(long n) {
        for (int i = 0; i < n; i++) {
            String X = XYZ[(int) (Math.random() * XYZ.length)];
            int N = (int) (Math.random() * 9 + 1);
            String Y = XYZ[(int) (Math.random() * XYZ.length)];
            String Z = XYZ[(int) (Math.random() * XYZ.length)];
            String R = REGION_LIST[(int) (Math.random() * REGION_LIST.length)];

            String XNNNYZR = X + N + N + N + Y + Z + R;

            arrayList.add(XNNNYZR);
            hashSet.add(XNNNYZR);
            treeSet.add(XNNNYZR);
        }
    }

    private static void search(double nanoTime, boolean contains) {
        if (contains) {
            System.out.print("найден, ");
        } else {
            System.out.print("не найден, ");
        }
        nanoTime = System.nanoTime() - nanoTime;

        System.out.println("поиск занял " + (long) nanoTime + "нс или " + nanoTime/1000000 + "мс");
    }

    private static void directSearch(String number) {
        double nanoTime = System.nanoTime();

        System.out.print("Поиск перебором: номер ");
        search(nanoTime, arrayList.contains(number));
    }

    private static void binarySearchArrayList(String number) {
        Collections.sort(arrayList);

        double nanoTime = System.nanoTime();
        int index = Collections.binarySearch(arrayList, number);

        System.out.print("Бинарный поиск: номер ");
        if (index >= 0) {
            System.out.print("найден, ");
        } else {
            System.out.print("не найден, ");
        }
        nanoTime = System.nanoTime() - nanoTime;
        System.out.println("поиск занял " + (long) (nanoTime) + "нс или " + nanoTime/1000000 + "мс");
    }

    private static void hashSetSearch(String number) {
        double nanoTime = System.nanoTime();

        System.out.print("Поиск в HashSet: номер ");
        search(nanoTime, hashSet.contains(number));
    }

    private static void treeSetSearch(String number) {
        double nanoTime = System.nanoTime();

        System.out.print("Поиск в TreeSet: номер ");
        search(nanoTime, treeSet.contains(number));
    }
}
