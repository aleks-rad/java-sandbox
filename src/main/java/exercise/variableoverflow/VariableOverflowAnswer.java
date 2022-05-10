package exercise.variableoverflow;

import static utils.Utils.println;

/**
 * Максимальное значение int = 2_147_483_647, если мы выходим за этот диапазон, явной ошибки не возникает,
 * значение расчитывается с конца диапазона (Integer.MIN_VALUE + величина переполнения). Чтобы избежать
 * непредвиденного значения можно воспользоваться Math.multiplyExact() и прочими методами бросающими исключения
 * в случае переполнения.
 */
public class VariableOverflowAnswer {

    public static void main(String[] args) {
        int n = Math.multiplyExact(1_000_000_000, 3);

        println("n = " + n);
    }

}
