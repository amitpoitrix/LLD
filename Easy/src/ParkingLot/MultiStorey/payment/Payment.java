package ParkingLot.MultiStorey.payment;

public class Payment {
    private final PaymentMethod paymentMethod;
    private final double amount;

    public Payment(PaymentMethod paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    // Payment Processing - Mock
    public void processPayment() {
        System.out.println("Processing " + paymentMethod + " payment of amount $" + amount);
    }
}
