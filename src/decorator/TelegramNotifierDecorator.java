package decorator;

public class TelegramNotifierDecorator extends NotifierDecorator {
    private final String username;

    public TelegramNotifierDecorator(Notifier wrapped, String username) {
        super(wrapped);
        this.username = username;
    }

    @Override
    public void send(String message) {
        wrapped.send(message);
        System.out.println("  Telegram @" + username + ": " + message);
    }
}
