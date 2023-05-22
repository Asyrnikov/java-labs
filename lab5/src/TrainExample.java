import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainExample {
    public static void main(String[] args) {
        // Создание списка объектов класса Train
        List<Train> trainList = new ArrayList<>();
        trainList.add(new Train("Гомель", 15, LocalTime.parse("16:00"), 14, 10, 3, 1));
        trainList.add(new Train("Минск", 10, LocalTime.parse("14:30"), 12, 8, 5, 2));
        trainList.add(new Train("Могилев", 7, LocalTime.parse("14:45"), 18, 6, 4, 0));

        // Запись объектов в файл
        writeTrainsToFile("trains.txt", trainList);

        // Чтение объектов из файла
        List<Train> readTrainList = readTrainsFromFile("trains.txt");

        Collections.sort(readTrainList);

        writeTrainsToFile("sorted_trains.txt", readTrainList);

        // Вывод информации об объектах
        for (Train train : readTrainList) {
            System.out.println(train.toString());
        }

        // Список поездов, следующих до заданного пункта назначения
        List<Train> trainsToDestination = Train.filterByDestination(trainList, "Минск");
        System.out.println("Список поездов, следующих до заданного пункта назначения:");
        for (Train train : trainsToDestination) {
            System.out.println(train.toString());
        }
        
        // Список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа
        LocalTime departureTime = LocalTime.parse("14:00");
        List<Train> trainsToDestinationAfterTime = Train.filterByDestinationAndTime(trainList, "Минск", departureTime);
        System.out.println("Список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа:");
        for (Train train : trainsToDestinationAfterTime) {
            System.out.println(train.toString());
        }

        // Список поездов, отправляющихся до заданного пункта назначения и имеющих общие места
        List<Train> trainsWithCommonSeats = Train.filterByDestinationAndSeatsCommon(trainList, "Минск");
        System.out.println("Список поездов, отправляющихся до заданного пункта назначения и имеющих общие места:");
        for (Train train : trainsWithCommonSeats) {
            System.out.println(train.toString());
        }
    }

    private static void writeTrainsToFile(String filename, List<Train> trainList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(trainList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Train> readTrainsFromFile(String filename) {
        List<Train> trainList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            trainList = (List<Train>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return trainList;
    }
}