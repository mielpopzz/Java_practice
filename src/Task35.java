public class Task35 {
    public static void main(String[] args) {
        System.out.println("=== Практика #1: Обработка и необработка исключений ===\n");

        System.out.println("Запуск метода с обработкой исключений...");
        methodWithHandledException();

        System.out.println("\nПрограмма продолжает работу после первого метода\n");

        System.out.println("Запуск метода с НЕобработанным исключением...");
        methodWithUnhandledException();

        // Этот код не выполнится из-за аварийной остановки
        System.out.println("Это сообщение никогда не будет выведено");
    }

    // Метод, который обрабатывает исключение
    public static void methodWithHandledException() {
        try {
            System.out.println("  Внутри methodWithHandledException:");
            System.out.println("  Генерация ArithmeticException...");

            // Генерируем исключение, которое будет обработано
            int result = 10 / 0; // ArithmeticException

            System.out.println("  Результат: " + result);
        } catch (ArithmeticException e) {
            // Исключение ПЕРЕХВАЧЕНО и обработано
            System.out.println("  Исключение ПЕРЕХВАЧЕНО: " + e.getClass().getSimpleName());
            System.out.println("  Сообщение: " + e.getMessage());
            System.out.println("  Программа продолжает работу в этом же методе");
        }

        System.out.println("  Метод methodWithHandledException завершил работу нормально");
    }

    // Метод, который НЕ обрабатывает исключение
    public static void methodWithUnhandledException() {
        System.out.println("  Внутри methodWithUnhandledException:");
        System.out.println("  Генерация ArrayIndexOutOfBoundsException...");

        // Генерируем исключение, которое НЕ будет обработано
        int[] array = new int[3];
        int value = array[10]; // ArrayIndexOutOfBoundsException

        System.out.println("  Значение: " + value);
        // Этот код не выполнится из-за исключения
        System.out.println("  Эта строка не будет выведена");
    }
}