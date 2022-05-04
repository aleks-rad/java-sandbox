package exercise.inheritancefields;

import static utils.Utils.println;

/**
 * Что выведет данный код?
 * Вот только не надо про полиморфизм ;)
 */
public class InheritanceFieldsQuestion {

    public static void main(String[] args) {
        println("new A().data = " + new A().data);
        println("new B().data = " + new B().data);
        println("((A) new B()).data = " + ((A) new B()).data);
    }

    private static class A {
        public int data = 1;
    }

    private static class B extends A {
        public int data = 2;
    }

}
