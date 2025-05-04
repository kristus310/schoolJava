public class InventoryItem {
    private int id;
    private String name;
    private int quantity;
    private int minRequired;

    public InventoryItem(int id, String name, int quantity, int minRequired) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.minRequired = minRequired;
    }

    public boolean isBelowMinimum() {
        return quantity < minRequired;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
