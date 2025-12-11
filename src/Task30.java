public class Task30 {
    public static void main(String[] args) {
        System.out.println("=== Практика #1: Default и статические методы в интерфейсах ===");

        // Создаем объект класса, реализующего интерфейс
        ConsolePrinter printer = new ConsolePrinter();

        // Вызов default метода через объект класса
        printer.printDefault("Hello, World!");

        // Вызов абстрактного метода
        printer.print("Это абстрактный метод");

        // Вызов статического метода напрямую через интерфейс
        PrinterUtility.printStatic("Статический вызов");

        // Практика #1 дополнительно: можно вызвать default метод через интерфейс
        // но только если есть объект, реализующий интерфейс
        ConsolePrinter anotherPrinter = new ConsolePrinter();
        anotherPrinter.printDefault("Еще одно сообщение");

        System.out.println("\n=== Практика #2: Конфликт default методов ===");

        // Создаем объект класса, реализующего два интерфейса с одинаковыми default методами
        SmartPhone device = new SmartPhone();

        // Вызываем метод, который есть в обоих интерфейсах
        device.turnOn();

        // Вызываем уникальные методы каждого интерфейса
        device.connectToWiFi();
        device.connectToBluetooth();
    }
}

// ========== ПРАКТИКА #1 ==========

// Интерфейс с default и статическим методом
interface PrinterUtility {
    // Абстрактный метод (по умолчанию все методы в интерфейсе абстрактные и public)
    void print(String message);

    // Default метод (неабстрактный) - может иметь реализацию
    default void printDefault(String message) {
        System.out.println("[Default Printer] Печать: " + message);
    }

    // Статический метод - вызывается через имя интерфейса
    static void printStatic(String message) {
        System.out.println("[Static Printer] Печать: " + message);
    }
}

// Класс, реализующий интерфейс
class ConsolePrinter implements PrinterUtility {
    // Реализация абстрактного метода
    @Override
    public void print(String message) {
        System.out.println("[ConsolePrinter] " + message);
    }

    // Default метод можно переопределить, но не обязательно
    @Override
    public void printDefault(String message) {
        System.out.println("[Переопределенный Default] " + message);
    }
}

// ========== ПРАКТИКА #2 ==========

// Два интерфейса с одинаковыми default методами
interface WiFiDevice {
    // Default метод с реализацией
    default void turnOn() {
        System.out.println("WiFi устройство включено");
    }

    default void connectToWiFi() {
        System.out.println("Подключение к WiFi сети");
    }
}

interface BluetoothDevice {
    // Default метод с такой же сигнатурой
    default void turnOn() {
        System.out.println("Bluetooth устройство включено");
    }

    default void connectToBluetooth() {
        System.out.println("Подключение к Bluetooth устройству");
    }
}

// Класс, реализующий оба интерфейса
class SmartDevice implements WiFiDevice, BluetoothDevice {
    // Явно переопределяем конфликтующий default метод
    @Override
    public void turnOn() {
        System.out.println("Умное устройство включается...");

        // Можно вызвать default реализацию из конкретного интерфейса
        WiFiDevice.super.turnOn(); // Вызов default метода из WiFiDevice
        BluetoothDevice.super.turnOn(); // Вызов default метода из BluetoothDevice

        System.out.println("Устройство полностью готово к работе");
    }
}

// Конкретный класс устройства
class SmartPhone extends SmartDevice {
    // Можно дополнительно расширить функциональность
    @Override
    public void turnOn() {
        System.out.println("=== Загрузка смартфона ===");
        super.turnOn();
        System.out.println("Добро пожаловать!");
    }
}
/*
Объяснение для Практики #2:

ПРОБЛЕМА:
Когда класс реализует два интерфейса с одинаковыми default методами,
возникает конфликт - компилятор не знает, какую реализацию использовать.

РЕШЕНИЕ:
1. Класс ДОЛЖЕН явно переопределить конфликтующий метод
2. В переопределенном методе можно:
   - Предоставить свою собственную реализацию
   - Выбрать одну из default реализаций с помощью синтаксиса:
        InterfaceName.super.methodName()
   - Вызвать несколько default реализаций в нужном порядке
   - Комбинировать вызовы default методов со своей логикой

ВАЖНО:
- Конфликт возникает ТОЛЬКО если методы имеют одинаковую сигнатуру
  (имя и параметры)
- Возвращаемый тип должен быть совместимым
- Если методы в интерфейсах абстрактные (без default), конфликта нет -
  класс просто должен их реализовать
- Конфликт default методов - это основная причина, почему в Java
  нет полноценного множественного наследования классов, но есть
  множественная реализация интерфейсов
*/