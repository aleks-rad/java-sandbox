package exercise.exceptionexample;

import java.io.FileNotFoundException;
import java.util.Objects;

import static utils.Utils.println;

/**
 * Примеры обработки исключений
 */
public class ExceptionExampleApp {

    public static void main(String[] args) {
        //beforeThenNPEAndFailMainThread();
        //ifStackTraceHandleSuccess();
        //missingExceptionWithBadHandle();
        //exceptionInOtherThreadSuccessMainThread();
        exceptionCustomHandler();
    }

    private static void beforeThenNPEAndFailMainThread() {
        println("Before exception"); // выполняется

        Objects.requireNonNull(null); // на этом текущий thread завершает свою работу

        println("After exception"); // не выполняется
    }

    private static void ifStackTraceHandleSuccess() {
        println("Before exception"); // выполняется

        try {
            throw new FileNotFoundException();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        println("After exception"); // выполняется
    }

    private static void missingExceptionWithBadHandle() {
        println("Before exception"); // выполняется

        try {
            throw new NullPointerException();
        } catch (Exception ex) {
            // просто проглатили исключение, пример худшей обработки
        }

        println("After exception"); // выполняется
    }

    private static void exceptionInOtherThreadSuccessMainThread() {
        println("Before exception"); // выполняется

        Thread otherThread = new Thread(() -> {
            throw new NullPointerException();
        });
        otherThread.start();

        try {
            otherThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("After exception"); // выполняется
    }

    private static void exceptionCustomHandler() {
        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> {
            println("Обработчик неперехваченных исключений"); // исключения не проглатываются, thread заваливается
            // т.е. этот обработчик не заменяет собой полностью стандартный механизм обработки, а дополняет его
        });
        println("Before exception"); // выполняется

        Objects.requireNonNull(null);

        println("After exception"); // не выполняется
    }

}