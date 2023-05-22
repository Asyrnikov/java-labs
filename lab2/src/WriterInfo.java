import java.util.List;

public class WriterInfo {
    public static void main(String[] args) {
        System.out.println("=== Кофе ===");
        Coffee coffee = new WholeBeanCoffee("Арабика", 250, 12.99);
        System.out.println(coffee.toString() + " (" + coffee.getState() + ")");

        System.out.println("=== Фургон кофе ===");
        CoffeeTruck truck = new CoffeeTruck(1000);
        truck.addCoffee(new WholeBeanCoffee("Арабика", 500, 24.99));
        truck.addCoffee(new GroundCoffee("Робуста", 300, 9.99));
        truck.addCoffee(new InstantCoffee("Бленд", 200, 14.99));
        truck.printCargo();

        System.out.println("Итоговый вес: " + truck.getTotalWeight() + "г.");
        System.out.println("Итоговая цена: руб." + truck.getTotalPrice());

        System.out.println("=== Сортированный фургон кофе ===");
        truck.sortByPriceToWeightRatio();
        truck.printCargo();

        System.out.println("=== Кофе соответствующий заданному диапазону параметров качества ===");
        List<Coffee> coffeeList = truck.findCoffeeByQualityRange(10, 20);
        for (Coffee c : coffeeList) {
            System.out.println(c.toString() + " (" + c.getState() + ")");
        }
    }
}