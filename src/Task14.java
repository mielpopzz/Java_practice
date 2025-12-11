public class Task14 {
    public static void main(String[] args) {
        // Практика #1: Варианты инициализации final поля

        // 1. Инициализация при объявлении
        A1 obj1 = new A1();

        // 2. Инициализация в конструкторе
        A2 obj2 = new A2(10);

        // 3. Инициализация в блоке инициализации
        A3 obj3 = new A3();

        System.out.println("obj1.a = " + obj1.a);
        System.out.println("obj2.a = " + obj2.a);
        System.out.println("obj3.a = " + obj3.a);
    }
}

// Вариант 1: При объявлении
class A1 {
    public final int a = 5;
}

// Вариант 2: В конструкторе
class A2 {
    public final int a;
    public A2(int value) {
        a = value;
    }
}

// Вариант 3: В блоке инициализации
class A3 {
    public final int a;
    {
        a = 15; // блок инициализации
    }
}