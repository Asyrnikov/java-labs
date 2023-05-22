import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class IcecreamDeserializer {
    public static List<Icecream> deserializeIcecreams(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            List<Icecream> icecreams = (List<Icecream>) objectIn.readObject();
            System.out.println("Icecreams deserialized from " + fileName);
            return icecreams;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred while deserializing icecreams: " + e.getMessage());
            return null;
        }
    }
}