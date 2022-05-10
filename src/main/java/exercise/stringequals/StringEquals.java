package exercise.stringequals;

import static utils.Utils.println;

/**
 * Интересные особенности при применении == (вместо equals) (не делай так, разумеется :)) при сравнении строк.
 */
public class StringEquals {

    public static void main(String[] args) {
        String str1 = "word";
        String str2 = "word";
        String str3 = str1;

        // true
        println("\"word\" == \"word\" ? " + ("word" == "word"));

        // ссылка str1 указывает на тот же объект, так что true
        println("str1 == \"word\" ? " + (str1 == "word"));

        // true
        println("str1 == str1 ? " + (str1 == str1));

        // true
        println("str1 == str2 ? " + (str1 == str2));

        // true
        println("str3 == str2 ? " + (str3 == str2));

        // расчитанная подстрока "word" не равна объекту "word" - false
        println("\"It's word\".substring(5) == \"word\" ? " + ("It's word".substring(5) == "word"));

        // разумеется нужно сравнивать через equals любые ссылочные переменные и объекты
        println("\"word\".equals(str1) ? " + "word".equals(str1));
    }

}
