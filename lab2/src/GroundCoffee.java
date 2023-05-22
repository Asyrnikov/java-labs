public class GroundCoffee extends Coffee {
    public GroundCoffee(String sort, double weight, double price) {
        super(sort, weight, price);
    }

    @Override
    public String getState() {
        return "Гранулированный";
    }
}
