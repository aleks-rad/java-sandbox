package exercise.outofmemory;

import java.util.LinkedList;
import java.util.List;

import static utils.Utils.println;

/**
 * Как получить ошибку OutOfMemoryError и можно ли ее перехватить?
 */
class OutOfMemoryErrorApp {

    public static void main(String[] args) {
        List<BigObject> objects = new LinkedList<>();

        while (true) {
            try {
                println("freeMemory = " + Runtime.getRuntime().freeMemory());
                objects.add(new BigObject());
            } catch (OutOfMemoryError oom) {
                oom.printStackTrace();
                return;
            }
        }
    }

    private static class BigObject {
        private final byte[] data = new byte[10000000];
    }

}
