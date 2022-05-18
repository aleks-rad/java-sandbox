package exercise.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Дженерики инвариантны
 */
public class GenericsAreInvarianceApp {

    public static void main(String[] args) {
        List<A> listA = getListA();
    }

    private static List<A> getListA() {
        List<A> aList = new ArrayList<>();
        aList.add(new A());
        aList.add(new B());

        List<B> bList = new ArrayList<>();
        bList.add(new B());

        //aList = bList; // так нельзя! List<A> и List<B> разные типы

        //return bList; // так тоже нельзя!
        //return (List<A>) bList; // так тоже нельзя!

        return aList;
    }

    static class A {}

    static class B extends A {}

}
