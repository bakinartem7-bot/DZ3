package proxy;

public class ImageProxy implements Image {
    private final String fileName;
    private final String allowedRole;
    private RealImage realImage;

    public ImageProxy(String fileName, String allowedRole) {
        this.fileName = fileName;
        this.allowedRole = allowedRole;
    }

    @Override
    public void display() {
        if (!"admin".equals(allowedRole)) {
            System.out.println("  [Proxy] Доступ запрещён для роли: " + allowedRole);
            return;
        }
        if (realImage == null) {
            System.out.println("  [Proxy] Первое обращение — создаю реальный объект");
            realImage = new RealImage(fileName);
        } else {
            System.out.println("  [Proxy] Изображение взято из кеша: " + fileName);
        }
        realImage.display();
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
