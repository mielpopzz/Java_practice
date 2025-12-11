// Task32.java
public class Task32 {
    public static void main(String[] args) {
        System.out.println("=== Практика #1: Методы StringBuilder и StringBuffer ===\n");

        // Практика #1: Демонстрация методов
        demonstrateStringBuilderMethods();
        demonstrateStringBufferMethods();

        System.out.println("\n=== Практика #2: Преобразование между String, StringBuilder и StringBuffer ===\n");

        // Практика #2: Преобразование между типами
        demonstrateConversions();

        // Демонстрация потокобезопасности StringBuffer
        System.out.println("\n=== Дополнительно: Потокобезопасность StringBuffer ===\n");
        demonstrateThreadSafety();
    }

    // Практика #1: Методы StringBuilder
    public static void demonstrateStringBuilderMethods() {
        System.out.println("StringBuilder методы:");

        // 1. Конструкторы
        StringBuilder sb1 = new StringBuilder(); // Пустой с емкостью 16
        StringBuilder sb2 = new StringBuilder(20); // С указанной емкостью
        StringBuilder sb3 = new StringBuilder("Hello"); // С начальным значением

        // 2. append() - добавление в конец
        sb1.append("Java");
        System.out.println("1. append('Java'): " + sb1.toString());
        // Добавляет строку, число, char, boolean и т.д. в конец

        // 3. insert() - вставка в указанную позицию
        sb1.insert(2, "###");
        System.out.println("2. insert(2, '###'): " + sb1.toString());
        // Вставляет строку в указанный индекс

        // 4. delete() - удаление части строки
        sb1.delete(2, 5);
        System.out.println("3. delete(2, 5): " + sb1.toString());
        // Удаляет символы с startIndex до endIndex-1

        // 5. deleteCharAt() - удаление одного символа
        sb1.deleteCharAt(1);
        System.out.println("4. deleteCharAt(1): " + sb1.toString());
        // Удаляет символ по указанному индексу

        // 6. replace() - замена части строки
        sb3.replace(1, 4, "i");
        System.out.println("5. replace(1, 4, 'i'): " + sb3.toString());
        // Заменяет символы с start до end-1 на новую строку

        // 7. reverse() - переворачивает строку
        sb2.append("12345");
        sb2.reverse();
        System.out.println("6. reverse('12345'): " + sb2.toString());
        // Переворачивает порядок символов

        // 8. setCharAt() - замена одного символа
        StringBuilder sb4 = new StringBuilder("ABCDE");
        sb4.setCharAt(2, 'X');
        System.out.println("7. setCharAt(2, 'X'): " + sb4.toString());
        // Заменяет символ по указанному индексу

        // 9. length() и capacity()
        StringBuilder sb5 = new StringBuilder("Hello World");
        System.out.println("8. length(): " + sb5.length());
        System.out.println("   capacity(): " + sb5.capacity());
        // length() - текущая длина строки
        // capacity() - текущая емкость буфера

        // 10. ensureCapacity() и trimToSize()
        sb5.ensureCapacity(50); // Гарантирует минимальную емкость
        System.out.println("9. ensureCapacity(50): capacity = " + sb5.capacity());

        sb5.trimToSize(); // Уменьшает емкость до текущей длины
        System.out.println("10. trimToSize(): capacity = " + sb5.capacity());
        // trimToSize() уменьшает емкость до текущей длины

        // Дополнительные полезные методы
        System.out.println("\nДополнительные методы StringBuilder:");
        StringBuilder sb6 = new StringBuilder("Programming");

        // indexOf() и lastIndexOf()
        System.out.println("indexOf('gram'): " + sb6.indexOf("gram"));
        System.out.println("lastIndexOf('m'): " + sb6.lastIndexOf("m"));

        // substring()
        System.out.println("substring(3, 7): " + sb6.substring(3, 7));

        // charAt()
        System.out.println("charAt(5): " + sb6.charAt(5));
    }

