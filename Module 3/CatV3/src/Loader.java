public class Loader {
    public static void main(String[] args) {
        //Тестирую созданные методы: foodAmount() и pee()
        Cat boris = new Cat();
        Cat snezhok = new Cat();
        Cat seledka = new Cat();
        Cat persik = new Cat();

        System.out.println("Количество кошек: " + Cat.getCount());

        while (!boris.getStatus().equals("Exploded")) {
            boris.feed(1000.0);
        }

        boris.feed(1.0);
        boris.drink(1.0);
        boris.pee();
        boris.meow();

        System.out.println("Количество кошек: " + Cat.getCount());

        while (!snezhok.getStatus().equals("Dead")) {
            snezhok.meow();
        }

        snezhok.feed(1.0);
        snezhok.drink(1.0);
        snezhok.pee();
        snezhok.meow();

        System.out.println("Количество кошек: " + Cat.getCount());
    }
}