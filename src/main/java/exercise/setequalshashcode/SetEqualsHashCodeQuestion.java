package exercise.setequalshashcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static utils.Utils.println;

/**
 * Что выведет код?
 * Что нужно добавить, чтобы код работал корректно?
 */
public class SetEqualsHashCodeQuestion {

    public static void main(String[] args) {
        Set<Element<Integer>> set = new HashSet<>();
        set.add(new Element<>(1));
        set.add(new Element<>(1));
        set.add(new Element<>(2));
        set.add(new Element<>(3));

        println(set.size());
        println(set.contains(new Element<>(2)));
    }

    private static class Element<T> {

        private final T value;

        public Element(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Element
                    && Objects.equals(value, ((Element<?>) obj).value);
        }

    }

}
