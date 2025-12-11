public class Task13 {
    public static void main(String[] args) {
        // Практика #1: Варианты вызова static метода printVars()

        // 1. Через имя класса
        A13.printVars();

        // 2. Через экземпляр класса
        A13 obj1 = new A13();
        obj1.printVars();

        // 3. Вложенный вызов через другой static метод того же класса
        // (если бы был такой метод в классе A)

        // 4. Из другого static метода (как здесь в main)

        // 5. Из non-static метода через имя класса или экземпляр
        new Task13().callFromNonStatic();
    }

    void callFromNonStatic() {
        A13.printVars();        // через класс
        A13 obj = new A13();
        obj.printVars();      // через экземпляр
    }
}

class A13 {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
}