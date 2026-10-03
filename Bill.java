import java.util.LinkedHashMap;
import java.util.Map;

public class Bill {

    private Map<String, Double> items = new LinkedHashMap<>();
    private double total = 0.0;

    public void addItem(String productName, double price, int quantity) {
        double itemTotal = price * quantity;

        items.put(
            productName + " x " + quantity,
            itemTotal
        );

        total += itemTotal;
    }

    public double getTotal() {
        return total;
    }

    public void printBill() {
        System.out.println("\n========== CUSTOMER BILL ==========");

        for (Map.Entry<String, Double> entry : items.entrySet()) {
            System.out.printf(
                "%-25s Rs.%.2f%n",
                entry.getKey(),
                entry.getValue()
            );
        }

        System.out.println("-----------------------------------");
        System.out.printf("Total Amount: Rs.%.2f%n", total);
        System.out.println("===================================");
    }
}
