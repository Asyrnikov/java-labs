public class InstantCoffee extends Coffee {
    public InstantCoffee(String sort, double weight, double price) {
        super(sort, weight, price);
    }

    @Override
    public String getState() {
        return "Растворимый";
    }
}