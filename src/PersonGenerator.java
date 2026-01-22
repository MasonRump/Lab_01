
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonGenerator {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        System.out.println("Person Generator");
        boolean more = true;

        while (more) {
            String id = SafeInput.getRegExString(sc, "Enter 6 Digit ID", "\\d{6}");
            String firstName = SafeInput.getNonZeroLenString(sc, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(sc, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(sc, "Enter Title (Mr, Ms, Dr, etc.)");
            int yearOfBirth = SafeInput.getInt(sc, "Enter Year of Birth");

            String record = String.format("%s,%s,%s,%s,%d", id, firstName, lastName, title, yearOfBirth);
            people.add(new Person(id, firstName, lastName, title, yearOfBirth));

            more = SafeInput.getYNConfirm(sc, "Do you want to add another person?");
        }

        String filename = SafeInput.getNonZeroLenString(sc, "Enter output filename");
        Path file = Path.of(filename);


        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(Files.newOutputStream(file))))) {
            for (Person person : people) {
                writer.write(person.toCSV());
                writer.newLine();

            }
            System.out.println("Person data saved to" + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
