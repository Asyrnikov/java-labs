public abstract class Coffee {
    protected String sort;
    protected double weight;
    protected double price;

    public Coffee(String sort, double weight, double price) {
        this.sort = sort;
        this.weight = weight;
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getState();

    @Override
    public String toString() {
        return "Сорт: " + sort + " | Вес: " + weight + "г. | Цена: руб." + price;
    }
}