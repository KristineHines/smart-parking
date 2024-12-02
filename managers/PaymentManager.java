package managers;

import java.util.HashMap;
import java.util.Map;

public class PaymentManager {
    private Map<String, Double> payments = new HashMap<>();

    public void processPayment(String licensePlate, double amount) {
        this.payments.put(licensePlate, this.payments.getOrDefault(licensePlate, 0.0) + amount);
        System.out.println("Payment of $" + amount + " processed for " + licensePlate);
    }
}
