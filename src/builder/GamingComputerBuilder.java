package builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private String cpu;
    private int ramGb;
    private int storageGb;
    private String gpu;
    private String os;

    public GamingComputerBuilder() {
        reset();
    }

    private void reset() {
        cpu = null;
        ramGb = 32;
        storageGb = 2000;
        gpu = "RTX 5090";
        os = "Windows 11";
    }

    @Override
    public ComputerBuilder withCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder withRam(int ramGb) {
        this.ramGb = ramGb;
        return this;
    }

    @Override
    public ComputerBuilder withStorage(int storageGb) {
        this.storageGb = storageGb;
        return this;
    }

    @Override
    public ComputerBuilder withGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    @Override
    public ComputerBuilder withOs(String os) {
        this.os = os;
        return this;
    }

    @Override
    public Computer build() {
        if (cpu == null) {
            throw new IllegalStateException("Для игрового ПК не задан процессор");
        }
        if (ramGb < 16) {
            throw new IllegalStateException("Для игрового ПК нужно минимум 16 ГБ RAM");
        }
        Computer computer = new Computer(cpu, ramGb, storageGb, gpu, os);
        reset();
        return computer;
    }
}
