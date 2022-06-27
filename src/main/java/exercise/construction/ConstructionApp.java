package exercise.construction;

import static utils.Utils.println;

/**
 * Порядок инициализации при наследовании
 * 1. Статические члены (при загрузке класса)
 * 2. Рекурсивный вызов конструкторов всех дочерних классов (начиная с самого базового)
 * 3. Нестатические члены класса
 * 4. Конструктор самого класса
 */
public class ConstructionApp {

    static class Shape {
        Shape() {
            println("Shape()");
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
