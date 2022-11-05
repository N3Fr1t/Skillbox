public class Loader {
    public static void main(String[] args) {
        //Тестирую созданные методы: foodAmount() и pee()

        Cat boris = new Cat();
        System.out.println("Вес кота Бориса: " + boris.getWeight());

        boris.feed(150.0);

        System.out.println("Кот Борис вкусно поел, теперь его вес: " + boris.getWeight());

        boris.pee();
        boris.pee();
        boris.pee();
        boris.pee();
        boris.pee();

        System.out.println("Теперь вес Кота Бориса: " + boris.getWeight());
        System.out.println("Кот Борис съел: " + boris.getFoodAmount() + " еды");
    }
}