public class Task19 {
    public static void main(String[] args) {
        // Практика #1: Инициализация элементов перечисления
        System.out.println("Размеры одежды:");
        for (ClothingSize size : ClothingSize.values()) {
            System.out.println(size + " - " + size.getDescription());
        }

        // Практика #2: Перечисление с дополнительным методом
        System.out.println("\nДни недели:");
        for (Day day : Day.values()) {
            System.out.println(day + " - " + day.getRussianName() +
                    ", рабочий: " + day.isWorkingDay());
        }

        // Использование перечисления
        Day today = Day.MONDAY;
        System.out.println("\nСегодня: " + today.getRussianName());
        System.out.println("Завтра: " + today.nextDay().getRussianName());
    }
}

// Практика #1: Перечисление с инициализацией
enum ClothingSize {
    SMALL("Маленький размер"),  // инициализация
    MEDIUM("Средний размер"),    // инициализация
    LARGE("Большой размер"),     // инициализация
    XL("Очень большой размер");  // инициализация

    private final String description;

    // Конструктор
    ClothingSize(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

// Практика #2: Перечисление с дополнительным методом
enum Day {
    MONDAY("Понедельник", true),
    TUESDAY("Вторник", true),
    WEDNESDAY("Среда", true),
    THURSDAY("Четверг", true),
    FRIDAY("Пятница", true),
    SATURDAY("Суббота", false),
    SUNDAY("Воскресенье", false);

    private final String russianName;
    private final boolean workingDay;

    // Конструктор
    Day(String russianName, boolean workingDay) {
        this.russianName = russianName;
        this.workingDay = workingDay;
    }

    // Дополнительный метод
    public String getRussianName() {
        return russianName;
    }

    public boolean isWorkingDay() {
        return workingDay;
    }

    // Еще один метод
    public Day nextDay() {
        Day[] days = values();
        return days[(this.ordinal() + 1) % days.length];
    }
}