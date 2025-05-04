public class OrderProcessing {
    private InventoryManager inventory;

    public OrderProcessing(InventoryManager inventory) {
        this.inventory = inventory;
    }

    public void processOrder(int itemId, int quantity) {
        if (inventory.isAvailable(itemId, quantity)) {
            inventory.reduceStock(itemId, quantity);
            LoggerUtil.log("Objednávka vyřízena.");
        } else {
            LoggerUtil.warn("Nedostatek zásob pro položku ID: " + itemId);
        }
    }
}