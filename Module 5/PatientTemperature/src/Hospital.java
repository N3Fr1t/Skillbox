public class Hospital {
    private static final int NUMBER_OF_PATIENTS = 30;
    private static final float MIN_TEMPERATURE = 32.0f;
    private static final float MAX_TEMPERATURE = 40.0f;
    private final float[] arrOfPatients = new float[NUMBER_OF_PATIENTS];
    private int healthyPatients = 0;

    public Hospital() {
        for (int i = 0; i < NUMBER_OF_PATIENTS; i++) {
            arrOfPatients[i] = MIN_TEMPERATURE + (float) Math.random() * (MAX_TEMPERATURE - MIN_TEMPERATURE);
            if (36.2 < arrOfPatients[i] && arrOfPatients[i] < 36.9) {
                healthyPatients++;
            }
        }
    }

    public float averageTemperature () {
        float temperature = 0;
        for (float arrOfPatient : arrOfPatients) {
            temperature += arrOfPatient;
        }
        return temperature / NUMBER_OF_PATIENTS;
    }

    public int getHealthyPatients() {
        return healthyPatients;
    }

    public float[] getArrOfPatients() {
        return arrOfPatients;
    }
}
