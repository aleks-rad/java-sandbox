package exercise.conflictinterfaces;

import static utils.Utils.println;

/**
 * Как разрулить конфликты двух default методов интерфейсов
 */
public class ConflictInterfacesApp {

    public static void main(String[] args) {
        new C().method();
    }

    static class C implements A, B {
        /* Необходимо переопределить конфиликтующий метод выбрав одну из дефолтных реализаций */
        @Override
        public void method() {
            B.super.method(); // В данном случае выбрал реализацию из B, но можно и из A
        }
    }

    interface A {
        default void method(){
            println("A.method()");
        }

        /*void method(); // даже если в одном из методов будет абстрактный метод*/
    }

    interface B {
        default void method(){
            println("B.method()");
        }
    }

}
