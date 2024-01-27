package projekt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file path
        String filePath = "patient_data.csv";
        try {

            // Check if the file exists
            boolean fileExists = new File(filePath).exists();

            // Pobieranie danych od użytkownika
            System.out.println("Podaj imię pacjenta:");
            String name = scanner.nextLine();
            if (name.isEmpty() || name.matches(".*\\d.*")){
                System.out.println("Podaj prawidłowe imię pacjenta: ");
                name = scanner.nextLine();
            }
            System.out.println("Podaj nazwisko pacjenta:");
            String surname = scanner.nextLine();
            if (surname.isEmpty() || surname.matches(".*\\d.*")){
                System.out.println("Podaj prawidłowe nazwisko pacjenta: ");
                surname = scanner.nextLine();
            }

            System.out.println("Podaj wiek pacjenta:");
            int age;
            try {
                age = scanner.nextInt();
                scanner.nextLine(); // Odczyt zbędnej nowej linii
            } catch  (InputMismatchException e){
                throw new IllegalArgumentException("Wiek powinien być liczbą całkowitą.");
            }

            System.out.println("Podaj płeć pacjenta (FEMALE/MALE):");
            String genderInput = scanner.nextLine();
            Patient.Gender gender = "FEMALE".equalsIgnoreCase(genderInput) ? Patient.Gender.FEMALE : Patient.Gender.MALE;

            Patient.PregnantStatus pregnantStatus = Patient.PregnantStatus.NO;

            if (gender == Patient.Gender.FEMALE) {
                System.out.println("Czy pacjentka jest w ciąży? (YES/NO):");
                String pregnantStatusInput = scanner.nextLine();
                pregnantStatus = Patient.PregnantStatus.valueOf(pregnantStatusInput.toUpperCase());
            }

            System.out.println("Podaj ciśnienie skurczowe pacjenta:");
            double systolicPressure = scanner.nextDouble();

            System.out.println("Podaj ciśnienie rozkurczowe pacjenta:");
            double diastolicPressure = scanner.nextDouble();

            System.out.println("Podaj puls pacjenta:");
            double pulse = scanner.nextDouble();

            System.out.println("Podaj temperaturę pacjenta:");
            double temperature = scanner.nextDouble();

            // Zamykanie skanera
            scanner.close();

            // Tworzenie obiektu Parametry
            Parameters parameters = new Parameters(name, surname, age, gender);
            parameters.setSystolicPressure(systolicPressure);
            parameters.setDiastolicPressure(diastolicPressure);
            parameters.setPulse(pulse);
            parameters.setTemperature(temperature);
            // Zapisywanie danych do pliku CSV
            writeToCsv(filePath, name, surname, age, String.valueOf(gender), pregnantStatus, systolicPressure, diastolicPressure, pulse, temperature, fileExists);
        } catch (Exception e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }
    }

    private static void writeToCsv(String filePath, String name, String surname, int age, String sex,
                                   Patient.PregnantStatus pregnantStatus, double systolicPressure,
                                   double diastolicPressure, double pulse, double temperature, boolean append) {
        try (FileWriter writer = new FileWriter(filePath, append)) {
            if (!append) {
                // Dodanie nagłówków do nowego pliku
                writer.append("Name,Surname,Age,Gender,PregnantStatus,SystolicPressure,DiastolicPressure,Pulse,Temperature\n");
            }

            // Dodanie danych pacjenta do pliku CSV
            writer.append(name).append(",")
                    .append(surname).append(",")
                    .append(String.valueOf(age)).append(",")
                    .append(sex).append(",")
                    .append(pregnantStatus.name()).append(",")
                    .append(String.valueOf(systolicPressure)).append(",")
                    .append(String.valueOf(diastolicPressure)).append(",")
                    .append(String.valueOf(pulse)).append(",")
                    .append(String.valueOf(temperature)).append("\n");

            System.out.println("Dane zapisane do pliku " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
