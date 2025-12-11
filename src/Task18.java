public class Task18 {
    public static void main(String[] args) {
        Printer printer = new Printer();


        printer.print();                       // Без параметров
        printer.print(1);                      // Один int -> print(int...)
        printer.print(1, 2, 3);                // Несколько int -> print(int...)
        printer.print("Hello");                // Один String -> print(String...)
        printer.print("Hello", "World");       // Несколько String -> print(String...)

        printer.printValues(1.5, 2.7);         // Другой метод для double

        printer.printObj(new Object());        // Один Object -> отдельный метод

        // Смешанные типы - используем отдельный метод
        printer.printMixed(1, "text", 3.14);   // Смешанные типы
    }
}

class Printer {
    // Без параметров
    void print() {
        System.out.println("Нет параметров");
    }

    // С переменным числом int параметров
    void print(int... numbers) {
        System.out.print("int...: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // С переменным числом String параметров
    void print(String... strings) {
        System.out.print("String...: ");
        for (String str : strings) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    // Отдельный метод для double (чтобы избежать неоднозначности с Object)
    void printValues(double... numbers) {
        System.out.print("double...: ");
        for (double num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Отдельный метод для Object
    void printObj(Object... objects) {
        System.out.print("Object...: ");
        for (Object obj : objects) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    // Метод для смешанных типов
    void printMixed(Object... objects) {
        System.out.print("Mixed...: ");
        for (Object obj : objects) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}