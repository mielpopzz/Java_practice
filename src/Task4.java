/**
 * Класс для демонстрации работы с Javadoc комментариями.
 * Содержит примеры использования различных дескрипторов.
 *
 * @author Gorbachev
 * @version 1.0
 * @since 2025
 */
public class Task4 {

    /**
     * Константа класса - значение числа Пи.
     * Используется для математических расчетов.
     */
    public static final double PI = 3.14159;

    private String name;

    /**
     * Конструктор класса Task4.
     * Инициализирует объект с заданным именем.
     *
     * @param name имя для инициализации
     */
    public Task4(String name) {
        this.name = name;
    }

    /**
     * Вычисляет площадь круга по заданному радиусу.
     *
     * @param radius радиус круга (должен быть положительным)
     * @return площадь круга
     * @throws IllegalArgumentException если радиус отрицательный
     */
    public double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        return PI * radius * radius;
    }

    /**
     * Возвращает приветствие с именем пользователя.
     *
     * @return строку приветствия
     * @see #setName(String)
     * @deprecated Используйте {@link #getFormattedGreeting()} вместо этого метода
     */
    @Deprecated
    public String getGreeting() {
        return "Hello, " + name + "!";
    }

    /**
     * Возвращает форматированное приветствие с именем пользователя.
     *
     * @return форматированную строку приветствия
     * @since 1.1
     */
    public String getFormattedGreeting() {
        return "Добро пожаловать, " + name + "!";
    }

    /**
     * Устанавливает новое имя пользователя.
     *
     * @param name новое имя (не должно быть null или пустым)
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    /**
     * Точка входа в программу.
     * Демонстрирует работу класса JavadocPractice.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Task4 example = new Task4("Алексей");
        System.out.println(example.getFormattedGreeting());

        double area = example.calculateCircleArea(5.0);
        System.out.println("Площадь круга с радиусом 5: " + area);

        // Пример использования устаревшего метода
        System.out.println("Устаревший метод: " + example.getGreeting());
    }
}