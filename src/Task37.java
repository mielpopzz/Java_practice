public class Task37 {
    public static void main(String[] args) {
        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Возраст: " + e.getInvalidAge());
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Возраст не может быть отрицательным", age);
        }
        System.out.println("Возраст корректен: " + age);
    }
}

// Практика #1: Собственный класс исключения
class InvalidAgeException extends Exception {
    private final int invalidAge;

    // Конструктор 1: только сообщение
    public InvalidAgeException(String message) {
        super(message);
        this.invalidAge = -1;
    }

    // Конструктор 2: сообщение и причина
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
        this.invalidAge = -1;
    }

    // Конструктор 3: сообщение и некорректный возраст
    public InvalidAgeException(String message, int invalidAge) {
        super(message);
        this.invalidAge = invalidAge;
    }

    public int getInvalidAge() {
        return invalidAge;
    }
}