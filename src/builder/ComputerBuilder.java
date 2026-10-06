package builder;

public interface ComputerBuilder {
    ComputerBuilder withCpu(String cpu);

    ComputerBuilder withRam(int ramGb);

    ComputerBuilder withStorage(int storageGb);

    ComputerBuilder withGpu(String gpu);

    ComputerBuilder withOs(String os);

    Computer build();
}
