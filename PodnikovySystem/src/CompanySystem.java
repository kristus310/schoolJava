public class CompanySystem {
    private static CompanySystem instance;
    private EmployeeManager employeeManager = new EmployeeManager();
    private InventoryManager inventoryManager = new InventoryManager();
    private OrderProcessing orderProcessing;

    private CompanySystem() {
        this.orderProcessing = new OrderProcessing(inventoryManager);
    }

    public static CompanySystem getInstance() {
        if (instance == null) {
            instance = new CompanySystem();
        }
        return instance;
    }

    public void run() {
        //test
        LoggerUtil.log("Systém spuštěn.");
    }

    public static void main(String[] args) {
        CompanySystem system = CompanySystem.getInstance();
        system.run();
    }
}
