package builder;

public class Computer {
    private final String cpu;
    private final int ramGb;
    private final int storageGb;
    private final String gpu;
    private final String os;

    public Computer(String cpu, int ramGb, int storageGb, String gpu, String os) {
        this.cpu = cpu;
        this.ramGb = ramGb;
        this.storageGb = storageGb;
        this.gpu = gpu;
        this.os = os;
    }

    public String getCpu() {
        return cpu;
    }

    public int getRamGb() {
        return ramGb;
    }

    public int getStorageGb() {
        return storageGb;
    }

    public String getGpu() {
        return gpu;
    }

    public String getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "Computer{cpu='" + cpu + "', ram=" + ramGb + "GB, storage=" + storageGb
                + "GB, gpu='" + gpu + "', os='" + os + "'}";
    }
}
