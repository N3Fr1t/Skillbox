public class Main {
    public static void main(String[] args) {
        int vasyaAge = 32;
        int katyaAge = 14;
        int mishaAge = 40;

        int min = Math.min(Math.min(vasyaAge, katyaAge), mishaAge);
        int max = Math.max(Math.max(vasyaAge, katyaAge), mishaAge);
        int middle = vasyaAge + katyaAge + mishaAge - (min + max);

        System.out.println("Minimal age: " + min);
        System.out.println("Middle age: " + middle);
        System.out.println("Max age: " + max);
    }
}
