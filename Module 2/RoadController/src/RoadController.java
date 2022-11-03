import core.*;
import core.Camera;

import java.util.Scanner;

/*
* Программа на вход получает целое число с клавиатуры, которое записывается в переменную carsCount.
* Далее в цикле (который выполнится carsCount раз) создается объект car с типом Car,
* который генерируется методом getNextCar() класса Camera, который возвращает объект типа Car,
* в котором создается случайный номер, случайная высота и случайный вес.
* После чего создается сам объект car, которому задается:
* номер, высота, вес, наличие прицепа, и является ли он автомобилем спецтранспорта.
*
* Когда мы получаем автомобиль, и печатаем его, то срабатывает метод toString(), переопределенный в классе Car.
* Далее проверяется условие: является ли автомобиль спецтранспортом?
* Если да, то выполняется метод openWay(), и пропускается итерация.
*
* Далее создается целочисленная переменная price, в которую записывается возвращаемое методом calculatePrice() значение.
* В методе calculatePrice() проверяется, выше ли высота автомобиля, чем controllerMaxHeight?
* Если да, то выполняется метод blockWay(), который печатает причину невозможности проезда, и возвращается -1
* Далее проверяется условие: price == -1?
*
* Если высота автомобиля нормальная, то проверяем выше ли высота автомобиля, чем passengerCarMaxHeight
* Если высота автомобиля выше, создается переменная weight, в которую записывается масса транспортного средства
* Далее проверяется, выше ли масса транспортного средства, чем passengerCarMaxWeight
* Если выше, то price = passengerCarPrice. И, если, у транспортного средства имеется прицеп, то price += vehicleAdditionalPrice
* Если масса транспортного средства ниже, то price = cargoCarPrice
* Если высота автомобиля не выше, то price = passengerCarPrice
* Далее возвращается price
*
* Далее проверяется условие: price == -1?
* Если да, то пропускается итерация.
* Если price != 1, то результат выводится в консоль.
*/
public class RoadController {
    private static double passengerCarMaxWeight = 3500.0; // kg
    private static int passengerCarMaxHeight = 2000; // mm
    private static int controllerMaxHeight = 3500; // mm

    private static int passengerCarPrice = 100; // RUB
    private static int cargoCarPrice = 250; // RUB
    private static int vehicleAdditionalPrice = 200; // RUB

    public static void main(String[] args) {
        System.out.println("Сколько автомобилей сгенерировать?");

        Scanner scanner = new Scanner(System.in);
        int carsCount = scanner.nextInt();

        for (int i = 0; i < carsCount; i++) {
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car);
            if (price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car) {
        int carHeight = car.height;
        int price = 0;
        if (carHeight > controllerMaxHeight) {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        } else if (carHeight > passengerCarMaxHeight) {
            double weight = car.weight;
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight) {
                price = passengerCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = cargoCarPrice;
            }
        } else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) {
        System.out.println("Проезд невозможен: " + reason);
    }
}