import parking.ParkingManager;
import parking.ParkingSpace;

import java.util.Scanner;

public class Testmain {
    public static void main(String[] args) {
        ParkingManager parkingManager = new ParkingManager(10);

        Scanner objscn = new Scanner(System.in);

        while (true) {
            // optimize parking before user is prompted everytime
            parkingManager.getParkingStrategy().optimizeParking();

            System.out.println("\nSmart Parking System");
            System.out.println("1. View Available Parking Spaces");
            System.out.println("2. Reserve a Parking Space");
            System.out.println("3. View Environment Data");
            System.out.println("4. View Reserved Vehicles");
            System.out.println("5. Perform Maintenance");
            System.out.println("6. Cancel Reservation");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = objscn.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Available Spaces:");
                    parkingManager.getAvailableSpaces().forEach(space -> System.out.println(space.getId()));
                    break;

                case 2: {
                    System.out.println("Enter your vehicle license plate: ");
                    String licensePlate = objscn.next();
                    System.out.println("Enter your vehicle type (e.g. car, motorcycle, truck): ");
                    String vehicleType = objscn.next();
                    parkingManager.reserveParkingSpace(licensePlate, vehicleType);
                    break;
                }
                case 3: {
                    parkingManager.getEnvironmentalInformation();
                    break;
                }
                case 4: {
                    parkingManager.getReservedVehicles();
                    break;
                }
                case 5: {
                    parkingManager.performMaintenance();
                    break;
                }
                case 6: {
                    System.out.println("Enter your vehicle license plate: ");
                    String licensePlate = objscn.next();
                    System.out.println("Enter your space number (e.g. 1, 2, 3): ");
                    String id = objscn.next();
                    String formattedId = "Space " + id;
                    ParkingSpace matchingSpace = parkingManager.getAllSpaces().stream().filter(
                            space -> space.getId().equals(formattedId)).findFirst().orElse(null);
                    if (matchingSpace == null) {
                        System.out.println("Invalid space number.");
                        break;
                    } else {
                        parkingManager.getReservationManager().cancelReservedVehicles(licensePlate, matchingSpace);
                    }

                    break;
                }
                case 7: {
                    System.out.println("Exiting...");
                    objscn.close();
                    return;
                }
                default: {
                    System.out.println("Invalid option.");
                }
            }
        }
    }
}
