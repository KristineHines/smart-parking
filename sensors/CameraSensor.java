package sensors;

import java.util.Random;

public class CameraSensor implements ParkingSensor {
    private final String OCCUPIED = "Occupied";
    private final String VACANT = "Vacant";
    private boolean isOn = false;
    private int resolution;
    private int framerate;
    private String contrast;
    private String brightness;
    private String sharpness;

    public CameraSensor() {
        this.isOn = true;
        System.out.println("-- Initializing the Camera Sensor");
        System.out.println("   1. Resolution.");
        System.out.println("   2. Framerate.");
        System.out.println("Sensor Initialized!");
        setup();
    }

    private void setup() {
        setFramerate(30);
        setResolution(1920, 1080);
        adjustImageProcessingParameters( "High", "Medium", "Low");
    }

    private void setFramerate(int framerate) {
        this.framerate = framerate;
    }

    public boolean detectVehicle() {
        captureImage();
        processImage();
        Random random = new Random();
        return random.nextBoolean();
    }

    public String getParkingStatus() {
        return detectVehicle() ? OCCUPIED : VACANT;
    }

    private void captureImage() {
        System.out.println("image captured");
    }

    private void processImage() {
        System.out.println("image processed");
    }

    public void getOccupancyStatus() {
        if (getParkingStatus().equals(OCCUPIED)) {
            System.out.print("Occupied");
        } else {
            System.out.print("Vacant");
        }
    }

    private void setResolution(int width, int height) {
        this.resolution = width * height;
    }

    private void adjustImageProcessingParameters(String contrast, String brightness, String sharpness) {
        this.contrast = contrast;
        this.brightness = brightness;
        this.sharpness = sharpness;
    }

    public void getSensorInfo() {
        System.out.println("Sensor Info");
    }

    public void reset() {
        System.out.println("Resetting");
        powerOff();
        powerOn();
        setup();
    }

    public void powerOn() {
        this.isOn = true;
        System.out.println("Power on");
    }

    public void powerOff() {
        this.isOn = false;
        System.out.println("Power off");
    }

    public int getResolution() {
        return resolution;
    }

    public int getFramerate() {
        return framerate;
    }

    public String getContrast() {
        return contrast;
    }

    public void setContrast(String contrast) {
        this.contrast = contrast;
    }

    public String getBrightness() {
        return brightness;
    }

    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }

    public String getSharpness() {
        return sharpness;
    }

    public void setSharpness(String sharpness) {
        this.sharpness = sharpness;
    }
}
