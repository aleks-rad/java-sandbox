package exercise.maxlengthstring;

import static utils.Utils.println;

/**
 * Напишите метод для поиска самой длинной строки в массиве
 */
public class MaxLengthStringApp {

    public static void main(String[] args) {
        String[] strings = {
                "Foo", "Bo", "Aaaaaa", "Brrrr", "Fafafafafaf", "Grrrrrrrrrrrrrrrrr", "Nanan"
        };

        println("Самая длинная строка: " + findMaxLengthString(strings));
    }

    private static String findMaxLengthString(String[] strings) {
        String result = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() > result.length()){
                result = strings[i];
            }
        }
        return result;
    }

}
