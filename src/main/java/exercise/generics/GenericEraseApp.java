package exercise.generics;

/**
 * Что не так с закоменченным классом?
 */
public class GenericEraseApp {

    public static void main(String[] args) {

    }

    //В этом классе 2 перегруженных метода
    static class D {
        public void eval(String arg) {}

        public void eval(Integer arg) {}
    }

    /**
     * Компиллятор создает 2 мостовых метода (для поддержания полиморфизма):
     * public void eval(Object arg) {}
     * которые и вступают в конфликт
     */
    /*static class A implements B<String>, C<Integer> {
        @Override
        public void eval(String arg) {}

        @Override
        public void eval(Integer arg) {}
    }*/

    interface B<T> {
        void eval(T arg);
    }

    interface C<T> {
        void eval(T arg);
    }

}
