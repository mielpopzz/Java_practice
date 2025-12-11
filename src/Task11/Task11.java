// Файл 2: Task11/Task11.java
package Task11;

public class Task11 {
    public static void main(String[] args) {
        AccessDemo demo = new AccessDemo();
        demo.publicField = 10;
        demo.publicMethod();
        demo.defaultField = 20;
        demo.defaultMethod();
        demo.protectedField = 30;
        demo.protectedMethod();
    }
}