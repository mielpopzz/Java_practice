public class Task27 {
    public static void main(String[] args) {
        // Практика #1: Вложенный класс в интерфейсе

        // Способ 1: Через реализацию интерфейса
        MyInterface27.NestedClass nested1 = new MyInterface27.NestedClass();
        nested1.display();

        // Способ 2: Непосредственный вызов (так как класс статический)
        MyInterface27.NestedClass nested2 = new MyInterface27.NestedClass();
        nested2.showMessage("Привет из main!");

        // Способ 3: Вызов статического метода вложенного класса
        MyInterface27.NestedClass.staticDisplay();

        // Пример с константой из интерфейса
        System.out.println("\nКонстанта из интерфейса: " + MyInterface27.DEFAULT_NAME);
    }
}

// Практика #1: Вложенный класс в интерфейсе
interface MyInterface27 {
    // Константа в интерфейсе (public static final по умолчанию)
    String DEFAULT_NAME = "InterfaceDefault";

    // Статический вложенный класс внутри интерфейса
    class NestedClass {
        private String message;

        public NestedClass() {
            this.message = "Сообщение по умолчанию";
        }

        public NestedClass(String message) {
            this.message = message;
        }

        public void display() {
            System.out.println("NestedClass в интерфейсе: " + message);
            // Доступ к статической константе интерфейса
            System.out.println("Константа интерфейса: " + DEFAULT_NAME);
        }

        public void showMessage(String msg) {
            System.out.println("Показать сообщение: " + msg);
        }

        // Статический метод во вложенном классе
        public static void staticDisplay() {
            System.out.println("Статический метод NestedClass");
            System.out.println("Доступ к константе: " + DEFAULT_NAME);
        }
    }

    // Можно объявить несколько вложенных классов
    static class AnotherNestedClass {
        public void doSomething() {
            System.out.println("Другой вложенный класс в интерфейсе");
        }
    }

    // Пример использования вложенного класса как возвращаемого типа
    NestedClass getNestedInstance();
}

// Пример реализации интерфейса с вложенным классом
class MyImplementation27 implements MyInterface27 {
    @Override
    public NestedClass getNestedInstance() {
        return new NestedClass("Создано в реализации");
    }

    // Метод для демонстрации использования
    public void useNestedClass() {
        // Создание экземпляра вложенного класса
        NestedClass nested = new NestedClass("Из реализации");
        nested.display();

        // Или через полное имя
        MyInterface27.NestedClass nested2 = new MyInterface27.NestedClass();
        nested2.showMessage("Полное имя");
    }
}