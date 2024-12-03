package sensors;

import java.util.Random;

public class UltrasonicSensor implements ParkingSensor {
    private static final int DISTANCE_THRESHOLD = 3;
    private static final String OCCUPIED = "Occupied";
    private static final String VACANT = "Vacant";
    private boolean isOn;

    public UltrasonicSensor() {
        this.isOn = true;
        setup();
    }

    private void setup() {
        System.out.println("-- Initializing the UltrasonicSensor");
        System.out.println("   1. Pin configurations.");
        System.out.println("   2. Operating Mode.");
        System.out.println("   3. Taking into account the current environment.");
        System.out.println("Sensor Initialized!");
        System.out.println();
        System.out.println("-- Configuring the UltrasonicSensor");
        System.out.println("   1. Communication Protocols.");
        System.out.println("   2. Calibrating");
        System.out.println("Sensor is Setup!");
    }

    public boolean detectVehicle() {
        Random random = new Random();
        return random.nextInt(15) < getDistanceThreshold();
    }

    public String getParkingStatus() {
        return detectVehicle() ? OCCUPIED : VACANT;
    }

    private int getDistanceThreshold() {
        return DISTANCE_THRESHOLD;
    }

    public boolean isOccupied() {
        return getParkingStatus().equals(OCCUPIED);
    }

    // TODO
    public boolean isVacant() {
        return getParkingStatus().equals(VACANT);
    }

    // TODO
    public void getSensorInfo() {

    }

    private void reset() {
        powerOff();
        powerOn();
        setup();
    }

    private void enableInterrupt() {
        reset();
    }

    private void powerOn() {
        this.isOn = true;
        System.out.println("Sensor is powered on");
    }

    private void powerOff() {
        this.isOn = false;
        System.out.println("Sensor is powered off");
    }
}