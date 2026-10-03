public class Product {
    private int productId;
    private String productName;
    private Category category;
    private double price;
    private int stock;

    public Product(int productId, String productName,
                   Category category, double price, int stock) {

        if (productId <= 0 || price < 0 || stock < 0) {
            throw new IllegalArgumentException(
                "ID must be positive; price and stock cannot be negative."
            );
        }

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void updatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(
                "Price cannot be negative."
            );
        }
        this.price = price;
    }

    public void addStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                "Quantity must be greater than zero."
            );
        }
        stock += quantity;
    }

    public void sellProduct(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                "Quantity must be greater than zero."
            );
        }

        if (stock == 0) {
            throw new IllegalStateException(
                productName + " is out of stock."
            );
        }

        if (quantity > stock) {
            throw new IllegalStateException(
                "Insufficient stock for " + productName
            );
        }

        stock -= quantity;
    }

    @Override
    public String toString() {
        return "ID: " + productId
            + " | Name: " + productName
            + " | Category: " + category
            + " | Price: Rs." + price
            + " | Stock: " + stock;
    }
}

