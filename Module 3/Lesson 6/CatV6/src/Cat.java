public class Cat {
    private double originWeight;
    private double weight;
    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    private double foodAmount;
    private static int count;
    private static final int EYES_COUNT = 2;
    private Color color;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
        originWeight = weight;
    }

    public void meow() {
        if (isAlive()) {
            weight = weight - 1;
            System.out.println("Meow");
        } else {
            System.out.println("Питомец мертв");
        }
    }

    public void feed(Double amount) {
        if (isAlive()) {
            foodAmount += amount;
            weight = weight + amount;
        } else {
            System.out.println("Питомец мертв");
        }
    }

    public void drink(Double amount) {
        if (isAlive()) {
            weight = weight + amount;
        } else {
            System.out.println("Питомец мертв");
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            count--;
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
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
        if (isAlive()) {
            weight--;
            System.out.println("Питомец совершил грязные делишки. Пора за ним убирать");
        } else {
            System.out.println("Питомец мертв");
        }
    }

    public static int getCount() {
        return count;
    }

    public boolean isAlive() {
        return !(weight < MIN_WEIGHT || weight > MAX_WEIGHT);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}