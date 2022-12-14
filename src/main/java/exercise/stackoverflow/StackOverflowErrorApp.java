package exercise.stackoverflow;

/**
 * Как получить StackOverflowError?
 */
public class StackOverflowErrorApp {

    public static void main(String[] args) {
        recursionFunc();
    }

    public static void recursionFunc() {
        recursionFunc();
    }

}
