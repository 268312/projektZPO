package projekt;

public class Patient {
    public enum Gender {
        MALE,
        FEMALE
    }
    public enum PregnantStatus {
        YES,
        NO
    }

    private String name;
    private String surname;
    private int age;
    private Gender gender;

    private PregnantStatus pregnantStatus;

    public Patient(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Patient(String name, String surname, int age, Gender gender, PregnantStatus pregnantStatus) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.pregnantStatus = pregnantStatus;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
    public PregnantStatus getPregnantStatus() {
        return pregnantStatus;
    }
}
