import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Icecream> icecreams = new ArrayList<>();
        icecreams.add(new Icecream("Vanilla", false, 5.0));
        icecreams.add(new Icecream("Chocolate", true, 8.0));
        icecreams.add(new Icecream("Strawberry", false, 4.5));
        icecreams.add(new Icecream("Mint", false, 6.0));
        icecreams.add(new Icecream("Cookies and Cream", true, 7.5));
        icecreams.add(new Icecream("Coffee", false, 6.5));

        IcecreamSerializer.serializeIcecreams(icecreams, "icecreams.ser");

        List<Icecream> deserializedIcecreams = IcecreamDeserializer.deserializeIcecreams("icecreams.ser");
        if (deserializedIcecreams != null) {
            for (Icecream icecream : deserializedIcecreams) {
                System.out.println(icecream.getName() + " - Fat Percentage: " + icecream.getFatPercentage());
            }
        }
    }
}