package builder;

public class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer buildOfficePc() {
        return builder
                .withCpu("Intel Core i5-14400")
                .withRam(16)
                .withStorage(512)
                .build();
    }

    public Computer buildGamingPc() {
        return builder
                .withCpu("AMD Ryzen 9 9950X")
                .withRam(64)
                .withStorage(4000)
                .build();
    }
}
