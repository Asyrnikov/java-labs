import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeTruck {
    private List<Coffee> cargo;
    private double volume;
    private double totalWeight;
    private double totalPrice;

    public CoffeeTruck(double volume) {
        this.volume = volume;
        this.cargo = new ArrayList<>();
    }

    public void addCoffee(Coffee coffee) {
        double coffeeVolume = coffee.getWeight();
        if (totalWeight + coffeeVolume <= volume) {
            cargo.add(coffee);
            totalWeight += coffeeVolume;
            totalPrice += coffee.getPrice();
        } else {
            System.out.println("Нельзя добавить кофе, фургон полон.");
        }
    }

    public void sortByPriceToWeightRatio() {
        Collections.sort(cargo, (c1, c2) -> {
            double ratio1 = c1.getPrice() / c1.getWeight();
            double ratio2 = c2.getPrice() / c2.getWeight();
            return Double.compare(ratio1, ratio2);
        });
    }

    public List<Coffee> findCoffeeByQualityRange(double minPrice, double maxPrice) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : cargo) {
            double price = coffee.getPrice();
            if (price >= minPrice && price <= maxPrice) {
                result.add(coffee);
            }
        }
        return result;
    }

    public void printCargo() {
        for (Coffee coffee : cargo) {
            System.out.println(coffee.toString() + " (" + coffee.getState() + ")");
        }
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}