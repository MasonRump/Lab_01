import java.util.Calendar;
import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private final String id;
    private String title;
    private int yearOfBirth;


    // Constructor
    public Person(String id, String firstName, String lastName, String title, int yearOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName; }
    public String getLastName() {
        return lastName; }
    public String getID() {
        return id; }
    public String getTitle() {
        return title; }
    public int getYearOfBirth() {
        return yearOfBirth; }


    public void setFirstName(String firstName) {
        this.firstName = firstName; }
    public void setLastName(String lastName) {
        this.lastName = lastName; }
    public void setTitle(String title) {
        this.title = title; }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth >= 1000 && yearOfBirth <= 9999) {
        this.yearOfBirth = yearOfBirth;
        } else {
            throw new IllegalArgumentException("Year of birth must be between 1000 and 9999."); }
    }

    //Methods

    public String fullName() {
        return firstName + " " + lastName; }

    public String formalName() {
        return title + " " + fullName(); }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - yearOfBirth; }

    public int getAge(int year) {
        return year - yearOfBirth; }

    public String toCSV() {
        return String.format("%s,%s,%s,%s,%d", id, firstName, lastName, title, yearOfBirth); }

    public String toJSON() {
        return String.format("{\"id\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"yearOfBirth\":%d}",
                id, firstName, lastName, title, yearOfBirth); }

    public String toXML() {
        return String.format("<Person><ID>%s</ID><FirstName>%s</FirstName><LastName>%s</LastName><Title>%s</Title><YearOfBirth>%d</YearOfBirth></Person>",
                id, firstName, lastName, title, yearOfBirth); }

    @Override
    public String toString() {
        return formalName() + " (" + id + ")"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); }

}
