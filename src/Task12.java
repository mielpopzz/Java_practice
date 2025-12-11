public class Task12 {
    public static void main(String[] args) {
        // Пример перегрузки
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 3));        // 8
        System.out.println(calc.add(5.5, 3.3));    // 8.8
        System.out.println(calc.add("Hello", " World")); // Hello World

        // Пример переопределения
        Animal animal = new Animal();
        animal.makeSound(); // Some sound

        Dog dog = new Dog();
        dog.makeSound();    // Bark
    }
}

// Пример перегрузки методов
class Calculator {
    // Перегрузка по типу параметров
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    String add(String a, String b) {
        return a + b;
    }

    // Перегрузка по количеству параметров
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

// Пример переопределения методов
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}