public class Task25 {
    public static void main(String[] args) {
        // Практика #1: Переопределение метода equals()
        System.out.println("=== Практика #1 ===");

        Person25 person1 = new Person25("Иван", "Иванов", 30);
        Person25 person2 = new Person25("Иван", "Иванов", 30);
        Person25 person3 = new Person25("Петр", "Петров", 25);
        Person25 person4 = null;
        String notAPerson = "Не человек";

        System.out.println("person1.equals(person2): " + person1.equals(person2));
        System.out.println("person1.equals(person3): " + person1.equals(person3));
        System.out.println("person1.equals(person4): " + person1.equals(person4));
        System.out.println("person1.equals(notAPerson): " + person1.equals(notAPerson));
        System.out.println("person1.equals(person1): " + person1.equals(person1));

        // Проверка hashCode()
        System.out.println("\nХэш-коды:");
        System.out.println("person1.hashCode(): " + person1.hashCode());
        System.out.println("person2.hashCode(): " + person2.hashCode());
        System.out.println("person3.hashCode(): " + person3.hashCode());

        // Проверка toString()
        System.out.println("\ntoString():");
        System.out.println(person1);
    }
}

// Практика #1: Класс с переопределенным методом equals()
class Person25 {
    private String firstName;
    private String lastName;
    private int age;

    public Person25(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        /*
        Соглашения, которым должна следовать реализация equals():

        1. Рефлексивность: объект должен быть равен самому себе
           x.equals(x) всегда true

        2. Симметричность: если x.equals(y) true, то y.equals(x) тоже true

        3. Транзитивность: если x.equals(y) true и y.equals(z) true,
           то x.equals(z) тоже true

        4. Постоянство: повторные вызовы x.equals(y) должны возвращать
           одинаковый результат, пока объекты не изменяются

        5. Для любого ненулевого x: x.equals(null) должно возвращать false

        6. Согласованность с hashCode(): если x.equals(y) true,
           то x.hashCode() == y.hashCode()
        */

        // 1. Проверка: объект равен самому себе
        if (this == obj) {
            return true;
        }

        // 5. Проверка: сравнение с null всегда false
        if (obj == null) {
            return false;
        }

        // Проверка: объекты должны быть одного класса
        // Используем getClass() вместо instanceof для строгой проверки
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        // Приведение типа
        Person25 other = (Person25) obj;

        // Сравнение полей
        // Для строк используем equals(), для примитивов ==
        if (age != other.age) {
            return false;
        }

        // Безопасное сравнение строк с учетом возможного null
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }

        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        /*
        Соглашения для hashCode():
        1. Консистентность: повторные вызовы hashCode() должны возвращать
           одинаковое значение для неизмененного объекта

        2. Если x.equals(y) true, то x.hashCode() == y.hashCode()

        3. Обратное не обязательно: одинаковые hashCode не гарантируют equals()
        */

        final int prime = 31; // Простое число для вычисления хэша
        int result = 1;

        result = prime * result + age;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return "Person25[firstName=" + firstName +
                ", lastName=" + lastName +
                ", age=" + age + "]";
    }

    // Геттеры
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}