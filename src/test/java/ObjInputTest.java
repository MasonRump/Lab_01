public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        String name = input.getNonZeroLenString("Enter your name");
        int age = input.getRangedInt("Enter your age", 1, 110);
        double salary = input.getRangedDouble("Enter your salary", 0, 200000.0);
        boolean cont = input.getYNConfirm("Do you want to continue?");
        String code = input.getRegExString("Enter a code (3 letters followed by 3 digits)", "^[A-Za-z]{3}\\d{3}$");

        System.out.println("\nYou entered:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Continue: " + cont);
        System.out.println("Code: " + code);

        input.close();
    }
}
