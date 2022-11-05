public class Cat {
    private double originWeight;
    private double weight;
    private double minWeight;
    private double maxWeight;
    private double foodAmount;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
    }

    public void meow() {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount) {
        foodAmount += amount;
        weight = weight + amount;
    }

    public void drink(Double amount) {
        weight = weight + amount;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
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
        weight--;
        System.out.println("Питомец совершил грязные делишки. Пора за ним убирать");
    }
}