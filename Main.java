import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InventoryService service = new InventoryService();
        Bill bill = new Bill();

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product by ID");
            System.out.println("3. Update Product Price");
            System.out.println("4. Add Stock");
            System.out.println("5. Sell Product");
            System.out.println("6. Show All Products");
            System.out.println("7. Show Low Stock Products");
            System.out.println("8. Display Bill");
            System.out.println("9. Delete Product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {

                    case 1: {
                        System.out.print("Enter product ID: ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter product name: ");
                        String name = sc.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println("Product name cannot be empty.");
                            break;
                        }

                        System.out.println(
                            "Categories: LAPTOP, MOBILE, ACCESSORY, HOME_APPLIANCE"
                        );
                        System.out.print("Enter category: ");

                        Category category = Category.valueOf(
                            sc.nextLine().trim().toUpperCase()
                        );

                        System.out.print("Enter price: ");
                        double price = Double.parseDouble(sc.nextLine().trim());

                        System.out.print("Enter stock: ");
                        int stock = Integer.parseInt(sc.nextLine().trim());

                        Product product = new Product(
                            id, name, category, price, stock
                        );

                        service.addProduct(product);
                        break;
                    }

                    case 2: {
                        System.out.print("Enter product ID: ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        Product product = service.searchProduct(id);
                        System.out.println(product);
                        break;
                    }

                    case 3: {
                        System.out.print("Enter product ID: ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter new price: ");
                        double price = Double.parseDouble(sc.nextLine().trim());

                        service.updatePrice(id, price);
                        break;
                    }

                    case 4: {
                        System.out.print("Enter product ID: ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter quantity to add: ");
                        int quantity = Integer.parseInt(sc.nextLine().trim());

                        service.addStock(id, quantity);
                        break;
                    }

                    case 5: {
                        System.out.print("Enter product ID: ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter quantity to sell: ");
                        int quantity = Integer.parseInt(sc.nextLine().trim());

                        service.sellProduct(id, quantity, bill);
                        break;
                    }

                    case 6:
                        service.showAllProducts();
                        break;

                    case 7:
                        service.showLowStockProducts();
                        break;

                    case 8:
                        bill.printBill();
                        break;

                    case 9: {
                        System.out.print("Enter product ID to delete: ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        service.deleteProduct(id);
                        break;
                    }

                    case 0:
                        System.out.println("Exiting application...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid number. Please enter a valid numeric value."
                );

            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println(
                    "Unexpected error: " + e.getMessage()
                );
            }
        }

        sc.close();
    }
}
