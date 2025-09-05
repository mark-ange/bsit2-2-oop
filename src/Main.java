import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("Alice");
        Order order2 = new Order("Bob");
        Order order3 = new Order("Charlie");

        try {
            order1.addItem("Pizza", 12.99);
            order2.addItem("Burger", 8.50);
            order2.addItem("Fries", 3.25);
            order3.addMultipleItems(new String[]{"Pizza", "Pasta"}, 15.99, 10.99);
            order3.addMultipleItems(new String[]{"Burger", "Fries"}, 8.50, 3.25);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order1.addItem("Pizza", -5.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order2.addItem("", 5.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order3.addMultipleItems(new String[]{"Pizza", "Pasta"}, 5.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(order1.displayOrder());
        System.out.println(order2.displayOrder());
        System.out.println(order3.displayOrder());

        System.out.println("Total orders created: " + Order.getTotalOrders());

        Order highestOrder = order1;
        if (order2.getTotalAmount() > highestOrder.getTotalAmount()) {
            highestOrder = order2;
        }
        if (order3.getTotalAmount() > highestOrder.getTotalAmount()) {
            highestOrder = order3;
        }
        System.out.println("Order with the highest total: " + highestOrder.displayOrder());
    }

    static class Order {
        private String customerName;
        private ArrayList<String> items;
        private ArrayList<Double> prices;
        private static int totalOrders = 0;

        public Order(String customerName) {
            this.customerName = customerName;
            this.items = new ArrayList<>();
            this.prices = new ArrayList<>();
            totalOrders++;
        }

        public void addItem(String item, double price) throws IllegalArgumentException {
            if (price <= 0) {
                throw new IllegalArgumentException("Invalid price: must be greater than 0");
            }
            if (item == null || item.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid item: cannot be empty");
            }
            items.add(item);
            prices.add(price);
        }

        public double getTotalAmount() {
            double totalAmount = 0.0;
            for (double price : prices) {
                totalAmount += price;
            }
            return totalAmount;
        }

        public String getOrderSize() {
            if (items.isEmpty()) {
                return "Empty order";
            }
            int itemCount = items.size();
            if (itemCount >= 7) {
                return "Large";
            } else if (itemCount >= 4) {
                return "Medium";
            } else {
                return "Small";
            }
        }

        public void addMultipleItems(String[] items, double... prices) throws IllegalArgumentException {
            if (items.length != prices.length) {
                throw new IllegalArgumentException("Items and prices count mismatch");
            }
            try {
                for (int i = 0; i < items.length; i++) {
                    addItem(items[i], prices[i]);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error while adding multiple items: " + e.getMessage());
            }
        }

        public static int getTotalOrders() {
            return totalOrders;
        }

        public String getCustomerName() {
            return customerName;
        }

        public int getItemCount() {
            return items.size();
        }

        public String displayOrder() {
            return "Order for " + customerName + ": " + getItemCount() + " items, Total: $" + getTotalAmount() + ", Size: " + getOrderSize();
        }
    }
}
