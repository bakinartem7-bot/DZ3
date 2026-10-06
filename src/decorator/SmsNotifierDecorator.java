package decorator;

public class SmsNotifierDecorator extends NotifierDecorator {
    private final String phone;

    public SmsNotifierDecorator(Notifier wrapped, String phone) {
        super(wrapped);
        this.phone = phone;
    }

    @Override
    public void send(String message) {
        wrapped.send(message);
        System.out.println("  SMS на " + phone + ": " + message);
    }
}
