public class WholeBeanCoffee extends Coffee {
    public WholeBeanCoffee(String sort, double weight, double price) {
        super(sort, weight, price);
    }

    @Override
    public String getState() {
        return "Зерновой";
    }
}