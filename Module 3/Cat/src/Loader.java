public class Loader
{
    public static void main(String[] args)
    {
        Cat seledka = new Cat();
        System.out.println("Вес кошки Cеледки: " + seledka.getWeight());

        Cat murka = new Cat();
        System.out.println("Вес кошки Мурки: " + murka.getWeight());

        Cat vaska = new Cat();
        System.out.println("Вес кота Васьки: " + vaska.getWeight());

        Cat pushok = new Cat();
        System.out.println("Вес кота Пушка: " + pushok.getWeight());

        Cat barsik = new Cat();
        System.out.println("Вес кота Барсика: " + barsik.getWeight());

        System.out.println("====================");

        seledka.feed(100.0);
        System.out.println("Кошка Селедка поела. Теперь её вес: " + seledka.getWeight());

        murka.feed(46.0);
        System.out.println("Кошка Мурка поела. Теперь её вес: " + murka.getWeight());

        System.out.println("====================");

        while (!barsik.getStatus().equals("Exploded")) {
            barsik.feed(1.0);
        }
        System.out.println("Статус Барсика: " + barsik.getStatus());

        while (!pushok.getStatus().equals("Dead")) {
            pushok.meow();
        }
        System.out.println("Статус Пушка: " + pushok.getStatus());
    }
}