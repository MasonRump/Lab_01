import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class ProductReader {
    static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(System.getProperty("user.dir")));

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();
            ArrayList<Product> products = new ArrayList<>();
            ArrayList<String> lines = new ArrayList<>();

            try (InputStream in = new BufferedInputStream(Files.newInputStream(file));
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

                while (reader.ready()) {
                    lines.add(reader.readLine());
                }

                System.out.printf("%-8s %-15s %-30s %-10s%n", "ID#", "Name", "Description", "Cost");
                System.out.println("===============================================================");

                for(String line : lines) {
                    String[] f = line.split(",");
                    if(f.length == 4) {
                        Product p = new Product(
                                f[0].trim(),
                                f[1].trim(),
                                f[2].trim(),
                                Double.parseDouble(f[3].trim())
                        );
                        products.add(p);
                    } else {
                        System.out.println("Error record: " + line);
                    }}
                    for(Product p : products) {
                        System.out.printf("%-8s %-15s %-25s $%-10.2f%n", p.getId(), p.getName(), p.getDesc(), p.getCost());
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("No file selected");
        }
    }
}
