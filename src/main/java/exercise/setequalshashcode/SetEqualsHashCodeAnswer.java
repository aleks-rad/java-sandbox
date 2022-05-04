package exercise.setequalshashcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static utils.Utils.println;

/**
 * Необходимо было переопределить метод hashCode(), т.к. HashSet использует 2 метода (equals и hashCode)
 * при вставке и поиске элементов.
 */
public class SetEqualsHashCodeAnswer {

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

        @Override
        public int hashCode(){
            return value.hashCode();
        }

    }

}
