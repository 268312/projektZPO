import org.junit.jupiter.api.Test;
import projekt.Patient;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void testGetters() {
        Patient patient = new Patient("John", "Doe", 25, Patient.Gender.MALE);

        assertEquals("John", patient.getName());
        assertEquals("Doe", patient.getSurname());
        assertEquals(25, patient.getAge());
        assertEquals(Patient.Gender.MALE, patient.getGender());
        assertNull(patient.getPregnantStatus());
    }

    @Test
    void testGettersWithPregnantStatus() {
        Patient patient = new Patient("Jane", "Doe", 30, Patient.Gender.FEMALE, Patient.PregnantStatus.YES);

        assertEquals("Jane", patient.getName());
        assertEquals("Doe", patient.getSurname());
        assertEquals(30, patient.getAge());
        assertEquals(Patient.Gender.FEMALE, patient.getGender());
        assertEquals(Patient.PregnantStatus.YES, patient.getPregnantStatus());
    }

    @Test
    void testConstructorWithoutPregnantStatus() {
        Patient patient = new Patient("Bob", "Smith", 28, Patient.Gender.MALE);

        assertEquals("Bob", patient.getName());
        assertEquals("Smith", patient.getSurname());
        assertEquals(28, patient.getAge());
        assertEquals(Patient.Gender.MALE, patient.getGender());
        assertNull(patient.getPregnantStatus());
    }

    @Test
    void testConstructorWithPregnantStatus() {
        Patient patient = new Patient("Alice", "Johnson", 35, Patient.Gender.FEMALE, Patient.PregnantStatus.NO);

        assertEquals("Alice", patient.getName());
        assertEquals("Johnson", patient.getSurname());
        assertEquals(35, patient.getAge());
        assertEquals(Patient.Gender.FEMALE, patient.getGender());
        assertEquals(Patient.PregnantStatus.NO, patient.getPregnantStatus());
    }
}