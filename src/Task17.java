public class Task17 {
    public static void main(String[] args) {
        // Практика #1: instanceof с generic-классами
        Wrapper<String> stringWrapper = new Wrapper<>("Hello");
        Wrapper<Integer> intWrapper = new Wrapper<>(42);

        System.out.println(stringWrapper instanceof Wrapper<?>); // true
        System.out.println(stringWrapper instanceof Wrapper);    // true (raw type)
        // System.out.println(stringWrapper instanceof Wrapper<String>); // ОШИБКА компиляции

        // Проверка содержимого через getItem()
        if (stringWrapper.getItem() instanceof String) {
            System.out.println("Содержимое - String");
        }

        // Практика #2: <? extends T> и <? super T>
        Box<Number> numberBox = new Box<>();
        Box<Integer> integerBox = new Box<>();

        // <? extends Number> - можно читать как Number
        copyFromBox(integerBox, numberBox);

        // <? super Integer> - можно записывать Integer
        copyToBox(numberBox, integerBox);
    }

    // Пример использования <? extends T>
    static void copyFromBox(Box<? extends Number> source, Box<Number> dest) {
        // Можно читать из source как Number
        Number num = source.getItem();
        dest.setItem(num);
        System.out.println("Скопировано из <? extends Number>: " + num);
    }

    // Пример использования <? super T>
    static void copyToBox(Box<? super Integer> dest, Box<Integer> source) {
        // Можно записывать Integer в dest
        Integer value = source.getItem();
        dest.setItem(value);
        System.out.println("Скопировано в <? super Integer>: " + value);
    }
}

// Generic-класс для примеров
class Wrapper<T> {
    private T item;

    public Wrapper(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

// Дополнительный generic-класс для практики #2
class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

/*
Объяснение <? extends T> и <? super T>:

1. <? extends T> (producer - производитель):
   - Можно безопасно ЧИТАТЬ элементы как тип T
   - Нельзя ЗАПИСЫВАТЬ (кроме null)
   - Используется, когда нужно получить данные из контейнера
   - Пример: List<? extends Number> может содержать Integer, Double и т.д.

2. <? super T> (consumer - потребитель):
   - Можно безопасно ЗАПИСЫВАТЬ элементы типа T (или его подтипов)
   - Можно читать, но только как Object
   - Используется, когда нужно добавить данные в контейнер
   - Пример: List<? super Integer> может быть List<Integer>, List<Number>, List<Object>

Принцип PECS (Producer Extends, Consumer Super):
- Если нужны данные ИЗ контейнера (производитель) -> используем ? extends
- Если нужно положить данные В контейнер (потребитель) -> используем ? super
*/