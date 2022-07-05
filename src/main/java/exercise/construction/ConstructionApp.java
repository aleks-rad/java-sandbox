package exercise.construction;

import static utils.Utils.println;

/**
 * Порядок инициализации при наследовании
 * 1. Статические члены при загрузке класса (рекурсивно все классы из цепочки наследования, начиная с самого базового)
 * 2. Нестатические члены базового класса
 * 3. Конструктор базового класса
 * 4. Нестатические члены дочернего класса
 * 5. Конструктор дочернего класса
 */
public class ConstructionApp {

    static class Shape {
        private static final int size = printWithInit();

        Shape() {
            println("Shape()");
        }

        private static int printWithInit() {
            println("Shape.printWithInit()");
            return 42;
        }
    }

    static class Circle extends Shape {
        Circle() {
            println("Circle()");
        }
    }

    static class Square extends Shape {
        Square() {
            println("Square()");
        }
    }

    static class Triangle extends Shape {
        Triangle() {
            println("Triangle()");
        }
    }

    static class ColorCircle extends Circle {
        private Square square = new Square();
        private static Triangle triangle = new Triangle();

        ColorCircle() {
            println("ColorCircle()");
        }
    }

    public static void main(String[] args) {
        new ColorCircle();
    }

}
