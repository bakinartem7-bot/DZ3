package proxy;

public class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("  Загрузка файла с диска: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("  Отображение изображения: " + fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
