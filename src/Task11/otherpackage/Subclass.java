// Файл 3: Task11/otherpackage/Subclass.java
package Task11.otherpackage;

import Task11.AccessDemo;

public class Subclass extends AccessDemo {
    public void test() {
        publicField = 1;    // public - доступно

        // defaultField = 2; // ОШИБКА КОМПИЛЯЦИИ: default недоступно (другой подпакет)

        protectedField = 3; // protected - доступно подклассу

        // privateField = 4; // ОШИБКА КОМПИЛЯЦИИ: private недоступно

        publicMethod();     // public - доступно

        // defaultMethod(); // ОШИБКА КОМПИЛЯЦИИ: default недоступно

        protectedMethod();  // protected - доступно подклассу

        // privateMethod(); // ОШИБКА КОМПИЛЯЦИИ: private недоступно
    }
}