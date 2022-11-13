public class Main {
    public static void main(String[] args) {
        Hospital patient = new Hospital();

        System.out.print("Температуры пациентов: ");
        for (int i = 0; i < patient.getArrOfPatients().length; i++) {
            System.out.print(String.format("%.2f", patient.getArrOfPatients()[i]) + " ");
        }
        System.out.println();

        System.out.println("Средняя температура: " + String.format("%.2f", patient.averageTemperature()));
        System.out.println("Количество здоровых: " + patient.getHealthyPatients());
     }
}
