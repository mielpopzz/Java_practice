import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task40 {
    public static void main(String[] args) {
        System.out.println("=== Практика #1: InputStream.read() ===\n");
        demonstrateInputStreamRead();

        System.out.println("\n=== Практика #2: OutputStream.write(int) ===\n");
        demonstrateOutputStreamWrite();

        System.out.println("\n=== Практика #3: Reader/Writer vs InputStream/OutputStream ===\n");
        /*
        Зачем нужны Reader и Writer если есть InputStream и OutputStream?

        1. КОДИРОВКА СИМВОЛОВ:
           - InputStream/OutputStream работают с БАЙТАМИ (8 бит)
           - Reader/Writer работают с СИМВОЛАМИ (Unicode, 16 бит)

        2. МЕЖДУНАРОДИЗАЦИЯ:
           - Reader/Writer автоматически обрабатывают кодировки
           - InputStream.read() возвращает байт (0-255)
           - Reader.read() возвращает char (0-65535) или кодовую точку Unicode

        3. ПРЕОБРАЗОВАНИЕ:
           - InputStreamReader - мост от InputStream к Reader
           - OutputStreamWriter - мост от Writer к OutputStream

        4. ПРИМЕР РАЗНИЦЫ:
           Байт 'A' (65) vs Символ 'А' (кириллическая А, U+0410)

        5. ТЕКСТ vs БИНАРНЫЕ ДАННЫЕ:
           - Reader/Writer - для ТЕКСТА
           - InputStream/OutputStream - для ЛЮБЫХ данных (текст, изображения и т.д.)
        */

        System.out.println("=== Практика #4: AutoCloseable ===\n");
        demonstrateAutoCloseable();
    }

    // Практика #1: Пример использования InputStream.read()
    public static void demonstrateInputStreamRead() {
        String text = "Hello InputStream!";
        byte[] bytes = text.getBytes();

        // Используем ByteArrayInputStream - подкласс InputStream
        try (InputStream inputStream = new ByteArrayInputStream(bytes)) {
            System.out.println("Чтение данных из ByteArrayInputStream:");

            int data;
            System.out.print("   Прочитанные байты: ");
            while ((data = inputStream.read()) != -1) {
                System.out.print(data + " ");
            }
            System.out.println();

            // Восстанавливаем строку
            inputStream.reset(); // Возвращаемся к началу потока
            System.out.print("   Как символы: ");
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Практика #2: Пример использования OutputStream.write(int)
    public static void demonstrateOutputStreamWrite() {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            System.out.println("Запись данных в ByteArrayOutputStream:");

            // Записываем байты по одному
            String message = "Java";
            System.out.print("   Записываем строку: '" + message + "' как байты: ");

            for (char c : message.toCharArray()) {
                int byteValue = c; // char автоматически преобразуется в int
                outputStream.write(byteValue);
                System.out.print(byteValue + " ");
            }

            // Получаем записанные данные
            byte[] result = outputStream.toByteArray();
            System.out.println("\n   Полученный массив байт: " + new String(result));

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Практика #4: Пример использования AutoCloseable
    public static void demonstrateAutoCloseable() {
        /*
        Зачем нужен интерфейс AutoCloseable?

        1. АВТОМАТИЧЕСКОЕ ЗАКРЫТИЕ РЕСУРСОВ:
           - try-with-resources автоматически закрывает ресурсы
           - Не нужно явно вызывать close() в finally

        2. ИЕРАРХИЯ:
           interface AutoCloseable (Java 7+)
               |
               interface Closeable extends AutoCloseable

        3. ПРИМЕР try-with-resources:
        */

        System.out.println("Пример с try-with-resources (AutoCloseable):");

        // Старый способ (до Java 7)
        System.out.println("1. Старый способ (с finally):");
        FileWriter oldWayWriter = null;
        try {
            oldWayWriter = new FileWriter("old_way.txt");
            oldWayWriter.write("Старый способ");
        } catch (IOException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        } finally {
            if (oldWayWriter != null) {
                try {
                    oldWayWriter.close();
                    System.out.println("   Ресурс закрыт в finally");
                } catch (IOException e) {
                    System.out.println("   Ошибка при закрытии: " + e.getMessage());
                }
            }
        }

        // Новый способ (с Java 7) - try-with-resources
        System.out.println("\n2. Новый способ (try-with-resources):");
        try (FileWriter newWayWriter = new FileWriter("new_way.txt")) {
            newWayWriter.write("Новый способ");
            System.out.println("   Данные записаны");
            // Ресурс автоматически закроется здесь
        } catch (IOException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        }
        System.out.println("   Ресурс автоматически закрыт");

        // Создаем собственный ресурс с AutoCloseable
        System.out.println("\n3. Собственный класс с AutoCloseable:");
        try (MyResource resource = new MyResource()) {
            resource.doSomething();
            throw new IOException("Исключение в try блоке");
        } catch (Exception e) {
            System.out.println("   Поймано исключение: " + e.getMessage());
        }
        // MyResource.close() вызовется автоматически
    }
}

// Практика #4: Собственный класс, реализующий AutoCloseable
class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("   MyResource создан");
    }

    public void doSomething() {
        System.out.println("   MyResource что-то делает");
    }

    @Override
    public void close() {
        System.out.println("   MyResource.close() вызван автоматически");
    }
}