package builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private String cpu;
    private int ramGb;
    private int storageGb;
    private String gpu;
    private String os;

    public OfficeComputerBuilder() {
        reset();
    }

    private void reset() {
        cpu = null;
        ramGb = 8;
        storageGb = 256;
        gpu = "Встроенная графика";
        os = "Linux";
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
            throw new IllegalStateException("Для офисного ПК не задан процессор");
        }
        if (ramGb < 4) {
            throw new IllegalStateException("Для офисного ПК нужно минимум 4 ГБ RAM");
        }
        Computer computer = new Computer(cpu, ramGb, storageGb, gpu, os);
        reset();
        return computer;
    }
}
