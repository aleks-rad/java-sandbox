package exercise.inverseprimitive;

import static utils.Utils.println;

/**
 * Перевернуть число, перевернуть строку
 */
public class InversePrimitiveApp {

    public static void main(String[] args) {
        println(inverseInt(123456789));
        println(inverseStr("dlrow olleh"));
    }

    private static int inverseInt(int number){
        String result = "";

        while (number > 0){
            result += (number % 10); // тут бы конечно StringBuilder, ну да ладно
            number /= 10;
        }

        return Integer.parseInt(result);
    }

    private static String inverseStr(String str){
        char[] chars = str.toCharArray();

        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[(len - 1) - i];
            chars[(len - 1) - i] = temp;
        }

        return String.valueOf(chars);
    }

}
