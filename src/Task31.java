public class Task31 {
    public static void main(String[] args) {
        // Практика #1: Демонстрация методов класса String
        System.out.println("=== Практика #1: Методы класса String ===\n");

        String original = "   Hello, World!   ";
        String another = "HELLO, WORLD!";
        String empty = "";
        String spaces = "   ";

        // 1. length() - возвращает длину строки
        System.out.println("1. length(): " + original.length());
        // Возвращает количество символов в строке

        // 2. trim() - удаляет пробелы в начале и конце строки
        System.out.println("2. trim(): '" + original.trim() + "'");
        // Убирает ведущие и завершающие пробелы

        // 3. toUpperCase() и toLowerCase() - преобразование регистра
        System.out.println("3. toUpperCase(): " + original.toUpperCase());
        System.out.println("   toLowerCase(): " + original.toLowerCase());
        // Преобразуют все символы строки в верхний/нижний регистр

        // 4. equals() и equalsIgnoreCase() - сравнение строк
        System.out.println("4. equals(): " + original.equals(another));
        System.out.println("   equalsIgnoreCase(): " + original.trim().equalsIgnoreCase(another));
        // equals() - точное сравнение с учетом регистра
        // equalsIgnoreCase() - сравнение без учета регистра

        // 5. startsWith() и endsWith() - проверка начала/окончания
        System.out.println("5. startsWith('Hello'): " + original.trim().startsWith("Hello"));
        System.out.println("   endsWith('!'): " + original.trim().endsWith("!"));
        // Проверяет, начинается/заканчивается ли строка указанной подстрокой

        // 6. contains() - проверка наличия подстроки
        System.out.println("6. contains('World'): " + original.contains("World"));
        // Проверяет, содержит ли строка указанную подстроку

        // 7. substring() - извлечение подстроки
        System.out.println("7. substring(7, 12): '" + original.trim().substring(7, 12) + "'");
        // Извлекает часть строки от startIndex до endIndex-1

        // 8. replace() и replaceAll() - замена символов/подстрок
        System.out.println("8. replace('o', '0'): " + original.trim().replace('o', '0'));
        System.out.println("   replaceAll('[aeiou]', '*') (замена гласных): " +
                original.trim().replaceAll("[aeiouAEIOU]", "*"));
        // replace() - замена символов или CharSequence
        // replaceAll() - замена с использованием регулярных выражений

        // 9. split() - разделение строки на массив
        System.out.println("9. split(', '):");
        String[] parts = original.trim().split(", ");
        for (String part : parts) {
            System.out.println("   - '" + part + "'");
        }
        // Разделяет строку на массив подстрок по указанному разделителю

        // 10. isEmpty() и isBlank() - проверка пустоты строки
        System.out.println("10. isEmpty() для '': " + empty.isEmpty());
        System.out.println("    isEmpty() для '   ': " + spaces.isEmpty());
        System.out.println("    isBlank() для '   ': " + spaces.isBlank());
        // isEmpty() - true если длина строки 0
        // isBlank() - true если строка пустая или содержит только пробелы (Java 11+)

        // Дополнительно: charAt() и indexOf()
        System.out.println("\nДополнительные методы:");
        System.out.println("charAt(4): '" + original.trim().charAt(4) + "'");
        // Возвращает символ по указанному индексу
        System.out.println("indexOf('o'): " + original.trim().indexOf('o'));
        // Возвращает индекс первого вхождения символа/подстроки

        // Практика #2: StringJoiner
        System.out.println("\n=== Практика #2: StringJoiner ===\n");
        demonstrateStringJoiner();

        // Практика #3: Тройные кавычки (текстовые блоки)
        System.out.println("\n=== Практика #3: Тройные кавычки (Text Blocks) ===\n");
        demonstrateTextBlocks();
    }

    // Практика #2: Примеры использования StringJoiner
    public static void demonstrateStringJoiner() {
        System.out.println("Пример 1: Простое объединение с разделителем");
        java.util.StringJoiner joiner1 = new java.util.StringJoiner(", ");
        joiner1.add("Яблоко");
        joiner1.add("Банан");
        joiner1.add("Апельсин");
        System.out.println("Результат: " + joiner1.toString());

        System.out.println("\nПример 2: С префиксом и суффиксом");
        java.util.StringJoiner joiner2 = new java.util.StringJoiner(" | ", "[ ", " ]");
        joiner2.add("Понедельник");
        joiner2.add("Вторник");
        joiner2.add("Среда");
        System.out.println("Результат: " + joiner2.toString());

        System.out.println("\nПример 3: Пустой StringJoiner с default значением");
        java.util.StringJoiner joiner3 = new java.util.StringJoiner(", ", "Числа: ", ".");
        System.out.println("До добавления элементов: '" + joiner3.toString() + "'");
        joiner3.setEmptyValue("Нет чисел");
        System.out.println("После setEmptyValue: '" + joiner3.toString() + "'");
        joiner3.add("1");
        joiner3.add("2");
        joiner3.add("3");
        System.out.println("После добавления элементов: " + joiner3.toString());

        System.out.println("\nПример 4: Объединение двух StringJoiner");
        java.util.StringJoiner fruits = new java.util.StringJoiner(", ");
        fruits.add("Яблоко");
        fruits.add("Груша");

        java.util.StringJoiner vegetables = new java.util.StringJoiner(", ");
        vegetables.add("Морковь");
        vegetables.add("Картофель");

        java.util.StringJoiner allProducts = new java.util.StringJoiner("; ");
        allProducts.merge(fruits);
        allProducts.merge(vegetables);
        System.out.println("Все продукты: " + allProducts.toString());
    }

    // Практика #3: Тройные кавычки (Text Blocks)
    public static void demonstrateTextBlocks() {
        // Традиционный подход с конкатенацией
        String traditionalHtml = "<html>\n" +
                "    <head>\n" +
                "        <title>Моя страница</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Привет, мир!</h1>\n" +
                "    </body>\n" +
                "</html>";

        // Текст с использованием текстовых блоков (Java 15+)
        String textBlockHtml = """
            <html>
                <head>
                    <title>Моя страница</title>
                </head>
                <body>
                    <h1>Привет, мир!</h1>
                </body>
            </html>
            """;

        System.out.println("Традиционный подход (конкатенация):");
        System.out.println(traditionalHtml);
        System.out.println("\nТекстовый блок (тройные кавычки):");
        System.out.println(textBlockHtml);

        // Дополнительные примеры текстовых блоков
        System.out.println("\nПример 2: JSON с текстовым блоком");
        String json = """
            {
                "name": "Алексей",
                "age": 30,
                "city": "Москва",
                "skills": ["Java", "Spring", "SQL"]
            }
            """;
        System.out.println(json);

        System.out.println("\nПример 3: SQL запрос");
        String sql = """
            SELECT u.id, u.name, u.email
            FROM users u
            JOIN orders o ON u.id = o.user_id
            WHERE o.status = 'COMPLETED'
            ORDER BY o.created_at DESC
            LIMIT 10
            """;
        System.out.println(sql);

        System.out.println("\nПример 4: Форматирование внутри текстовых блоков");
        String name = "Алексей";
        int score = 95;
        String formatted = """
            Отчет по студенту:
            Имя: %s
            Баллы: %d
            Оценка: %s
            """.formatted(name, score, score >= 90 ? "Отлично" : "Хорошо");
        System.out.println(formatted);
    }
}

