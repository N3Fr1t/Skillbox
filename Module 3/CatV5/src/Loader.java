public class Loader {
    public static void main(String[] args) {
        Cat boris = getKitten(1100.0);
        Cat seledka = getKitten(1100.0);
        Cat murka = getKitten(1100.0);

        System.out.println("Вес кота Бориса: " + boris.getWeight());
        System.out.println("Вес кошки Селедки: " + seledka.getWeight());
        System.out.println("Вес кошки Мурки: " + murka.getWeight());
    }

    public static Cat getKitten(double weight) {
        return new Cat(weight);
    }
}