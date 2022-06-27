package exercise.construction;

import static utils.Utils.println;

/**
 * Не вызывайте в конструкторе полиморфные методы!
 */
public class PolymorphismWithConstructApp {

    static class Parent {
        void foo() {
            println("Parent.foo()");
        }

        Parent() {
            println("Parent() before foo()");
            this.foo();
            foo();
            println("Parent() after foo()");
        }
    }

    static class Child extends Parent {
        private Object field = new Object();

        Child() {
            println("Child() | field = " + field);
        }

        void foo() {
            println("Child.foo | field = " + field);
        }
    }

    public static void main(String[] args) {
        new Child();
    }

}
