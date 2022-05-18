package exercise.generics;

import static utils.Utils.println;

/**
 * У дженерика можно установить ограничение типа
 */
public class GenericRestrictionApp {

    public static void main(String[] args) {
        methodWithoutRestrictions(new A());
        methodWithoutRestrictions(new B());
        methodWithoutRestrictions("string");
        methodWithoutRestrictions(new Object());

        println("");

        methodWithExtendsA(new A());
        methodWithExtendsA(new B());
        //methodWithExtendsA("string"); // нельзя!
        //methodWithExtendsA(new Object()); // нельзя!

        println("");

        new C<A>();
        new C<B>();
        //new C<String>(); // нельзя!
    }

    private static <T> void methodWithoutRestrictions(T arg) {
        println("methodWithoutRestrictions(): " + arg);
    }

    private static <T extends A> void methodWithExtendsA(T arg){
        println("methodWithExtendsA(): " + arg);
    }

    static class A {}

    static class B extends A {}

    static class C<T extends A> {}

}
