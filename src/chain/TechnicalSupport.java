package chain;

public class TechnicalSupport extends SupportHandler {
    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.getUrgency() == 2;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("[Техподдержка] Исправили проблему: " + request.getMessage());
    }
}
