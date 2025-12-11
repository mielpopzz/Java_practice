public class Task21 {
    public static void main(String[] args) {
        // Практика #1: Невозможность переопределения final-метода
        Parent21 parent = new Parent21();
        parent.display(); // Вызов метода Parent

        Child21 child = new Child21();
        child.display(); // Вызов метода Child (НЕ переопределенный)
        child.callParentDisplay(); // Вызов final метода Parent из Child
    }
}

// Практика #1: Класс с final методом
class Parent21 {
    // final метод - нельзя переопределить
    public final void finalMethod() {
        System.out.println("Это final метод класса Parent");
    }

    // обычный метод
    public void display() {
        System.out.println("Метод display класса Parent");
    }
}

class Child21 extends Parent21 {
    // ОШИБКА КОМПИЛЯЦИИ при раскомментировании:
    // @Override
    // public void finalMethod() {
    //     System.out.println("Попытка переопределить final метод");
    // }

    // Можно переопределить обычный метод
    @Override
    public void display() {
        System.out.println("Метод display класса Child");
    }

    // Можно вызывать final метод родителя
    public void callParentDisplay() {
        super.finalMethod(); // Вызов final метода родителя
    }
}

// Практика #2: final класс
final class FinalClass {
    public void show() {
        System.out.println("Это final класс");
    }
}

// ОШИБКА КОМПИЛЯЦИИ при раскомментировании:
// class TryingToExtend extends FinalClass {
//     // Нельзя наследовать final класс
// }