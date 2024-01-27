package projekt;
public class Parameters extends Patient {
    private double systolicPressure;
    private double diastolicPressure;
    private double pulse;
    private double temperature;

    public Parameters(String name, String surname, int age, Gender gender) {
        super(name, surname, age, gender);
    }


    public double getSystolic_pressure() {
        return systolicPressure;
    }
    public double getDiastolic_pressure() {
        return diastolicPressure;
    }
    public double getPulse() {
        return pulse;
    }
    public double getTemperature() {
        return temperature;
    }
    public boolean isBloodPressureRight() {

        int age = getAge();
        String message = "Zaburzona wartość ciśnienia dla pacjenta " + getName() + " " + getSurname();

        // Definicja zakresów wartości ciśnienia w zależności od wieku
        int[][] pressureRanges = {
                {1, 75, 100, 50, 75},
                {5, 80, 110, 55, 79},
                {13, 90, 115, 60, 80},
                {19, 105, 120, 73, 81},
                {24, 108, 132, 75, 83},
                {29, 109, 133, 76, 84},
                {34, 110, 134, 77, 85},
                {39, 111, 135, 78, 86},
                {44, 112, 137, 79, 87},
                {49, 115, 139, 80, 88},
                {54, 116, 142, 81, 89},
                {59, 118, 144, 82, 90},
                {Integer.MAX_VALUE, 121, 147, 83, 91} // Dla wieku powyżej 59
        };

        for (int[] range : pressureRanges) {
            if (age <= range[0]) {
                if (!(systolicPressure >= range[1] && systolicPressure <= range[2]
                        && diastolicPressure >= range[3] && diastolicPressure <= range[4])) {
                    System.out.println(message);
                    return false;
                }
                break;
            }
        }
        return true;
    }


    public boolean isPulseRight() {
        // Kod sprawdzający puls
        double normalPulseMin = 60;
        double normalPulseMax = 100;

        if (!(pulse >= normalPulseMin && pulse <= normalPulseMax)) {
            System.out.println("Zaburzona wartość pulsu dla pacjenta " + getName() + " " + getSurname() );
        }
        return true;
    }

    public boolean isTemperatureRight() {
        // Kod sprawdzający temperaturę
        double normalTemperatureMin = 36.0;
        double normalTemperatureMax = 37.5;

        if (!(temperature >= normalTemperatureMin && temperature <= normalTemperatureMax)) {
            System.out.println("Zaburzona wartość temperatury dla pacjenta " + getName() + " " + getSurname());
        }
        return true;
    }
    public void setSystolicPressure(double systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public void setDiastolicPressure(double diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public void setPulse(double pulse) {
        this.pulse = pulse;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
