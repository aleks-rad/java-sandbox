package exercise.arrayandlistcast;

import java.util.List;

/**
 * Приведение типов в массивах и списках
 */
public class ArrayAndListCastApp {

    public static void main(String[] args) {
        Object[] arrObj = {new Object()};
        A[] arrA = {new A(), new B()};
        B[] arrB = {new B()}; // нельзя добавить new A()
        arrA = arrB; // можно, массив ковариантны
        arrObj = arrA;

        List<Object> listObj = List.of(new Object());
        List<A> listA = List.of(new A(), new B());
        List<B> listB = List.of(new B()); // нельзя добавить new A()
        //listA = listB; // нельзя, коллекции инвариантны
    }

    static class A {}

    static class B extends A {}

}
