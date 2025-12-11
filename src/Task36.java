public class Task36 {
    public static void main(String[] args) {
        System.out.println("=== Практика #1: Обработка нескольких исключений ===\n");

        System.out.println("1. Несколько исключений обрабатываются идентично:");
        try {
            processData(null);
        } catch (NullPointerException | IllegalArgumentException e) {
            // Обработка двух разных исключений одинаковым способом
            System.out.println("   Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
            System.out.println("   Действие: логируем и продолжаем работу\n");
        }

        System.out.println("2. Иерархия исключений (Ex1 <|-- Ex2 <|-- Ex3):");
        try {
            generateExceptionFromHierarchy();
        } catch (ExceptionLevel1 e) {
            System.out.println("   Поймано ExceptionLevel1: " + e.getMessage());
        }

        System.out.println("\n3. Разный порядок catch блоков с иерархией:");
        try {
            // Генерируем исключение самого нижнего уровня
            throw new ExceptionLevel3("Исключение уровня 3");
        } catch (ExceptionLevel3 e) {
            System.out.println("   Поймано ExceptionLevel3: " + e.getMessage());
        } catch (ExceptionLevel2 e) {
            System.out.println("   Поймано ExceptionLevel2: " + e.getMessage());
        } catch (ExceptionLevel1 e) {
            System.out.println("   Поймано ExceptionLevel1: " + e.getMessage());
        }

        System.out.println("\n4. Обратный порядок (неправильный) - ошибка компиляции:");
        System.out.println("   /*");
        System.out.println("   try {");
        System.out.println("       throw new ExceptionLevel3();");
        System.out.println("   } catch (ExceptionLevel1 e) { // Первым ловим родителя");
        System.out.println("       // Этот блок перехватит ВСЕ исключения");
        System.out.println("   } catch (ExceptionLevel3 e) { // Этот блок НИКОГДА не выполнится");
        System.out.println("       // Ошибка компиляции: unreachable catch block");
        System.out.println("   }");
        System.out.println("   */");
    }

    // Практика #1: Метод для демонстрации одинаковой обработки
    public static void processData(String data) {
        if (data == null) {
            throw new NullPointerException("Данные не могут быть null");
        }
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Данные не могут быть пустыми");
        }
        System.out.println("   Обработка данных: " + data);
    }

    // Метод для демонстрации иерархии исключений
    public static void generateExceptionFromHierarchy() {
        double random = Math.random();
        if (random < 0.33) {
            throw new ExceptionLevel1("Уровень 1");
        } else if (random < 0.66) {
            throw new ExceptionLevel2("Уровень 2");
        } else {
            throw new ExceptionLevel3("Уровень 3");
        }
    }

    // Практика #2: Использование final в catch
    /*
    try {
       ...
    } catch (final Exception e) {
       ...
    }
    
    Что означает final в объявлении catch?
    
    1. ПЕРЕМЕННАЯ e СТАНОВИТСЯ НЕИЗМЕНЯЕМОЙ (final):
       - Нельзя присвоить новое значение: e = new Exception(); // Ошибка компиляции
       - Нельзя изменить ссылку на другой объект
    
    2. ПРЕИМУЩЕСТВА:
       - Защита от случайного изменения переменной исключения
       - Улучшение читаемости кода (ясно, что переменная не изменяется)
       - Потокобезопасность в многопоточных сценариях
       - Оптимизация компилятором
    
    3. ПРИМЕР С ИСПОЛЬЗОВАНИЕМ:
       try {
           riskyOperation();
       } catch (final IOException e) {
           // e нельзя изменить
           log.error("Ошибка ввода-вывода", e);
           // e = new IOException(); // ОШИБКА КОМПИЛЯЦИИ
       }
    
    4. КОГДА ИСПОЛЬЗОВАТЬ:
       - Всегда, если не планируете переназначать переменную
       - Особенно полезно в анонимных классах и лямбда-выражениях
       - Для явного указания на неизменяемость
    
    5. ВАЖНО:
       - final относится только к ссылке, а не к объекту
       - Объект исключения всё ещё можно модифицировать через методы
       - Не влияет на перехватываемые типы исключений
    */
}

// Иерархия исключений для демонстрации
class ExceptionLevel1 extends RuntimeException {
    public ExceptionLevel1(String message) {
        super(message);
    }
}

class ExceptionLevel2 extends ExceptionLevel1 {
    public ExceptionLevel2(String message) {
        super(message);
    }
}

class ExceptionLevel3 extends ExceptionLevel2 {
    public ExceptionLevel3(String message) {
        super(message);
    }
}

/*
ДОПОЛНИТЕЛЬНЫЕ ПРИМЕЧАНИЯ:

1. Множественные исключения в одном catch (Java 7+):
   - catch (IOException | SQLException e) - корректно
   - catch (FileNotFoundException | IOException e) - ОШИБКА (иерархия)
   
2. Порядок catch блоков:
   - Сначала ловить самые конкретные исключения
   - Потом более общие
   - Иначе блоки станут недостижимыми
   
3. Оператор | в catch:
   - Объединяет независимые типы исключений
   - Переменная e имеет тип общего предка
   - Нельзя объединять исключения в иерархии
*/