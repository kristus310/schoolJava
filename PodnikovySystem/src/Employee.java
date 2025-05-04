public class Employee {
    private String firstName;
    private String lastName;
    private int id;
    private String position;
    private double salary;

    public Employee(String firstName, String lastName, int id, String position, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + " – " + position + " (" + salary + " Kč)";
    }
}
