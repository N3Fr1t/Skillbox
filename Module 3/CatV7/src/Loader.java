public class Loader {
    public static void main(String[] args) {
        Cat boris = getKitten("Борис", 1100.0);
        boris.setColor(Color.GRAY);

        System.out.println("Имя кота Бориса: " + boris.getName());
        System.out.println("Цвет кота Бориса: " + boris.getColor());
        System.out.println("Вес кота Бориса: " + boris.getWeight());
        System.out.println("Изначальный вес Бориса: " + boris.getOriginWeight());

        System.out.println("==============================");

        Cat borisCopy = new Cat();
        borisCopy.setCopy(boris);

        System.out.println("Имя копии кота Бориса: " + borisCopy.getName());
        System.out.println("Цвет копии кота Бориса: " + borisCopy.getColor());
        System.out.println("Вес копии кота Бориса: " + borisCopy.getWeight());
        System.out.println("Изначальный вес копии кота Бориса: " + borisCopy.getOriginWeight());

        Cat borisCopyCopy = new Cat(borisCopy);

        System.out.println("==============================");

        System.out.println("Имя копии копии кота Бориса: " + borisCopyCopy.getName());
        System.out.println("Вес копии копии кота Бориса: " + borisCopyCopy.getWeight());
        System.out.println("Вес копии копии кота Бориса: " + borisCopy.getWeight());
        System.out.println("Изначальный вес копии копии кота Бориса: " + borisCopy.getOriginWeight());
    }

    public static Cat getKitten(String name, double weight) {
        return new Cat(name, weight);
    }
}