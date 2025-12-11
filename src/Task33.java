import java.util.Date;
import java.util.Formatter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Calendar;

public class Task33 {
    public static void main(String[] args) {
        System.out.println("=== Практика #1: Спецификаторы формата ===\n");
        demonstrateFormatSpecifiers();

        System.out.println("\n=== Практика #2: Метод flush() ===\n");
        demonstrateFlushMethod();

        System.out.println("\n=== Практика #3: Спецификаторы времени и даты ===\n");
        demonstrateDateTimeSpecifiers();
    }

    // Практика #1: Примеры использования спецификаторов формата
    public static void demonstrateFormatSpecifiers() {
        System.out.println("Примеры использования спецификаторов формата:\n");

        // 1. %s - строковое представление
        String name = "Алексей";
        int age = 30;
        System.out.println("1. %s - строковое представление:");
        System.out.printf("   Привет, %s! Тебе %s лет.%n", name, age);
        System.out.printf("   Форматированная строка: %s%n", String.format("Имя: %s, Возраст: %d", name, age));

        // 2. %d - десятичное целое число
        int quantity = 15;
        int price = 100;
        System.out.println("\n2. %d - десятичные целые числа:");
        System.out.printf("   Количество: %d, Цена: %d, Сумма: %d%n",
                quantity, price, quantity * price);
        System.out.printf("   С выравниванием: [%5d] [%-5d]%n", 123, 123);
        System.out.printf("   С ведущими нулями: %05d%n", 42);

        // 3. %f - числа с плавающей точкой
        double pi = Math.PI;
        double temperature = 23.5;
        System.out.println("\n3. %f - числа с плавающей точкой:");
        System.out.printf("   Число Пи: %f%n", pi);
        System.out.printf("   Температура: %.1f°C%n", temperature);
        System.out.printf("   С заданной точностью: %.3f и %.5f%n", pi, pi);
        System.out.printf("   С отступом: [%10.2f] [%-10.2f]%n", 123.456, 123.456);

        // 4. %b - логическое значение
        boolean isJavaFun = true;
        boolean isLearning = false;
        System.out.println("\n4. %b - логические значения:");
        System.out.printf("   Java интересна? %b%n", isJavaFun);
        System.out.printf("   Завершил обучение? %b%n", isLearning);
        System.out.printf("   null как boolean: %b%n", null);
        System.out.printf("   Число как boolean: %b%n", 123);

        // 5. %c - символьное представление
        char grade = 'A';
        char plus = '+';
        System.out.println("\n5. %c - символьное представление:");
        System.out.printf("   Оценка: %c%n", grade);
        System.out.printf("   Символ: %c%c%n", grade, plus);
        System.out.printf("   Unicode символ: %c%n", '\u03A9'); // Греческая омега

        // Дополнительно: %n и %%
        System.out.println("\n6. %n и %% - специальные символы:");
        System.out.printf("   Процентная ставка: 15.5%%%n");
        System.out.printf("   Первая строка%nВторая строка%nТретья строка%n");

        // 7. %h - хэш-код
        System.out.println("\n7. %h - хэш-код объекта:");
        String str = "Hello";
        System.out.printf("   Хэш-код строки '%s': %h%n", str, str);
        System.out.printf("   Хэш-код числа 42: %h%n", 42);

        // 8. %e - экспоненциальное представление
        double largeNumber = 123456789.0;
        double smallNumber = 0.000012345;
        System.out.println("\n8. %e - экспоненциальное представление:");
        System.out.printf("   Большое число: %e%n", largeNumber);
        System.out.printf("   Маленькое число: %e%n", smallNumber);
        System.out.printf("   С точностью: %.3e%n", largeNumber);
    }

    // Практика #2: Демонстрация метода flush()
    public static void demonstrateFlushMethod() {
        System.out.println("Что такое метод flush() и зачем он нужен?");
        System.out.println("\nflush() принудительно записывает все буферизованные данные в выходной поток.");

        System.out.println("\nПример без flush():");
        try {
            FileWriter fw = new FileWriter("output_without_flush.txt");
            fw.write("Эта строка находится в буфере...\n");
            fw.write("И эта тоже...\n");
            // Без flush() данные могут не записаться в файл сразу
            System.out.println("   Данные записаны в FileWriter, но не сброшены в файл");
            // fw.close(); // close() автоматически вызывает flush()
        } catch (IOException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        }

        System.out.println("\nПример с flush():");
        try {
            FileWriter fw = new FileWriter("output_with_flush.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.print("Первая строка - ");
            pw.println("будет в буфере");

            System.out.println("   До flush(): данные в буфере");
            pw.flush(); // Принудительная запись из буфера в файл
            System.out.println("   После flush(): данные записаны в файл");

            pw.print("Вторая строка");
            pw.flush(); // Снова сбрасываем буфер
            System.out.println("   Вторая строка тоже записана");

            pw.close();
        } catch (IOException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        }

        System.out.println("\nКогда нужно использовать flush():");
        System.out.println("1. Когда нужно гарантировать запись данных НЕМЕДЛЕННО");
        System.out.println("2. При работе с сетевыми сокетами");
        System.out.println("3. При логировании важных событий");
        System.out.println("4. При интерактивном вводе-выводе");
        System.out.println("5. Когда программа может завершиться аварийно");

        System.out.println("\nПример с System.out:");
        System.out.print("   Это сообщение без новой строки...");
        System.out.flush(); // Гарантируем вывод до паузы
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" продолжение после паузы");
    }

