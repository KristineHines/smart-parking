package sensors;

public class EnvironmentalSensor {
    public void getEnvironmentalInformation() {
        System.out.println("Temperature: " + getTemperature() + " °C");
        System.out.println("Humidity: " + getHumidity() + "%");
        System.out.println("Air Quality: " + getAirQuality());
    }

    public double getTemperature() {
        return 20.0 + (Math.random() * 10); // Random temperature
    }

    public double getHumidity() {
        return 40.0 + (Math.random() * 20); // Random humidity
    }

    public String getAirQuality() {
        return "Good"; // Simplified
    }
}