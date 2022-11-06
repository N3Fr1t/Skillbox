public class Cat {
    private double originWeight;
    private double weight;
    private double minWeight;
    private double maxWeight;
    private double foodAmount;
    private static int count;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
    }

    public void meow() {
        if (catAlive()) {
            weight = weight - 1;
            System.out.println("Meow");
        } else {
            System.out.println("Питомец мертв");
        }
    }

    public void feed(Double amount) {
        if (catAlive()) {
            foodAmount += amount;
            weight = weight + amount;
        } else {
            System.out.println("Питомец мертв");
        }
    }

    public void drink(Double amount) {
        if (catAlive()) {
            weight = weight + amount;
        } else {
            System.out.println("Питомец мертв");
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < minWeight) {
            count--;
            return "Dead";
        } else if (weight > maxWeight) {
            count--;
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public double getFoodAmount() {
        return foodAmount;
    }

    public void pee() {
        if (catAlive()) {
            weight--;
            System.out.println("Питомец совершил грязные делишки. Пора за ним убирать");
        } else {
            System.out.println("Питомец мертв");
        }
    }

    public static int getCount() {
        return count;
    }

    public boolean catAlive() {
        return !(weight < minWeight || weight > maxWeight);
    }
}