package chain;

public class SupportManager extends SupportHandler {
    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.getUrgency() == 3;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("[Менеджер] Принял решение по запросу: " + request.getMessage());
    }
}
