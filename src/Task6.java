public class Task6 {
    public static void main(String[] args) {
        // Практика #1: метод decode()
        Integer hex = Integer.decode("0xFF");     // 255
        Integer oct = Integer.decode("012");      // 10
        Integer dec = Integer.decode("42");       // 42
        Integer neg = Integer.decode("-0x10");    // -16

        System.out.println("decode 0xFF = " + hex);
        System.out.println("decode 012 = " + oct);
        System.out.println("decode 42 = " + dec);
        System.out.println("decode -0x10 = " + neg);

        // Практика #2: способы создания Boolean
        Boolean b1 = Boolean.valueOf(true);
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = Boolean.valueOf("TRUE");
        Boolean b4 = Boolean.valueOf("false");
        Boolean b5 = new Boolean(true);      // конструктор (устаревший)
        Boolean b6 = Boolean.TRUE;           // константа

        // Практика #3: NullPointerException при автораспаковке
        Integer nullInt = null;
        try {
            // int value = nullInt; // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException при автораспаковке null Integer");
        }

        // Практика #4: вывод кода
        int i1 = 128;
        Integer a1 = i1;
        Integer b1num = i1;
        System.out.println("a1==i1 " + (a1 == i1));              // true (автораспаковка)
        System.out.println("b1==i1 " + (b1num == i1));           // true (автораспаковка)
        System.out.println("a1==b1 " + (a1 == b1num));           // false (разные объекты)
        System.out.println("a1.equals(i1) -> " + a1.equals(i1)); // true
        System.out.println("b1.equals(i1) -> " + b1num.equals(i1)); // true
        System.out.println("a1.equals(b1) -> " + a1.equals(b1num)); // true

        int i2 = 127;
        Integer a2 = i2;
        Integer b2num = i2;
        System.out.println("a2==i2 " + (a2 == i2));              // true (автораспаковка)
        System.out.println("b2==i2 " + (b2num == i2));           // true (автораспаковка)
        System.out.println("a2==b2 " + (a2 == b2num));           // true (кеширование)
        System.out.println("a2.equals(i2) -> " + a2.equals(i2)); // true
        System.out.println("b2.equals(i2) -> " + b2num.equals(i2)); // true
        System.out.println("a2.equals(b2) -> " + a2.equals(b2num)); // true

        // Объяснение: IntegerCache кеширует значения от -128 до 127.
        // Для 127 возвращается один и тот же объект (== дает true).
        // Для 128 создаются разные объекты (== дает false).
    }
}