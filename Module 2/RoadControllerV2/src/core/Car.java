package core;

public class Car {
    public String number; //переменная типа String
    public int height; //переменная типа int
    public double weight; //переменная типа double
    public boolean hasVehicle; //переменная типа boolean
    public boolean isSpecial; //переменная типа boolean

    public String toString() {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}