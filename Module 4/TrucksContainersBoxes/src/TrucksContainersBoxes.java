public class TrucksContainersBoxes {
    private int boxes;
    private int truckCount;
    private int containerCount;
    private int boxCount;

    public TrucksContainersBoxes() {
    }

    public TrucksContainersBoxes(int boxes) {
        this.boxes = boxes;
    }

    public void setBoxes(int boxes) {
        this.boxes = boxes;
    }

    public void printResult() {
        for (int i = 0; i < boxes; i++) {
            if (boxCount % 27 == 0) {
                if (containerCount % 12 == 0) {
                    truckCount++;
                    System.out.println("Грузовик " + truckCount);
                }
                containerCount++;
                System.out.println("\tКонтейнер " + containerCount);
            }
            boxCount++;
            System.out.println("\t\tЯщик " + boxCount);
        }
        printNecessary();
    }

    public void printNecessary() {
        System.out.println("-----------------------");
        System.out.println("Необходимо:\nгрузовиков - " + truckCount + " шт." + "\nконтейнеров - " + containerCount + " шт.");
    }
}