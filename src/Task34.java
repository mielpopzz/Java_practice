public class Task34 {
    public static void main(String[] args) {
        System.out.println("=== Практика #1: Объяснение классов исключений ===\n");
        explainExceptionClasses();

        System.out.println("\n=== Практика #2: Примеры генерации и обработки исключений ===\n");
        demonstrateExceptions();
    }

    // Практика #1: Объяснение классов исключений
    public static void explainExceptionClasses() {
        /*
        ИЕРАРХИЯ ИСКЛЮЧЕНИЙ В JAVA:
        
        java.lang.Throwable - корневой класс всех исключений и ошибок
            |
            ├── Error (Ошибки) - серьезные проблемы, которые обычно НЕ должны перехватываться
            |       |
            |       ├── OutOfMemoryError - нехватка памяти в куче
            |       ├── StackOverflowError - переполнение стека
            |       └── VirtualMachineError - ошибки JVM
            |
            └── Exception (Исключения) - проблемы, которые МОЖНО и НУЖНО обрабатывать
                    |
                    ├── RuntimeException (Непроверяемые исключения)
                    |       |
                    |       ├── NullPointerException - обращение к null
                    |       ├── ArithmeticException - арифметическая ошибка
                    |       ├── ArrayIndexOutOfBoundsException - выход за границы массива
                    |       ├── IllegalArgumentException - неверный аргумент
                    |       └── ClassCastException - неверное приведение типов
                    |
                    └── Проверяемые исключения (checked exceptions)
                            |
                            ├── IOException - ошибки ввода-вывода
                            ├── SQLException - ошибки работы с БД
                            ├── ClassNotFoundException - класс не найден
                            └── InterruptedException - прерывание потока
        
        НАЗНАЧЕНИЕ ОСНОВНЫХ КЛАССОВ:
        
        1. Throwable
           - Базовый класс для всех исключений и ошибок
           - Содержит стек вызовов (stack trace)
           - Имеет методы getMessage(), printStackTrace()
        
        2. Error
           - Критические системные ошибки, которые обычно НЕЛЬЗЯ восстановить
           - Программа не должна их ловить (catch)
           - Пример: OutOfMemoryError - приложение не может работать без памяти
        
        3. Exception
           - Проверяемые исключения (checked exceptions)
           - Должны быть либо обработаны (try-catch), либо объявлены в throws
           - Компилятор проверяет их обработку
           - Используются для ожидаемых проблем (файл не найден, сетевые ошибки)
        
        4. RuntimeException
           - Непроверяемые исключения (unchecked exceptions)
           - НЕ обязательны для обработки или объявления в throws
           - Обычно указывают на ошибки программиста
           - Пример: NullPointerException - программист не проверил null
        
        5. IllegalArgumentException
           - Специальный случай RuntimeException
           - Используется для проверки аргументов методов
           - Лучшая практика: проверять аргументы и бросать это исключение
        
        КОГДА ИСПОЛЬЗОВАТЬ:
        - Error: никогда не ловить в обычном коде
        - Exception: для ожидаемых проблем (файлы, сеть, БД)
        - RuntimeException: для ошибок программиста (null, индексы, аргументы)
        
        ПРАВИЛА ОБРАБОТКИ:
        1. Ловить конкретные исключения, а не Throwable/Exception
        2. Использовать несколько catch блоков от конкретных к общим
        3. Всегда логировать исключения
        4. Не игнорировать исключения пустыми catch блоками
        5. Использовать finally для освобождения ресурсов
        */
    }

    // Практика #2: Примеры исключений
    public static void demonstrateExceptions() {
        System.out.println("Демонстрация исключений с обработкой:\n");

        // 1. ArithmeticException
        System.out.println("1. ArithmeticException - деление на ноль:");
        try {
            int result = 10 / 0; // Генерация исключения
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("   Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
            System.out.println("   Решение: проверить делитель на ноль перед делением");
        }

        // 2. ArrayIndexOutOfBoundsException
        System.out.println("\n2. ArrayIndexOutOfBoundsException - выход за границы массива:");
        try {
            int[] array = {1, 2, 3};
            int value = array[5]; // Неверный индекс
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
            System.out.println("   Решение: проверять индекс перед обращением к массиву");
        }

        // 3. IllegalArgumentException
        System.out.println("\n3. IllegalArgumentException - неверный аргумент:");
        try {
            setAge(-5); // Передаем недопустимое значение
        } catch (IllegalArgumentException e) {
            System.out.println("   Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
            System.out.println("   Решение: проверять аргументы в начале метода");
        }

        // 4. ClassCastException
        System.out.println("\n4. ClassCastException - неверное приведение типов:");
        try {
            Object obj = "Это строка";
            Integer num = (Integer) obj; // Попытка привести String к Integer
            System.out.println("Число: " + num);
        } catch (ClassCastException e) {
            System.out.println("   Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
            System.out.println("   Решение: использовать instanceof перед приведением");

            // Правильный способ:
            Object obj = "Это строка";
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                System.out.println("   Правильно: Число = " + num);
            } else {
                System.out.println("   Правильно: obj не является Integer");
            }
        }

        // 5. NullPointerException
        System.out.println("\n5. NullPointerException - обращение к null:");
        try {
            String text = null;
            int length = text.length(); // Попытка вызвать метод у null
            System.out.println("Длина: " + length);
        } catch (NullPointerException e) {
            System.out.println("   Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
            System.out.println("   Решение: проверять объекты на null перед использованием");

            // Правильный способ:
            String text = null;
            if (text != null) {
                int length = text.length();
                System.out.println("   Правильно: Длина = " + length);
            } else {
                System.out.println("   Правильно: строка равна null");
            }
        }

        // 6. Пример с несколькими catch блоками
        System.out.println("\n6. Обработка нескольких исключений:");
        try {
            // Может генерировать разные исключения
            riskyOperation();
        } catch (ArithmeticException e) {
            System.out.println("   Арифметическая ошибка: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Ошибка индекса массива: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Другое исключение: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("   Блок finally выполняется ВСЕГДА");
        }

        // 7. Пример создания собственного исключения
        System.out.println("\n7. Создание и генерация собственного исключения:");
        try {
            processNumber(-10);
        } catch (InvalidNumberException e) {
            System.out.println("   Поймано собственное исключение: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
            System.out.println("   Некорректное число: " + e.getInvalidNumber());
        }
    }

    // Метод для демонстрации IllegalArgumentException
    private static void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Возраст должен быть от 0 до 150. Передано: " + age);
        }
        System.out.println("   Возраст установлен: " + age);
    }

    // Метод, который может генерировать разные исключения
    private static void riskyOperation() {
        double random = Math.random();
        if (random < 0.3) {
            throw new ArithmeticException("Случайная арифметическая ошибка");
        } else if (random < 0.6) {
            throw new ArrayIndexOutOfBoundsException("Случайная ошибка индекса");
        } else {
            System.out.println("   Операция выполнена успешно!");
        }
    }

    // Метод для демонстрации собственного исключения
    private static void processNumber(int number) throws InvalidNumberException {
        if (number < 0) {
            throw new InvalidNumberException("Число не может быть отрицательным", number);
        }
        System.out.println("   Число обработано: " + number);
    }
}

// Собственный класс исключения (проверяемое исключение)
class InvalidNumberException extends Exception {
    private final int invalidNumber;

    public InvalidNumberException(String message, int invalidNumber) {
        super(message);
        this.invalidNumber = invalidNumber;
    }

    public int getInvalidNumber() {
        return invalidNumber;
    }
}

/*
ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ:

1. ArithmeticException:
   - Деление на ноль: 10 / 0
   - Остаток от деления на ноль: 10 % 0
   - Переполнение при целочисленном делении: Integer.MIN_VALUE / -1

2. ArrayIndexOutOfBoundsException:
   - Обращение к отрицательному индексу: array[-1]
   - Обращение к индексу >= длины массива: array[array.length]
   - В многомерных массивах: matrix[0][10] при matrix[0].length = 5

3. IllegalArgumentException:
   - Неверный цвет: setColor("красныйыы")
   - Неверный диапазон: substring(10, 5)
   - Неверный формат: Integer.parseInt("abc")

4. ClassCastException:
   - Приведение родителя к потомку без проверки
   - Приведение интерфейса к несовместимому классу
   - Использование сырых (raw) типов

5. NullPointerException:
   - Вызов метода у null: null.toString()
   - Обращение к полю у null: obj.name (если obj == null)
   - Индексация null массива: int[] arr = null; arr[0]
   - Синхронизация по null: synchronized(null) { ... }

ПРАВИЛА ОБРАБОТКИ:
1. Всегда обрабатывайте исключения там, где можете с ними что-то сделать
2. Пробрасывайте исключения выше, если не можете их обработать
3. Используйте try-with-resources для автоматического закрытия ресурсов
4. Не используйте исключения для управления потоком выполнения
5. Создавайте информативные сообщения об ошибках
*/