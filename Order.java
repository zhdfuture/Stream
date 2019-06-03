package Price;

public class Order {
        private String title;
        private double price;
        private int amount;

        public Order(String title, double price, int amount) {
            this.title = title;
            this.price = price;
            this.amount = amount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }


