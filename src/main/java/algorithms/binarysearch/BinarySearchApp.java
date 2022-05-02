package algorithms.binarysearch;

import java.util.Random;
import java.util.stream.Stream;

import static utils.Utils.println;

/**
 * Алгоритм двоичного поиска (актуально только для упорядоченного массива данных)
 */
public class BinarySearchApp {

    public static void main(String[] args){
        Random random = new Random();
        Integer[] data = Stream.generate(() -> random.nextInt(1000))
                .filter(i -> i > 0)
                .distinct()
                .limit(100)
                .sorted()
                .toArray(Integer[]::new);

        int searchValue = data[21];
        println("searchValue = " + searchValue);

        int result = binarySearch(data, searchValue);
        println("result = " + result);
    }

    private static int binarySearch(Integer[] arr, int searchValue){
        int stepCount = 0;
        int leftBound = 0;
        int rightBound = arr.length - 1;
        int cursor;

        while (leftBound <= rightBound){
            cursor = (rightBound - leftBound) / 2 + leftBound;

            println("[searchValue = %d] STEP_%d: cursor = %d, leftBound = %d, rightBound = %d\n",
                    searchValue, ++stepCount, cursor, leftBound, rightBound);

            if(arr[cursor] == searchValue){
                return arr[cursor];
            }

            if(arr[cursor] < searchValue){
                leftBound = cursor + 1;
            } else {
                rightBound = cursor - 1;
            }
        }

        return -1;
    }

}