    // Практика #1: Методы StringBuffer (аналогичны StringBuilder)
    public static void demonstrateStringBufferMethods() {
        System.out.println("\n\nStringBuffer методы (аналогичны StringBuilder):");

        StringBuffer buffer = new StringBuffer("Пример");

        // 1. append() с различными типами
        buffer.append(" StringBuffer");
        System.out.println("1. append(' StringBuffer'): " + buffer.toString());

        // 2. append() с числами
        buffer.append(" - номер: ").append(123);
        System.out.println("2. append(123): " + buffer.toString());

        // 3. insert() с различными типами
        buffer.insert(7, " мощного");
        System.out.println("3. insert(7, ' мощного'): " + buffer.toString());

        // 4. delete() и deleteCharAt()
        buffer.delete(15, 24);
        System.out.println("4. delete(15, 24): " + buffer.toString());

        // 5. replace()
        buffer.replace(0, 6, "Демо");
        System.out.println("5. replace(0, 6, 'Демо'): " + buffer.toString());

        // 6. reverse()
        StringBuffer reversed = new StringBuffer(buffer).reverse();
        System.out.println("6. reverse(): " + reversed.toString());

        // 7. setLength() - установка новой длины
        buffer.setLength(4);
        System.out.println("7. setLength(4): " + buffer.toString());
        // Если новая длина меньше текущей, строка обрезается
        // Если больше - дополняется null-символами

        // 8. setCharAt()
        buffer.setCharAt(0, 'Р');
        System.out.println("8. setCharAt(0, 'Р'): " + buffer.toString());

        // 9. getChars() - копирование в массив char
        char[] charArray = new char[buffer.length()];
        buffer.getChars(0, buffer.length(), charArray, 0);
        System.out.print("9. getChars(): ");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        // 10. capacity() и ensureCapacity()
        System.out.println("10. capacity(): " + buffer.capacity());
        buffer.ensureCapacity(100);
        System.out.println("   after ensureCapacity(100): " + buffer.capacity());
    }

    // Практика #2: Преобразование между типами
    public static void demonstrateConversions() {
        System.out.println("Преобразование между String, StringBuilder и StringBuffer:");

        // 1. String → StringBuilder
        String str = "Привет, мир!";
        System.out.println("\n1. String → StringBuilder:");
        System.out.println("   Исходная String: " + str);
        StringBuilder sbFromString = new StringBuilder(str);
        System.out.println("   StringBuilder: " + sbFromString.toString());

        // 2. String → StringBuffer
        StringBuffer sbufFromString = new StringBuffer(str);
        System.out.println("\n2. String → StringBuffer:");
        System.out.println("   StringBuffer: " + sbufFromString.toString());

        // 3. StringBuilder → String
        StringBuilder sb = new StringBuilder("StringBuilder текст");
        String strFromSB = sb.toString();
        System.out.println("\n3. StringBuilder → String:");
        System.out.println("   Исходный StringBuilder: " + sb.toString());
        System.out.println("   String: " + strFromSB);

        // 4. StringBuffer → String
        StringBuffer sbf = new StringBuffer("StringBuffer текст");
        String strFromSBF = sbf.toString();
        System.out.println("\n4. StringBuffer → String:");
        System.out.println("   Исходный StringBuffer: " + sbf.toString());
        System.out.println("   String: " + strFromSBF);

        // 5. StringBuilder → StringBuffer (через String)
        StringBuffer sbufFromSB = new StringBuffer(sb.toString());
        System.out.println("\n5. StringBuilder → StringBuffer:");
        System.out.println("   Результат: " + sbufFromSB.toString());

        // 6. StringBuffer → StringBuilder (через String)
        StringBuilder sbFromSBF = new StringBuilder(sbf.toString());
        System.out.println("\n6. StringBuffer → StringBuilder:");
        System.out.println("   Результат: " + sbFromSBF.toString());

        // 7. Дополнительные способы преобразования String
        char[] charArray = {'J', 'a', 'v', 'a'};
        String strFromCharArray = new String(charArray);
        System.out.println("\n7. char[] → String:");
        System.out.println("   Результат: " + strFromCharArray);

        // 8. StringBuilder из char[]
        StringBuilder sbFromCharArray = new StringBuilder();
        sbFromCharArray.append(charArray);
        System.out.println("\n8. char[] → StringBuilder:");
        System.out.println("   Результат: " + sbFromCharArray.toString());
    }

    // Демонстрация потокобезопасности StringBuffer
    public static void demonstrateThreadSafety() {
        System.out.println("Демонстрация потокобезопасности StringBuffer:");

        StringBuffer safeBuffer = new StringBuffer();
        StringBuilder unsafeBuilder = new StringBuilder();

        // Создаем два потока, которые будут модифицировать буферы
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeBuffer.append("A");
                unsafeBuilder.append("A");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeBuffer.append("B");
                unsafeBuilder.append("B");
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("StringBuffer (потокобезопасный) длина: " + safeBuffer.length());
        System.out.println("StringBuilder (не потокобезопасный) длина: " + unsafeBuilder.length());

        // Проверка корректности StringBuffer (должно быть 2000)
        int expectedLength = 2000;
        System.out.println("\nОжидаемая длина: " + expectedLength);
        System.out.println("StringBuffer корректный: " + (safeBuffer.length() == expectedLength));
        System.out.println("StringBuilder может быть некорректным из-за состояния гонки");

        // Проверка содержимого
        System.out.println("\nПервые 20 символов StringBuffer:");
        System.out.println(safeBuffer.substring(0, Math.min(20, safeBuffer.length())));

        System.out.println("Первые 20 символов StringBuilder:");
        System.out.println(unsafeBuilder.substring(0, Math.min(20, unsafeBuilder.length())));
    }
}