import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private Map<Integer, Product> products = new HashMap<>();

    // Add a product
    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException(
                "Product ID already exists."
            );
        }

        products.put(product.getProductId(), product);
        System.out.println("Product added successfully.");
    }

    // Search product by ID
    public Product searchProduct(int productId) {
        Product product = products.get(productId);

        if (product == null) {
            throw new IllegalArgumentException(
                "Product not found with ID: " + productId
            );
        }

        return product;
    }

    // Update product price
    public void updatePrice(int productId, double newPrice) {
        Product product = searchProduct(productId);
        product.updatePrice(newPrice);

        System.out.println("Price updated successfully.");
    }

    // Add stock
    public void addStock(int productId, int quantity) {
        Product product = searchProduct(productId);
        product.addStock(quantity);

        System.out.println("Stock added successfully.");
    }

    // Sell product and calculate bill
    public void sellProduct(int productId, int quantity, Bill bill) {
        Product product = searchProduct(productId);

        // Check stock and update quantity
        product.sellProduct(quantity);

        // Add the purchased item to the bill
        bill.addItem(
            product.getProductName(),
            product.getPrice(),
            quantity
        );

        System.out.println("Product sold successfully.");
    }

    // Display all products
    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n========== ALL PRODUCTS ==========");

        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    // Display products with stock below 5
    public void showLowStockProducts() {
        boolean found = false;

        System.out.println("\n======= LOW STOCK PRODUCTS =======");

        for (Product product : products.values()) {
            if (product.getStock() < 5) {
                System.out.println(product);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No low-stock products.");
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        Product removed = products.remove(productId);

        if (removed == null) {
            throw new IllegalArgumentException(
                "Product not found with ID: " + productId
            );
        }

        System.out.println("Product deleted successfully.");
    }
}
