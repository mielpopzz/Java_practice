// Файл 1: Task11/AccessDemo.java
package Task11;

public class AccessDemo {
    public int publicField;
    int defaultField;
    protected int protectedField;
    private int privateField;

    public void publicMethod() {
        System.out.println("public method");
    }

    void defaultMethod() {
        System.out.println("default method");
    }

    protected void protectedMethod() {
        System.out.println("protected method");
    }

    private void privateMethod() {
        System.out.println("private method");
    }
}