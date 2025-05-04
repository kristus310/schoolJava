import java.util.*;

public class EmployeeManager {
    private Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee e) {
        employees.put(e.getId(), e);
    }

    public void editEmployee(int id, Employee updated) {
        if (employees.containsKey(id)) {
            employees.put(id, updated);
        }
    }

    public void removeEmployee(int id) {
        employees.remove(id);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public double getTotalSalaryCost() {
        return employees.values().stream().mapToDouble(Employee::getSalary).sum();
    }
}
