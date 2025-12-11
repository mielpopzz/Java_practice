public class Task8 {
    public static void main(String[] args) {
        // Практика #1: Типы переменных в switch

        // byte
        byte byteVal = 1;
        switch(byteVal) {
            case 1: System.out.println("byte 1"); break;
        }

        // short
        short shortVal = 2;
        switch(shortVal) {
            case 2: System.out.println("short 2"); break;
        }

        // int
        int intVal = 3;
        switch(intVal) {
            case 3: System.out.println("int 3"); break;
        }

        // char
        char charVal = 'A';
        switch(charVal) {
            case 'A': System.out.println("char A"); break;
        }

        // String (с Java 7)
        String strVal = "test";
        switch(strVal) {
            case "test": System.out.println("String test"); break;
        }

        // enum
        Color color = Color.RED;
        switch(color) {
            case RED: System.out.println("enum RED"); break;
        }

        // wrapper classes (автораспаковка)
        Integer integerVal = 5;
        switch(integerVal) {
            case 5: System.out.println("Integer 5"); break;
        }

        // Практика #2: Отсутствие break
        int value = 2;
        int i = 0;

        switch(value) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;  // нет break - выполнение продолжится
            case 3:
                i = 3;  // выполнится для case 2 и case 3
                break;
        }

        System.out.println("При value=2, i=" + i + " (ожидается 3)");
    }

    enum Color {
        RED, GREEN, BLUE
    }
}