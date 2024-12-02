package sensors;

public class UltrasonicSensor implements ParkingSensor {
    // TODO: enum or constant?
    private static int DISTANCE_THRESHOLD;

    public UltrasonicSensor() {
        System.out.println("Initializing the UltrasonicSensor");
        System.out.println("1. Pin configurations.");
        System.out.println("2. Operating Mode.");
        System.out.println("3. Taking into account the current environment.");
        System.out.println("Sensor Initialized!");
        setup();
    }

    // TODO
    private void setup() {
        System.out.println("Configuring the UltrasonicSensor");
        System.out.println("1. Communication Protocols.");
        System.out.println("2. Calibrating");
        System.out.println("Sensor is Setup!");
    }

    // TODO
    public boolean detectVehicle() {
        return Math.random() < 0.5;
    }

    // TODO
    public String getParkingStatus() {
        return detectVehicle() ? "Occupied" : "Vacant";
    }

    // TODO
    private int measureDistance() {
        return 0;
    }

    // TODO
    private int getDistanceThreshold() {
        return DISTANCE_THRESHOLD;
    }

    // TODO
    public boolean isOccupied() {
        return false;
    }

    // TODO
    public boolean isVacant() {
        return false;
    }

    // TODO
    public void getSensorInfo() {

    }

    // TODO
    private void reset() {

    }

    // TODO
    private void enableInterrupt() {

    }

    // TODO
    private void powerOn() {

    }

    // TODO
    private void powerOff() {

    }
}