

public class Task3 {

    // Практика #1: Примеры для всех типов данных, включая нулевые значения
    byte byteVar = 0;           // нулевое значение для byte
    short shortVar = 0;         // нулевое значение для short
    int intVar = 0;             // нулевое значение для int
    long longVar = 0L;          // нулевое значение для long
    float floatVar = 0.0f;      // нулевое значение для float
    double doubleVar = 0.0;     // нулевое значение для double
    char charVar = '\u0000';    // нулевое значение для char (null-символ)
    boolean boolVar = false;    // нулевое значение для boolean

    // Практика #2: Печать имени в формате Unicode
    public static void printNameInUnicode() {
        // Имя "Alex" в Unicode
        System.out.println("\u0041\u006C\u0065\u0078"); // Alex
    }

    public static void main(String[] args) {
        // Вызов метода для практики #2
        printNameInUnicode();

        // Практика #3: Какой будет результат?
        int a = 1;
        {
            int b = 2;
            // Переменная b видна только внутри этого блока
        }
        // int c = a + b; // ОШИБКА КОМПИЛЯЦИИ: переменная b не видна за пределами блока {}
        // Ответ: Код не скомпилируется, так как переменная b объявлена внутри блока {} и её область действия ограничена этим блоком.

        // Практика #4: Пример использования перегруженного оператора +
        String str = "Hello";
        int num = 123;
        double d = 45.67;
        Object obj = new Object();
        String result = str + " " + num + " " + d + " " + obj;
        System.out.println(result); // Hello 123 45.67 java.lang.Object@...

        // Практика #5: Арифметические операции с переменными различных типов
        int intVal = 10;
        double doubleVal = 3.5;
        double result1 = intVal + doubleVal; // int расширяется до double, результат double (13.5)
        long longVal = 100L;
        float floatVal = 2.5f;
        float result2 = longVal + floatVal;  // long расширяется до float, результат float (102.5)
        System.out.println("Результат 1 (int + double): " + result1);
        System.out.println("Результат 2 (long + float): " + result2);

        // Практика #6: Примеры сужающего преобразования типов
        int bigInt = 300;
        byte smallByte = (byte) bigInt; // явное приведение, возможна потеря данных (300 > 127)
        System.out.println("Сужение int 300 до byte: " + smallByte); // 44 (потеря старших битов)

        double bigDouble = 123.456;
        int intFromDouble = (int) bigDouble; // дробная часть отбрасывается
        System.out.println("Сужение double 123.456 до int: " + intFromDouble); // 123

        // Практика #7: Что будет в переменных b, c и d?
        int a2 = 120;
        // byte b2 = a2 + 10; // ОШИБКА КОМПИЛЯЦИИ: результат выражения a2+10 - это int, требуется явное приведение
        byte c2 = (byte)(a2 + 10); // Явное приведение: (byte)130 = -126 (переполнение byte)
        // byte d2 = a2 + 1; // ОШИБКА КОМПИЛЯЦИИ: аналогично первой строке, результат выражения - int
        // Ответ: b - ошибка компиляции, c = -126, d - ошибка компиляции
        System.out.println("Результат (byte)(120 + 10): " + c2);

        // Практика #8: Type inference с var (доступно с Java 10)
        var message = "Hello, Java!"; // компилятор выводит тип String
        var number = 42;              // компилятор выводит тип int
        var list = new java.util.ArrayList<String>(); // компилятор выводит тип ArrayList<String>
        System.out.println("var примеры: " + message + ", " + number + ", " + list.getClass());
    }
}