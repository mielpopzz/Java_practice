public class Task22 {
    public static void main(String[] args) {
        // Практика #1: Демонстрация всех вариантов использования super
        System.out.println("=== Практика #1 ===");
        Child22 child = new Child22(42, "Test");
        child.display();
        child.callParentMethod();

        System.out.println("\n=== Практика #2 ===");
        C22 c = new C22();
        c.method();

        System.out.println("\n=== Практика #3 ===");
        A22 obj1 = new A22();
        System.out.println("obj1: a=" + obj1.a + ", b=" + obj1.b + ", c=" + obj1.c + ", z=" + obj1.z);

        A22 obj2 = new A22(10);
        System.out.println("obj2: a=" + obj2.a + ", b=" + obj2.b + ", c=" + obj2.c + ", z=" + obj2.z);

        A22 obj3 = new A22(10, 20);
        System.out.println("obj3: a=" + obj3.a + ", b=" + obj3.b + ", c=" + obj3.c + ", z=" + obj3.z);

        A22 obj4 = new A22(10, 20, 30);
        System.out.println("obj4: a=" + obj4.a + ", b=" + obj4.b + ", c=" + obj4.c + ", z=" + obj4.z);
    }
}

// Практика #1: Примеры использования ключевого слова super
class Parent22 {
    protected int value;
    protected String name;

    // Конструктор родительского класса
    public Parent22(int value, String name) {
        this.value = value;
        this.name = name;
        System.out.println("Конструктор Parent22 вызван с value=" + value + ", name=" + name);
    }

    // Метод родительского класса
    public void showInfo() {
        System.out.println("Parent22: value=" + value + ", name=" + name);
    }
}

class Child22 extends Parent22 {
    private int childValue;

    // 1. Использование super для вызова конструктора суперкласса
    public Child22(int value, String name) {
        super(value, name); // вызов конструктора родительского класса
        this.childValue = value * 2;
    }

    public void display() {
        // 2. Использование super для доступа к полю суперкласса
        System.out.println("Доступ к полю суперкласса: super.value = " + super.value);
        System.out.println("Поле текущего класса: this.childValue = " + this.childValue);
    }

    public void callParentMethod() {
        // 3. Использование super для доступа к методу суперкласса
        System.out.println("Вызов метода суперкласса:");
        super.showInfo();
    }
}

// Практика #2: Цепочка наследования
class A22_1 {
    int a = 100;

    void method() {
        System.out.println("Метод из класса A22_1, значение a = " + a);
    }
}

class B22 extends A22_1 {
    // Класс B22 наследует переменную a и метод method() от A22_1
    // но сам их не переопределяет
}

class C22 extends B22 {
    void method() {
        // super.a обращается к переменной a из класса A22_1
        // так как в B22 эта переменная не определена
        int a = super.a; // доступ к полю суперкласса (A22_1)
        System.out.println("C22: получено значение a из A22_1 через super.a = " + a);

        // super.method() вызывает метод из класса A22_1
        // так как в B22 этот метод не переопределен
        super.method(); // доступ к методу суперкласса (A22_1)
        System.out.println("C22: вызван метод method() из A22_1 через super.method()");
    }
}

// Практика #3: Переписывание кода с использованием this()
class A22 {
    int a;
    int b;
    int c;
    int z;

    // Конструктор по умолчанию
    public A22() {
        this(0, 0, 0); // вызов конструктора с тремя параметрами
    }

    // Конструктор с одним параметром
    public A22(int a) {
        this(a, 0, 0); // вызов конструктора с тремя параметрами
    }

    // Конструктор с двумя параметрами
    public A22(int a, int b) {
        this(a, b, 0); // вызов конструктора с тремя параметрами
    }

    // Основной конструктор с тремя параметрами
    public A22(int a, int b, int c) {
        // Вызов this() должен быть первым оператором
        // Но здесь мы в основном конструкторе, поэтому просто инициализируем поля
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = 1; // общая инициализация для всех конструкторов
    }
}

/*
Ответ на вопрос из Практики #2:
При вызове метода method() объекта класса C22:
1. int a = super.a; - будет получено значение переменной a из класса A22_1,
   так как в цепочке наследования C → B → A, и переменная a определена в A,
   но не переопределена в B.
2. super.method(); - будет вызван метод method() из класса A22_1,
   так как в цепочке наследования метод не переопределен в классе B.
   
Ключевое слово super в данном контексте обращается к ближайшему предку в
цепочке наследования, у которого есть указанный член (поле или метод).
В данном случае это будет класс A22_1.
*/