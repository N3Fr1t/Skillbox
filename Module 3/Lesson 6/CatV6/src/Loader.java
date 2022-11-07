public class Loader {
    public static void main(String[] args) {
        Cat boris = getKitten(1100.0);

        boris.setColor(Color.GRAY);
        System.out.println("Цвет кота Бориса: " + boris.getColor());
    }

    public static Cat getKitten(double weight) {
        return new Cat(weight);
    }
}