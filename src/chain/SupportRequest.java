package chain;

public class SupportRequest {
    private final int urgency;
    private final String message;

    public SupportRequest(int urgency, String message) {
        this.urgency = urgency;
        this.message = message;
    }

    public int getUrgency() {
        return urgency;
    }

    public String getMessage() {
        return message;
    }
}
