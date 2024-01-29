import org.junit.jupiter.api.Test;
import projekt.Parameters;
import projekt.Patient;

import static org.junit.jupiter.api.Assertions.*;

class ParametersTest {

    @Test
    void testGetters() {
        Parameters parameters = new Parameters("John", "Doe", 25, Patient.Gender.MALE);

        assertEquals("John", parameters.getName());
        assertEquals("Doe", parameters.getSurname());
        assertEquals(25, parameters.getAge());
        assertEquals(Patient.Gender.MALE, parameters.getGender());
        assertEquals(0.0, parameters.getSystolic_pressure());
        assertEquals(0.0, parameters.getDiastolic_pressure());
        assertEquals(0.0, parameters.getPulse());
        assertEquals(0.0, parameters.getTemperature());
    }

    @Test
    void testSetters() {
        Parameters parameters = new Parameters("Jane", "Doe", 30, Patient.Gender.FEMALE);

        parameters.setSystolicPressure(120.0);
        parameters.setDiastolicPressure(80.0);
        parameters.setPulse(75.0);
        parameters.setTemperature(36.7);

        assertEquals(120.0, parameters.getSystolic_pressure());
        assertEquals(80.0, parameters.getDiastolic_pressure());
        assertEquals(75.0, parameters.getPulse());
        assertEquals(36.7, parameters.getTemperature());
    }

    @Test
    void testBloodPressureInRange() {
        Parameters parameters = new Parameters("Alice", "Smith", 28, Patient.Gender.FEMALE);
        parameters.setSystolicPressure(110.0);
        parameters.setDiastolicPressure(80.0);

        assertTrue(parameters.isBloodPressureRight());
    }

    @Test
    void testBloodPressureOutOfRange() {
        Parameters parameters = new Parameters("Bob", "Johnson", 35, Patient.Gender.MALE);
        parameters.setSystolicPressure(140.0);
        parameters.setDiastolicPressure(85.0);

        assertFalse(parameters.isBloodPressureRight());
    }

    @Test
    void testPulseInRange() {
        Parameters parameters = new Parameters("Charlie", "Brown", 40, Patient.Gender.MALE);
        parameters.setPulse(80.0);

        assertTrue(parameters.isPulseRight());
    }

    @Test
    void testPulseOutOfRange() {
        Parameters parameters = new Parameters("Diana", "Williams", 50, Patient.Gender.FEMALE);
        parameters.setPulse(110.0);

        assertFalse(parameters.isPulseRight());
    }

    @Test
    void testTemperatureInRange() {
        Parameters parameters = new Parameters("Eva", "Miller", 22, Patient.Gender.FEMALE);
        parameters.setTemperature(36.9);

        assertTrue(parameters.isTemperatureRight());
    }

    @Test
    void testTemperatureOutOfRange() {
        Parameters parameters = new Parameters("Frank", "Davis", 60, Patient.Gender.MALE);
        parameters.setTemperature(37.6);

        assertFalse(parameters.isTemperatureRight());
    }
}