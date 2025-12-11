public class Task5 {
    public static void main(String[] args) {
        // Практика #1: Примеры использования операторов

        // Базовые типы
        int a = 10;
        int b = 3;

        // = и += и -= и *= и /= и %=
        a += 5;      // a = 15
        a -= 2;      // a = 13
        a *= 2;      // a = 26
        a /= 4;      // a = 6
        a %= 4;      // a = 2

        // ?: (тернарный)
        int max = (a > b) ? a : b; // max = 3

        // || (логическое ИЛИ)
        boolean or = (a == 2) || (b == 3); // true

        // && (логическое И)
        boolean and = (a > 0) && (b < 5); // true

        // | (побитовое ИЛИ)
        int bitOr = a | b; // 2 | 3 = 3

        // ^ (побитовое исключающее ИЛИ)
        int bitXor = a ^ b; // 2 ^ 3 = 1

        // & (побитовое И)
        int bitAnd = a & b; // 2 & 3 = 2

        // == и !=
        boolean eq = (a == 2);     // true
        boolean neq = (b != 3);    // false

        // > и >= и < и <=
        boolean gt = a > b;        // false
        boolean ge = a >= 2;       // true
        boolean lt = b < a;        // false
        boolean le = b <= 3;       // true

        // >> и >>> и <<
        int shiftRight = 8 >> 1;   // 4
        int shiftUnsigned = -8 >>> 1; // большое положительное число
        int shiftLeft = 2 << 2;    // 8

        // + и -
        int sum = a + b;           // 5
        int diff = b - a;          // 1

        // * и / и %
        int mult = a * b;          // 6
        int div = b / a;           // 1
        int mod = b % a;           // 1

        // ++ и -- (префиксная и постфиксная)
        int x = 5;
        int prefixInc = ++x;       // x=6, prefixInc=6
        int postfixInc = x++;      // x=7, postfixInc=6
        int prefixDec = --x;       // x=6, prefixDec=6
        int postfixDec = x--;      // x=5, postfixDec=6

        // ~ и !
        int bitNot = ~a;           // инверсия битов
        boolean logicNot = !true;  // false

        // Строки
        String s1 = "Hello";
        String s2 = "World";
        String concat = s1 + " " + s2; // "Hello World"
        s1 += "!";                     // "Hello!"

        // Практика #2: Оператор instanceof
        Object obj1 = "String";
        Object obj2 = new Integer(10);
        Object obj3 = null;

        boolean check1 = obj1 instanceof String;      // true
        boolean check2 = obj1 instanceof Object;      // true
        boolean check3 = obj2 instanceof Number;      // true
        boolean check4 = obj2 instanceof Integer;     // true
        boolean check5 = obj2 instanceof String;      // false

        // Случай с null-объектом
        boolean checkNull = obj3 instanceof String;   // false
        boolean checkNull2 = obj3 instanceof Object;  // false

        System.out.println("Проверка instanceof с null всегда возвращает false");
    }
}