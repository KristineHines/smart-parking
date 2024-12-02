package sensors;

public class CameraSensor implements ParkingSensor {
    private boolean isOn = false;
    private boolean isOff = true;

    public CameraSensor() {
        System.out.println("Initializing the Camera Sensor");
        System.out.println("1. Resolution.");
        System.out.println("2. Framerate.");
        System.out.println("Sensor Initialized!");
//        setup();
    }

//    private void setup() {
//
//    }


    // TODO
    public boolean detectVehicle() {
        return true; // Simplified
    }

    // TODO
    public String getParkingStatus() {
        return "Processing Image - parking.Vehicle detected";
    }

    // TODO
    private void captureImage() {
        System.out.println("image captured");
    }

    // TODO
    private void processImage() {
        // TODO print license plates
        System.out.println("image processed");
    }

    // TODO
    public void getOccupancyStatus() {
        System.out.println("Occupancy Status");
    }

    // TODO
    private void setResolution(int width, int height) {
        System.out.println("Setting resolution to " + width + "x" + height);
    }

    // TODO needs params
    private void adjustImageProcessingParameters() {
        System.out.println("Adjusting image processing parameters");
    }

    // TODO
    public void getSensorInfo() {
        System.out.println("Sensor Info");
    }

    // TODO
    public void reset() {
        System.out.println("Resetting");
    }

    // TODO
    public void powerOn() {
        System.out.println("Power on");
    }

    // TODO
    public void powerOff() {
        System.out.println("Power off");
    }
}
