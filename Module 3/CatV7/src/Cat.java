public class Cat {
    private double originWeight;
    private double weight;
    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    private String name;
    private double foodAmount;
    private static int count;
    private static final int EYES_COUNT = 2;
    private Color color;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
    }

    public Cat(String name, double weight) {
        this.name = name;
        this.weight = weight;
        originWeight = weight;
        count++;
    }

    public Cat(Cat cat) {
        name = cat.getName();
        weight = cat.getWeight();
        originWeight  = cat.getOriginWeight();
        color = cat.getColor();
        foodAmount = cat.getFoodAmount();
        count++;
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

    public double getOriginWeight() {
        return originWeight;
    }

    public void setOriginWeight(double originWeight) {
        this.originWeight = originWeight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void setCopy(Cat cat) {
        this.name = cat.getName();
        this.weight = cat.getWeight();
        this.originWeight = cat.getOriginWeight();
        setColor(cat.getColor());
        this.foodAmount = cat.getFoodAmount();
    }
}