/*
Практика #3: Зачем нужны три двойные кавычки?

Тройные двойные кавычки (""" ... """) в Java, начиная с версии 15, 
используются для создания текстовых блоков (Text Blocks).

Зачем они нужны:

1. УЛУЧШЕНИЕ ЧИТАЕМОСТИ МНОГОСТРОЧНОГО ТЕКСТА:
   - Не нужно экранировать кавычки внутри текста
   - Сохраняется форматирование (отступы, переносы строк)
   - Идеально для HTML, XML, JSON, SQL запросов

2. УПРОЩЕНИЕ НАПИСАНИЯ КОДА:
   - Не нужна конкатенация строк через "+"
   - Не нужны escape-последовательности для переносов строк (\n)
   - Автоматическое удаление незначащих пробелов

3. ПОДДЕРЖКА ФОРМАТИРОВАНИЯ:
   - Можно использовать методы format() и formatted()
   - Поддерживаются все стандартные escape-последовательности
   - Сохраняет отступы относительно delimiter

4. ПРЕИМУЩЕСТВА ПЕРЕД ТРАДИЦИОННЫМ ПОДХОДОМ:
   - Меньше ошибок при наборе
   - Лучше воспринимается визуально
   - Проще редактировать многострочный текст

5. КОМПИЛЯЦИОННАЯ ЭФФЕКТИВНОСТЬ:
   - Текстовые блоки обрабатываются на этапе компиляции
   - Не создают дополнительных объектов во время выполнения

Важные особенности:
- Текстовые блоки начинаются с """ и сразу после них идет новая строка
- Закрывающие """ должны быть на отдельной строке
- Отступы определяются относительно закрывающих кавычек
- Пробелы в конце строк удаляются автоматически
*/