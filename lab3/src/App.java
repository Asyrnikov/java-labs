import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class App {
    static int countOfIcecreamWithChocolate;
    static int averageOfFatPercentage = 0;
    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Введите количество видов мороженного: (например: 5)");
            int size = input.nextInt();
            Icecream[] icecreams = new Icecream[size];
            for (int i = 0; i < size; i++) {
                icecreams[i] = new Icecream();
                System.out.println("Введите название мороженного: (например: plombir)");
                icecreams[i].name = input.next();
                System.out.println("Шоколадная глазурь имеется? (true/false)");
                icecreams[i].availabilityOfChocolate = input.nextBoolean();
                System.out.println("Введите процент сливок в мороженном: (например: 20)");
                icecreams[i].fatPercentage = input.nextInt();
                if (icecreams[i] != null && icecreams[i].name != "default") {
                    averageOfFatPercentage = averageOfFatPercentage + icecreams[i].fatPercentage;
                    if (icecreams[i].availabilityOfChocolate == true) {
                        countOfIcecreamWithChocolate++;
                    }
                }
            }
            System.out.println("Средний процент сливок: " + averageOfFatPercentage/size + "%");
            System.out.println("Количество мороженного c шоколадной глазурью: " + countOfIcecreamWithChocolate + " шт.");
            FileOutputStream outputStream = new FileOutputStream("C:\\java\\lab3\\files\\icecream.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            for (int i = 0; i < size; i++) {
                objectOutputStream.writeObject(icecreams[i]);
                objectOutputStream.flush();
            }
            objectOutputStream.close();
            System.out.println("Выполнить десериализацию? (true/false)");
            if (input.nextBoolean()) {
                FileInputStream fileInputStream = new FileInputStream("C:\\java\\lab3\\files\\icecream.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                for (int i = 0; i < size; i++) {
                    Icecream icecream = (Icecream) objectInputStream.readObject();
                    System.out.println(icecream.name + " | " + icecream.availabilityOfChocolate + " | " + icecream.fatPercentage);
                }
                objectInputStream.close();
            }
            input.close();
        }
    }
}

class Icecream implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    Boolean availabilityOfChocolate;
    int fatPercentage;
    Icecream() {
        this.name = "default";
        this.availabilityOfChocolate = false;
        this.fatPercentage = 0;
    }
    Icecream(String name, Boolean availabilityOfChocolate, int fatPercentage) {
        this.name = name;
        this.availabilityOfChocolate = availabilityOfChocolate;
        this.fatPercentage = fatPercentage;
    }
}
