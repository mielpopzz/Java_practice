public class Task9 {
    public static void main(String[] args) {
        // Практика #1: Бесконечные циклы

        // while
        while (true) {
            // бесконечный цикл
            break; // только для демонстрации, чтобы не зависнуть
        }

        // do-while
        do {
            // бесконечный цикл
            break; // только для демонстрации
        } while (true);

        // Практика #2: break и continue
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue; // пропускаем итерацию при i=5
            }
            if (i == 8) {
                break; // выходим из цикла при i=8
            }
            System.out.println(i);
        }
    }
}