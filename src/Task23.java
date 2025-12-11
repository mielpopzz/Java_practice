public class Task23 {
    public static void main(String[] args) {
        // Практика #1: Демонстрация перегруженных методов
        System.out.println("=== Практика #1 ===");
        Calculator23 calc = new Calculator23();

        System.out.println("calc.add(5, 3) = " + calc.add(5, 3));
        System.out.println("calc.add(2.5, 3.7) = " + calc.add(2.5, 3.7));
        System.out.println("calc.add(1, 2, 3) = " + calc.add(1, 2, 3));
        System.out.println("calc.add(\"Hello\", \" World\") = " + calc.add("Hello", " World"));

        // Практика #2: Демонстрация переопределенного метода
        System.out.println("\n=== Практика #2 ===");
        Animal23 animal = new Animal23();
        Animal23 dog = new Dog23();
        Animal23 cat = new Cat23();

        animal.makeSound();
        dog.makeSound();    // Полиморфизм: вызовется метод из Dog23
        cat.makeSound();    // Полиморфизм: вызовется метод из Cat23

        // Практика #3: Пример использования @Override
        System.out.println("\n=== Практика #3 ===");
        Parent23 parent = new Parent23();
        Child23 child = new Child23();

        parent.display();
        child.display();

        // Пример ошибки, которую помогает обнаружить @Override
        System.out.println("\nПример ошибки с @Override:");
        Parent23 obj = new ChildWithError23();
        // obj.showErrorExample(); // Этот метод не будет работать, если раскомментировать
    }
}

// Практика #1: Пример перегруженных методов (overloading)
class Calculator23 {
    // Перегрузка метода add с разными параметрами

    // 1. Метод для сложения двух целых чисел
    public int add(int a, int b) {
        System.out.println("Вызван add(int, int)");
        return a + b;
    }

    // 2. Метод для сложения трех целых чисел
    public int add(int a, int b, int c) {
        System.out.println("Вызван add(int, int, int)");
        return a + b + c;
    }

    // 3. Метод для сложения двух чисел с плавающей точкой
    public double add(double a, double b) {
        System.out.println("Вызван add(double, double)");
        return a + b;
    }

    // 4. Метод для конкатенации строк
    public String add(String a, String b) {
        System.out.println("Вызван add(String, String)");
        return a + b;
    }

    // 5. Метод с другим порядком параметров (тоже перегрузка)
    public String add(String a, int b) {
        System.out.println("Вызван add(String, int)");
        return a + b;
    }
}

// Практика #2: Пример переопределенного метода (overriding)
class Animal23 {
    public void makeSound() {
        System.out.println("Животное издает звук");
    }

    // Метод с возвращаемым значением
    public String getSpecies() {
        return "Неизвестный вид";
    }
}

class Dog23 extends Animal23 {
    // Переопределение метода makeSound()
    @Override
    public void makeSound() {
        System.out.println("Собака лает: Гав-гав!");
    }

    // Переопределение метода с возвращаемым значением
    @Override
    public String getSpecies() {
        return "Собака";
    }
}

class Cat23 extends Animal23 {
    // Переопределение метода makeSound()
    @Override
    public void makeSound() {
        System.out.println("Кошка мяукает: Мяу-мяу!");
    }
}

/*
Ответ на вопрос из Практики #2:
Если у переопределенного и переопределяемого методов не будет совпадать 
тип возвращаемого значения, это приведет к ошибке компиляции.

Пример ошибки:

class Parent {
    public String getInfo() {
        return "Parent";
    }
}

class Child extends Parent {
    @Override
    public int getInfo() {  // ОШИБКА КОМПИЛЯЦИИ!
        return 42;          // Тип возвращаемого значения должен быть String
    }
}

В Java переопределяемый метод должен иметь:
1. Такой же тип возвращаемого значения (или подтип - ковариантный возвращаемый тип)
2. Такую же сигнатуру (имя и параметры)
3. Модификатор доступа не более строгий, чем у родительского метода
*/

// Практика #3: Пример использования аннотации @Override
class Parent23 {
    public void display() {
        System.out.println("Метод display() класса Parent23");
    }

    public void showMessage(String message) {
        System.out.println("Сообщение: " + message);
    }
}

class Child23 extends Parent23 {
    // Правильное переопределение метода с аннотацией @Override
    @Override
    public void display() {
        System.out.println("Метод display() класса Child23 (переопределен)");
    }

    // Аннотация @Override помогает обнаружить ошибки
    // Например, если мы допустим опечатку в имени метода:

    // @Override
    // public void displa() {  // ОШИБКА: метод displa() не существует в Parent23
    //     System.out.println("Опечатка в имени метода");
    // }

    // Или ошибку в параметрах:

    // @Override
    // public void showMessage() {  // ОШИБКА: отсутствует параметр String
    //     System.out.println("Неправильная сигнатура метода");
    // }
}

// Пример класса с ошибкой, которую помогает обнаружить @Override
class ChildWithError23 extends Parent23 {
    // Без @Override эта ошибка может остаться незамеченной
    // Мы думаем, что переопределяем метод, но допускаем опечатку
    public void displa() {  // ОШИБКА: должно быть display()
        System.out.println("Мы думаем, что переопределили display()");
    }

    // С @Override компилятор сразу укажет на ошибку:
    /*
    @Override
    public void displa() {  // КОМПИЛЯТОР: ОШИБКА! Метод displa() не найден в Parent23
        System.out.println("Ошибка будет обнаружена на этапе компиляции");
    }
    */
}

/*
Объяснение для Практики #3:

Аннотация @Override помогает обнаружить ошибки на этапе компиляции:

1. Опечатки в имени метода:
   Если вы пытаетесь переопределить метод, но допускаете опечатку в его имени,
   компилятор выдаст ошибку, сообщив, что метод с таким именем не существует
   в суперклассе.

2. Несовпадение сигнатур:
   Если параметры метода не совпадают с параметрами метода в суперклассе,
   компилятор сообщит об ошибке.

3. Случайное переопределение:
   Показывает, что метод специально переопределяется, что делает код более
   читаемым и понятным для других разработчиков.

Рекомендуется всегда использовать @Override при переопределении методов,
чтобы избежать трудноуловимых ошибок.
*/