package exercise.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static utils.Utils.println;

/**
 * При помощи метасимволов подстановки (wild cards) можно обойти ограничение дженериков
 * на предмет инвариантности. Данный механизм еще называется используемая по месту вариантность.
 */
public class GenericWildCardApp {

    public static void main(String[] args) {
        List<? extends A> listA = getListA();

        Predicate<A> predicateA = Objects::nonNull; // можно использовать любой
        Predicate<B> predicateB = Objects::nonNull; // из этих предикатов
        Predicate<Object> predicateObj = Objects::nonNull; // благодаря wild card <? super B>
        printWithPredicate(List.of(new B(), new B()), predicateObj);
    }

    private static List<? extends A> getListA() {
        //return new ArrayList<String>(); // нельзя!
        //return new ArrayList<Object>(); // нельзя!
        //return new ArrayList<A>(List.of(new A(), new B())); // можно
        return new ArrayList<B>(List.of(new B(), new B())); // можно
    }

    private static void printWithPredicate(List<B> list, Predicate<? super B> predicate) {
        for (B b : list) {
            if (predicate.test(b)){
                println(b);
            }
        }
    }

    static class A {
    }

    static class B extends A {
    }

}
