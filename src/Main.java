import adapter.LegacyBankApi;
import adapter.LegacyBankApiAdapter;
import adapter.PaymentProcessor;
import builder.Computer;
import builder.ComputerDirector;
import builder.GamingComputerBuilder;
import builder.OfficeComputerBuilder;
import chain.FirstLineSupport;
import chain.SupportHandler;
import chain.SupportManager;
import chain.SupportRequest;
import chain.TechnicalSupport;
import decorator.EmailNotifier;
import decorator.Notifier;
import decorator.SmsNotifierDecorator;
import decorator.TelegramNotifierDecorator;
import proxy.Image;
import proxy.ImageProxy;
import strategy.BubbleSortStrategy;
import strategy.MergeSortStrategy;
import strategy.QuickSortStrategy;
import strategy.Sorter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        strategyDemo();
        chainDemo();
        builderDemo();
        proxyDemo();
        decoratorDemo();
        adapterDemo();
    }

    private static void strategyDemo() {
        System.out.println("=== Стратегия ===");
        int[] data = {5, 3, 8, 1, 9, 2};
        Sorter sorter = new Sorter(new BubbleSortStrategy());
        System.out.println("Исходник:      " + Arrays.toString(data));
        System.out.println("BubbleSort:    " + sorter.sortAsString(data));
        sorter.setStrategy(new QuickSortStrategy());
        System.out.println("QuickSort:     " + sorter.sortAsString(data));
        sorter.setStrategy(new MergeSortStrategy());
        System.out.println("MergeSort:     " + sorter.sortAsString(data));
        System.out.println("Исходник не изменился: " + Arrays.toString(data));
        System.out.println();
    }

    private static void chainDemo() {
        System.out.println("=== Цепочка обязанностей ===");
        SupportHandler firstLine = new FirstLineSupport();
        firstLine.setNext(new TechnicalSupport()).setNext(new SupportManager());
        firstLine.handle(new SupportRequest(1, "Как сменить пароль?"));
        firstLine.handle(new SupportRequest(2, "Не запускается приложение"));
        firstLine.handle(new SupportRequest(3, "Прошу вернуть деньги за подписку"));
        firstLine.handle(new SupportRequest(4, "Неизвестный запрос"));
        System.out.println();
    }

    private static void builderDemo() {
        System.out.println("=== Строитель ===");
        ComputerDirector director = new ComputerDirector(new OfficeComputerBuilder());
        System.out.println(director.buildOfficePc());
        director.setBuilder(new GamingComputerBuilder());
        System.out.println(director.buildGamingPc());
        System.out.println("Ручная сборка: " + new GamingComputerBuilder()
                .withCpu("Intel Core Ultra 9")
                .withRam(64)
                .build());
        System.out.println();
    }

    private static void proxyDemo() {
        System.out.println("=== Прокси ===");
        Image image = new ImageProxy("photo.png", "admin");
        System.out.println("Первый вызов:");
        image.display();
        System.out.println("Второй вызов:");
        image.display();
        System.out.println("Вызов без прав:");
        new ImageProxy("photo.png", "guest").display();
        System.out.println();
    }

    private static void decoratorDemo() {
        System.out.println("=== Декоратор ===");
        Notifier notifier = new EmailNotifier("user@mail.ru");
        System.out.println("Только e-mail:");
        notifier.send("Сервис будет недоступен 15 минут");

        System.out.println("E-mail + SMS + Telegram:");
        Notifier rich = new TelegramNotifierDecorator(
                new SmsNotifierDecorator(notifier, "+79990001122"),
                "user");
        rich.send("Оплата прошла успешно");
        System.out.println();
    }

    private static void adapterDemo() {
        System.out.println("=== Адаптер ===");
        PaymentProcessor processor = new LegacyBankApiAdapter(new LegacyBankApi());
        System.out.println("USD 2500 центов: " + processor.pay("ACC-1", 2500, "USD"));
        System.out.println("RUB 100000 копеек: " + processor.pay("ACC-1", 100000, "RUB"));
        System.out.println("JPY 5000: " + processor.pay("ACC-1", 5000, "JPY"));
    }
}
