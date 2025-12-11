public class Task15 {
    public static void main(String[] args) {
        new A15(100);
    }
}

class A15 {
    {
        System.out.println("logic (1) id= " + this.id);
        // id еще не инициализирован (0)
    }

    static {
        System.out.println("static logic");
        // выполняется первым, один раз при загрузке класса
    }

    private int id = 1;
    // инициализация поля (выполняется после первого блока)

    public A15(int id) {
        this.id = id;
        System.out.println("ctor id= " + id);
        // выполняется последним
    }

    {
        System.out.println("logic (2) id= " + id);
        // id уже инициализирован (1)
    }
}

/*
Вывод программы:
static logic      - static блок выполняется первым при загрузке класса
logic (1) id= 0   - первый логический блок, id еще 0 (значение по умолчанию)
logic (2) id= 1   - второй логический блок, id уже 1 (после инициализации)
ctor id= 100      - конструктор, устанавливает id=100

Порядок выполнения:
1. static блок (при первой загрузке класса)
2. Логические блоки в порядке объявления
3. Инициализация полей (между логическими блоками)
4. Конструктор
*/