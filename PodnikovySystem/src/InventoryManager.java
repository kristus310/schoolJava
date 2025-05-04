import java.util.*;

public class InventoryManager {
    private Map<Integer, InventoryItem> inventory = new HashMap<>();

    public void addItem(InventoryItem item) {
        inventory.put(item.getId(), item);
    }

    public void updateQuantity(int id, int quantity) {
        InventoryItem item = inventory.get(id);
        if (item != null) item.setQuantity(quantity);
    }

    public List<InventoryItem> getLowStockItems() {
        List<InventoryItem> lowStock = new ArrayList<>();
        for (InventoryItem item : inventory.values()) {
            if (item.isBelowMinimum()) lowStock.add(item);
        }
        return lowStock;
    }

    public boolean isAvailable(int id, int requiredQuantity) {
        InventoryItem item = inventory.get(id);
        return item != null && item.getQuantity() >= requiredQuantity;
    }

    public void reduceStock(int id, int amount) {
        InventoryItem item = inventory.get(id);
        if (item != null) item.setQuantity(item.getQuantity() - amount);
    }
}