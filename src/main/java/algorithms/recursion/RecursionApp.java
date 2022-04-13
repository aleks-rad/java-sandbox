package algorithms.recursion;


import static utils.Utils.println;

public class RecursionApp {

    public static void main(String[] args){
        var app = new RecursionApp();

        println("---triangle---");
        println(app.triangle(5));

        println("---factorial---");
        println(app.factorial(5));

        println("---fibo---");
        println(app.fibo(5));
    }

    /**
     * Метод вычисляет значение n-го числа в последовательности треугольных чисел
     */
    private int triangle(int n){
        println("call with n = " + n);
        if(n == 1) {
            println("return " + 1);
            return 1;
        }
        else {
            int temp = n + triangle(n - 1);
            println("return " + temp);
            return temp;
        }
    }

    /**
     * Метод вычисляет факториал n-го числа
     */
    private int factorial(int n){
        println("call with n = " + n);
        if(n == 0){
            println("return " + 1);
            return 1;
        } else{
            int temp = n * factorial(n - 1);
            println("return " + temp);
            return temp;
        }
    }

    /**
     * Метод вычисляет n-ое число из последовательности Фибоначчи
     */
    private int fibo(int n){
        println("call with n = " + n);
        if(n == 0 || n == 1){
            println("return " + 1);
            return 1;
        } else{
            int temp = fibo(n - 1) + fibo(n - 2);
            println("return " + temp);
            return temp;
        }
    }

}
