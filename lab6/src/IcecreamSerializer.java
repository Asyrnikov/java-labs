import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class IcecreamSerializer {
    public static void serializeIcecreams(List<Icecream> icecreams, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(icecreams);
            System.out.println("Icecreams serialized and saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while serializing icecreams: " + e.getMessage());
        }
    }
}