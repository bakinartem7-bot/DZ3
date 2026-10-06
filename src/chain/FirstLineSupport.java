package chain;

public class FirstLineSupport extends SupportHandler {
    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.getUrgency() == 1;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("[1-я линия] Ответили на вопрос: " + request.getMessage());
    }
}
