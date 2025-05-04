import java.time.LocalDate;

public class Order {
    public enum Status { PRIJATA, PROBIHA, DOKONCENA }

    private int id;
    private String name;
    private String description;
    private Status status;
    private LocalDate receivedDate;
    private LocalDate deadline;

    public Order(int id, String name, String desc, Status status, LocalDate received, LocalDate deadline) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.status = status;
        this.receivedDate = received;
        this.deadline = deadline;
    }

    public boolean isActive() {
        return status != Status.DOKONCENA;
    }

    @Override
    public String toString() {
        return id + ": " + name + " (" + status + ")";
    }
}

