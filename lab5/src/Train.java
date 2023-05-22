import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Train implements Comparable<Train>, Serializable {
    private String destination;
    private int trainNumber;
    private LocalTime departureTime;
    private int seatsCommon;
    private int seatsCoupe;
    private int seatsReserved;
    private int seatsLuxury;

    public Train(String destination, int trainNumber, LocalTime departureTime, int seatsCommon, int seatsCoupe, int seatsReserved, int seatsLuxury) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.seatsCommon = seatsCommon;
        this.seatsCoupe = seatsCoupe;
        this.seatsReserved = seatsReserved;
        this.seatsLuxury = seatsLuxury;
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public int getSeatsCommon() {
        return seatsCommon;
    }

    public int getSeatsCoupe() {
        return seatsCoupe;
    }

    public int getSeatsReserved() {
        return seatsReserved;
    }

    public int getSeatsLuxury() {
        return seatsLuxury;
    }

    @Override
    public String toString() {
        return "Пункт назначения: " + destination +
                " | Номер поезда: " + trainNumber +
                " | Время отправления: " + departureTime +
                " | Места (Общие/Купе/Плацкарт/Люкс): " +
                seatsCommon + "/" + seatsCoupe + "/" +
                seatsReserved + "/" + seatsLuxury;
    }

    @Override
    public int compareTo(Train otherTrain) {
        return Integer.compare(this.trainNumber, otherTrain.trainNumber);
    }

    public static List<Train> filterByDestination(List<Train> trainList, String destination) {
        List<Train> filteredTrains = new ArrayList<>();
        for (Train train : trainList) {
            if (train.getDestination().equalsIgnoreCase(destination)) {
                filteredTrains.add(train);
            }
        }
        return filteredTrains;
    }

    public static List<Train> filterByDestinationAndTime(List<Train> trainList, String destination, LocalTime time) {
        List<Train> filteredTrains = new ArrayList<>();
        for (Train train : trainList) {
            if (train.getDestination().equalsIgnoreCase(destination) && train.getDepartureTime().isAfter(time)) {
                filteredTrains.add(train);
            }
        }
        return filteredTrains;
    }

    public static List<Train> filterByDestinationAndSeatsCommon(List<Train> trainList, String destination) {
        List<Train> filteredTrains = new ArrayList<>();
        for (Train train : trainList) {
            if (train.getDestination().equalsIgnoreCase(destination) && train.getSeatsCommon() > 0) {
                filteredTrains.add(train);
            }
        }
        return filteredTrains;
    }
}
