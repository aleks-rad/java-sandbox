package exercise.variableoverflow;

import static utils.Utils.println;

/**
 * Почему происходит переполнение переменной, к чему это может привести и что можно с этим поделать?
 */
public class VariableOverflowQuestion {

    public static void main(String[] args) {
        int n = 1_000_000_000 * 3;

        println("n = " + n);
    }

}
