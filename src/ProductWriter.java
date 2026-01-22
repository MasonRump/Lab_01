import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        boolean more = true;

        while (more) {
            String id = SafeInput.getRegExString(sc, "Enter 6 Digit Product ID", "\\d{6}");
            String name = SafeInput.getNonZeroLenString(sc, "Enter Product Name");
            String desc = SafeInput.getNonZeroLenString(sc, "Enter Product Description");
            double cost = SafeInput.getDouble(sc, "Enter Product Cost");

            Product p = new Product(id, name, desc, cost);
            products.add(p);

            more = SafeInput.getYNConfirm(sc, "Do you want to add another product?");
        }

        String filename = SafeInput.getNonZeroLenString(sc, "Enter output filename");
        Path file = Path.of(filename);

        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(Files.newOutputStream(file))))) {
            for (Product p : products) {
                writer.write(p.toCSV());
                writer.newLine();
            }
            System.out.println("Product data saved to " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