    // Практика #3: Спецификаторы времени и даты
    public static void demonstrateDateTimeSpecifiers() {
        System.out.println("Примеры использования спецификаторов времени и даты:\n");

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();

        // 1. %tH и %tM - часы и минуты
        System.out.println("1. %tH и %tM - часы и минуты:");
        System.out.printf("   Текущее время: %tH:%tM%n", currentDate, currentDate);
        System.out.printf("   В 24-часовом формате: %tH часов %tM минут%n", calendar, calendar);

        // 2. %tI - часы в 12-часовом формате
        System.out.println("\n2. %tI - часы в 12-часовом формате:");
        System.out.printf("   В 12-часовом формате: %tI:%tM %Tp%n",
                currentDate, currentDate, currentDate);

        // 3. %tS и %tL - секунды и миллисекунды
        System.out.println("\n3. %tS и %tL - секунды и миллисекунды:");
        System.out.printf("   Точное время: %tH:%tM:%tS.%tL%n",
                currentDate, currentDate, currentDate, currentDate);

        // 4. %tY и %tm - год и месяц
        System.out.println("\n4. %tY и %tm - год и месяц:");
        System.out.printf("   Дата: %td.%tm.%tY%n",
                currentDate, currentDate, currentDate);
        System.out.printf("   Год в 2-х цифрах: %ty%n", currentDate);
        System.out.printf("   Месяц числом: %tm%n", currentDate);

        // 5. %tB и %tA - названия месяца и дня недели
        System.out.println("\n5. %tB и %tA - названия месяца и дня недели:");
        System.out.printf("   Полная дата: %tA, %td %tB %tY года%n",
                currentDate, currentDate, currentDate, currentDate);

        // 6. Дополнительные примеры
        System.out.println("\n6. Дополнительные форматы даты и времени:");

        // Различные комбинации
        System.out.printf("   Короткий формат: %td/%tm/%ty%n",
                currentDate, currentDate, currentDate);

        System.out.printf("   Время с секундами: %tH:%tM:%tS%n",
                currentDate, currentDate, currentDate);

        // Использование Calendar
        System.out.printf("\n7. Использование Calendar:");
        System.out.printf("   Calendar время: %tH:%tM:%tS%n",
                calendar, calendar, calendar);
        System.out.printf("   Calendar дата: %td.%tm.%tY%n",
                calendar, calendar, calendar);

        // Форматирование определенной даты
        System.out.println("\n8. Форматирование конкретной даты:");
        Calendar specificDate = Calendar.getInstance();
        specificDate.set(2024, Calendar.DECEMBER, 31, 23, 59, 59);
        Date newYearEve = specificDate.getTime();

        System.out.printf("   Канун Нового Года: %tA, %td %tB %tY%n",
                newYearEve, newYearEve, newYearEve, newYearEve);
        System.out.printf("   Время: %tH:%tM:%tS%n",
                newYearEve, newYearEve, newYearEve);

        // Дополнительные спецификаторы
        System.out.println("\n9. Другие полезные спецификаторы:");
        System.out.printf("   День месяца (01-31): %td%n", currentDate);
        System.out.printf("   День месяца (1-31): %te%n", currentDate);
        System.out.printf("   День года (001-366): %tj%n", currentDate);
        System.out.printf("   AM/PM метка: %Tp%n", currentDate);

        // Создание форматированной строки
        System.out.println("\n10. Форматированная строка с датой:");
        String formattedDate = String.format("Сегодня: %tA, %td %tB %tY",
                currentDate, currentDate, currentDate, currentDate);
        System.out.println("   " + formattedDate);

        String formattedTime = String.format("Время: %tH:%tM:%tS",
                currentDate, currentDate, currentDate);
        System.out.println("   " + formattedTime);
    }
}

/*
Практика #2: Зачем нужен метод flush()?

Метод flush() используется в потоках вывода (OutputStream, Writer и их подклассы) 
для принудительной записи данных из буфера в целевое устройство.

Зачем он нужен:

1. БУФЕРИЗАЦИЯ ДАННЫХ:
   - Потоки ввода-вывода часто используют буфер для повышения производительности
   - Данные накапливаются в буфере и записываются пачками
   - flush() заставляет немедленно записать все данные из буфера

2. ГАРАНТИЯ ЗАПИСИ:
   - Без flush() данные могут оставаться в буфере долгое время
   - При аварийном завершении программы данные в буфере теряются
   - flush() гарантирует, что данные достигли цели

3. ИСПОЛЬЗОВАНИЕ В РЕАЛЬНЫХ СЦЕНАРИЯХ:
   - Логирование: чтобы важные сообщения сразу попали в лог-файл
   - Сетевые соединения: для немедленной отправки данных
   - Интерактивные приложения: для вывода сообщений пользователю
   - Длительные операции: периодическая запись промежуточных результатов

4. АВТОМАТИЧЕСКИЙ FLUSH:
   - Некоторые классы (PrintWriter с autoFlush=true) делают flush автоматически
   - Метод close() обычно вызывает flush() перед закрытием
   - Но для контроля лучше вызывать flush() явно, когда это нужно

5. ПРОИЗВОДИТЕЛЬНОСТЬ vs НАДЕЖНОСТЬ:
   - Частые вызовы flush() снижают производительность
   - Редкие вызовы повышают риск потери данных
   - Нужно находить баланс в зависимости от задачи

ВАЖНО: Всегда вызывайте flush() или close() перед завершением работы с потоком,
чтобы гарантировать сохранность данных.
*/