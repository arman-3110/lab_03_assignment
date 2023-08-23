import java.util.ArrayList;
import java.util.Scanner;

class Flight {
    String flightId;   
    String source;
    String destination;
    int price;

    public Flight(String flightId, String source, String destination, int price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }
}     

class FlightTable {
    ArrayList<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public ArrayList<Flight> searchByCity(String city) {
        ArrayList<Flight> result = new ArrayList<>(); 
        for (Flight flight : flights) {
            if (flight.source.equals(city) || flight.destination.equals(city)) {
                result.add(flight);
            }
        }
        return result;
    }

    public ArrayList<Flight> searchBySource(String source) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.source.equals(source)) {
                result.add(flight);
            }
        }
        return result;
    }

    public ArrayList<Flight> searchBetweenCities(String source, String destination) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.source.equals(source) && flight.destination.equals(destination)) {
                result.add(flight);
            }
        }
        return result;
    }
}  

public class java_assignment_1 {
    public static void main(String[] args) {
        FlightTable flightTable = new FlightTable();

        String[][] flightData = {
            {"AI161E90", "BLR", "BOM", "5600"},
            {"BR161F91", "BOM", "BBI", "6750"},
            {"AI161F99", "BBI", "BLR", "8210"},
            {"VS171E20", "JLR", "BBI", "5500"},
            {"AS171G30", "HYD", "JLR", "4400"},
            {"AI131F49", "HYD", "BOM", "3499"}
        };

        for (String[] data : flightData) {
            Flight flight = new Flight(data[0], data[1], data[2], Integer.parseInt(data[3]));
            flightTable.addFlight(flight);
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSearch Options:");
            System.out.println("1. Flights for a particular City");
            System.out.println("2. Flights From a city");
            System.out.println("3. Flights between two given cities");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter the city: ");
                String city = scanner.next();
                ArrayList<Flight> result = flightTable.searchByCity(city);
                printSearchResults(result);
            } else if (choice == 2) {
                System.out.print("Enter the source city: ");
                String source = scanner.next();
                ArrayList<Flight> result = flightTable.searchBySource(source);
                printSearchResults(result);
            } else if (choice == 3) {
                System.out.print("Enter the source city: ");
                String source = scanner.next();
                System.out.print("Enter the destination city: ");
                String destination = scanner.next();
                ArrayList<Flight> result = flightTable.searchBetweenCities(source, destination);
                printSearchResults(result);
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void printSearchResults(ArrayList<Flight> result) {
        if (!result.isEmpty()) {
            System.out.println("\nSearch Results:");
            for (Flight flight : result) {
                System.out.println("Flight Id: " + flight.flightId + ", From: " + flight.source +
                                   ", To: " + flight.destination + ", Price: " + flight.price);
            }
        } else {
            System.out.println("No flights found.");
        }
    }
}