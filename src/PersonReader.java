import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class PersonReader {
    static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(System.getProperty("user.dir")));

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();
            ArrayList<Person> people = new ArrayList<>();

            try (InputStream in = new BufferedInputStream(Files.newInputStream(file));
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] f = line.split(",");

                    if (f.length == 5) {
                        Person p = new Person(
                                f[0].trim(),   // ID
                                f[1].trim(),   // First name
                                f[2].trim(),   // Last name
                                f[3].trim(),   // Title
                                Integer.parseInt(f[4].trim()) // YOB
                        );
                        people.add(p);
                    } else {
                        System.out.println("Error record: " + line);
                    }
                }

                System.out.printf("%-8s %-15s %-15s %-6s %-5s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("==============================================================")
                ;


                for (Person p : people) {
                    System.out.printf("%-8s %-15s %-15s %-6s %-5d%n",
                            p.getID(),
                            p.getFirstName(),
                            p.getLastName(),
                            p.getTitle(),
                            p.getYearOfBirth());
                }

            } catch (Exception e)
                        { e.printStackTrace(); }

                } else {
            System.out.println("No file selected");

            }
        }
    }

