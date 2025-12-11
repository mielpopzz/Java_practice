import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task41 {
    public static void main(String[] args) {
        // Практика #1: Чтение данных из текстового файла с помощью Scanner
        try {
            File file = new File("data.txt");
            Scanner fileScanner = new Scanner(file);

            System.out.println("Чтение файла построчно:");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }
}