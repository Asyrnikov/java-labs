import java.io.Serializable;

public class Icecream implements Serializable {
    private String name;
    private boolean hasChocolate;
    private double fatPercentage;

    public Icecream(String name, boolean hasChocolate, double fatPercentage) {
        this.name = name;
        this.hasChocolate = hasChocolate;
        this.fatPercentage = fatPercentage;
    }

    public String getName() {
        return name;
    }

    public boolean hasChocolate() {
        return hasChocolate;
    }

    public double getFatPercentage() {
        return fatPercentage;
    }
}