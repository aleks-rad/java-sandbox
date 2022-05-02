package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

    public static void println(Object msg){
        System.out.println(msg);
    }

    public static void println(String msg, Object... objects){
        System.out.printf(msg + "%n", objects);
    }

}
