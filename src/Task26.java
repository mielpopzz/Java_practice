public class Task26 {
    public static void main(String[] args) {
        System.out.println("=== Практика #1 ===");
        OuterClass26 outer = new OuterClass26();
        outer.testInnerClasses();

        System.out.println("\n=== Практика #2 и #3 ===");
        OuterClass26_2 outer2 = new OuterClass26_2();
        OuterClass26_2.AccessExample accessExample = outer2.new AccessExample();
        accessExample.testAccess();
    }
}

// Практика #1: Спецификаторы доступа для внутренних классов
class OuterClass26 {
    // 1. Public внутренний класс - доступен везде
    public class PublicInnerClass {
        public void display() {
            System.out.println("PublicInnerClass: доступен из любого места");
        }
    }

    // 2. Protected внутренний класс - доступен в пакете и наследниках
    protected class ProtectedInnerClass {
        public void display() {
            System.out.println("ProtectedInnerClass: доступен в пакете и наследниках");
        }
    }

    // 3. Package-private (default) внутренний класс - доступен только в пакете
    class PackagePrivateInnerClass {
        public void display() {
            System.out.println("PackagePrivateInnerClass: доступен только в пакете");
        }
    }

    // 4. Private внутренний класс - доступен только во внешнем классе
    private class PrivateInnerClass {
        public void display() {
            System.out.println("PrivateInnerClass: доступен только во внешнем классе");
        }
    }

    public void testInnerClasses() {
        // Все внутренние классы доступны внутри внешнего класса
        PublicInnerClass publicInner = new PublicInnerClass();
        ProtectedInnerClass protectedInner = new ProtectedInnerClass();
        PackagePrivateInnerClass packageInner = new PackagePrivateInnerClass();
        PrivateInnerClass privateInner = new PrivateInnerClass();

        publicInner.display();
        protectedInner.display();
        packageInner.display();
        privateInner.display();

        System.out.println("\nСоздание из другого класса (в том же пакете):");
        // В другом классе того же пакета доступны public, protected и package-private
        // PrivateInnerClass недоступен
    }
}

// Практика #2 и #3: Доступ между внешним и внутренним классами
class OuterClass26_2 {
    // Поля внешнего класса с разными модификаторами доступа
    private String privateField = "private поле внешнего";
    protected String protectedField = "protected поле внешнего";
    String packageField = "package поле внешнего";
    public String publicField = "public поле внешнего";

    private void privateOuterMethod() {
        System.out.println("private метод внешнего класса");
    }

    protected void protectedOuterMethod() {
        System.out.println("protected метод внешнего класса");
    }

    void packageOuterMethod() {
        System.out.println("package метод внешнего класса");
    }

    public void publicOuterMethod() {
        System.out.println("public метод внешнего класса");
    }

    // Внутренний класс для демонстрации доступа
    public class AccessExample {
        // Поля внутреннего класса
        private String innerPrivate = "private поле внутреннего";
        protected String innerProtected = "protected поле внутреннего";
        String innerPackage = "package поле внутреннего";
        public String innerPublic = "public поле внутреннего";

        public void testAccess() {
            System.out.println("=== Практика #2: Внутренний → Внешний ===");
            System.out.println("Внутренний класс имеет полный доступ к внешнему:");

            // Внутренний класс имеет доступ ко ВСЕМ полям и методам внешнего класса
            // независимо от модификаторов доступа!
            System.out.println("privateField: " + privateField);
            System.out.println("protectedField: " + protectedField);
            System.out.println("packageField: " + packageField);
            System.out.println("publicField: " + publicField);

            privateOuterMethod();
            protectedOuterMethod();
            packageOuterMethod();
            publicOuterMethod();

            // Доступ через неявную ссылку OuterClass26_2.this
            System.out.println("\nДоступ через OuterClass26_2.this:");
            System.out.println("OuterClass26_2.this.privateField: " +
                    OuterClass26_2.this.privateField);

            System.out.println("\n=== Практика #3: Внешний → Внутренний ===");
            System.out.println("Внешний класс имеет доступ в соответствии с модификаторами:");

            // Создаем экземпляр внутреннего класса внутри внешнего
            AccessExample inner = new AccessExample();

            // Доступ из внешнего класса к внутреннему:
            // - К public: полный доступ
            System.out.println("inner.innerPublic: " + inner.innerPublic);

            // - К protected: доступен в том же пакете и наследниках
            System.out.println("inner.innerProtected: " + inner.innerProtected);

            // - К package-private: доступен в том же пакете
            System.out.println("inner.innerPackage: " + inner.innerPackage);

            // - К private: НЕ доступен (ошибка компиляции)
            // System.out.println("inner.innerPrivate: " + inner.innerPrivate);
        }

        public void showImplicitReference() {
            // Каждый объект внутреннего класса имеет неявную ссылку
            // на создавший его объект внешнего класса
            System.out.println("\nНеявная ссылка на внешний класс:");
            System.out.println("this: " + this);
            System.out.println("OuterClass26_2.this: " + OuterClass26_2.this);
        }
    }

    // Метод внешнего класса для демонстрации доступа к внутреннему
    public void outerAccessingInner() {
        System.out.println("\nДоступ из метода внешнего класса:");

        // Создаем объект внутреннего класса
        AccessExample inner = new AccessExample();

        // Доступ к полям внутреннего класса зависит от модификаторов
        System.out.println("public: " + inner.innerPublic);  // Доступно
        System.out.println("protected: " + inner.innerProtected);  // Доступно (в одном классе)
        System.out.println("package: " + inner.innerPackage);  // Доступно (в одном классе)
        // System.out.println("private: " + inner.innerPrivate);  // Ошибка компиляции
    }
}
/*
Ответы на вопросы:

Практика #1:
Спецификаторы доступа для внутренних классов работают так же, как и для обычных классов:
- public: доступен из любого места
- protected: доступен в пакете и наследниках
- package-private (default): доступен только в пакете
- private: доступен только во внешнем классе

Практика #2:
Внутренний класс имеет ПОЛНЫЙ доступ ко всем полям и методам внешнего класса,
включая private. Это одна из ключевых особенностей внутренних классов.
Доступ осуществляется через неявную ссылку на внешний объект.

Практика #3:
Внешний класс имеет доступ к полям и методам внутреннего класса в соответствии
с обычными правилами модификаторов доступа (public, protected, package, private).
Для доступа нужно создать экземпляр внутреннего класса.
*/
