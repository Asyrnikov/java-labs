import java.util.Arrays;
import java.util.Comparator;

public class App {
    static Icecream[] icecreams = new Icecream[10];
    static int countOfIcecreamWithChocolate;
    static int averageOfFatPercentage = 0;
    public static void main(String[] args) throws Exception {
        icecreams[0] = new Icecream("plombir", false, 30);
        icecreams[1] = null;
        icecreams[2] = new Icecream();
        icecreams[3] = new Icecream("eskimo", true, 20);
        icecreams[4] = new Icecream("polus", true,40);
        icecreams[5] = new Icecream("yattis", false, 35);
        icecreams[6] = new Icecream("alenka", true, 45);
        icecreams[7] = new Icecream("korovka", true, 33);
        icecreams[8] = new Icecream("top", false, 15);
        icecreams[9] = new Icecream("kapriz", false, 27);
        for(int i = 0; i <= icecreams.length - 1; i++) {
            if (icecreams[i] != null && icecreams[i].name != "default") {
                averageOfFatPercentage = averageOfFatPercentage + icecreams[i].fatPercentage;
                if (icecreams[i].availabilityOfChocolate == true) {
                    countOfIcecreamWithChocolate++;
                }
            }
        }
        Arrays.sort(icecreams, Comparator.nullsLast(Icecream.fatPercentagecComparator));
        for(int i = 0; i <= icecreams.length - 1; i++) {
            if (i == 0) {
                System.out.println("________________________\n");
            }
            if (icecreams[i] != null) {
                System.out.println(icecreams[i].name + " | " + icecreams[i].availabilityOfChocolate + " | " + icecreams[i].fatPercentage);
            }
            if (i == 9) {
                System.out.println("_________________________\n");
            }
        }
        System.out.println("Средний процент сливок: " + averageOfFatPercentage/icecreams.length + "%");
        System.out.println("Количество мороженного c шоколадной глазурью: " + countOfIcecreamWithChocolate + "шт.");
    }
}

class Icecream implements Comparable <Icecream> {
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
    public static Comparator<Icecream> fatPercentagecComparator = new Comparator<Icecream>() {
        @Override
        public int compare(Icecream o1, Icecream o2) {
            return o1.fatPercentage- o2.fatPercentage;
    
        }
    };
    @Override
    public int compareTo(Icecream o) {
        return (this.fatPercentage - o.fatPercentage);
    }
}