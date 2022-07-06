package exercise.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.Utils.println;

public class MaskRegExpApp {

    private static final String MASK = "$1******$3";
    private static final Pattern PATTERN = Pattern.compile("([0-9]{6})([0-9]{6})([0-9]{4})");

    public static void main(String[] args) {
        String accountNumberMasked = mask("4545320101012345");
        println("accountNumberMasked = " + accountNumberMasked);
    }

    private static String mask(String accountNumber) {
        println("accountNumber = " + accountNumber);

        Matcher matcher = PATTERN.matcher(accountNumber);
        if (matcher.find()) {
            return matcher.replaceAll(MASK);
        }
        println("Маскирование не выполнено. Данные не соответствуют шаблону.");

        return accountNumber;
    }

}
