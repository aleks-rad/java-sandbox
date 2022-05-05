package algorithms.simplesort;

import java.util.Arrays;
import java.util.stream.Stream;

import static utils.Utils.println;

/**
 * Алгоритмы простой сортировки
 */
public class SimpleSortApp {

    public static void main(String[] args) {
        SimpleSortApp app = new SimpleSortApp();

        int[] ints = app.generateInts(30);

        println(Arrays.toString(ints));
        app.bubbleSort(ints);
        println(Arrays.toString(ints));
    }

    /**
     * Знаменитая пузырьковая сортировка
     */
    public void bubbleSort(int[] arr){
        int iterationsCount = 0;
        int swapCount = 0;
        for(int out = arr.length - 1; out > 1; out--){
            boolean isSwapped = false;
            for(int in = 0; in < out; in++){
                iterationsCount++;
                if(arr[in] > arr[in + 1]){
                    swapCount++;
                    isSwapped = true;
                    this.swap(arr, in, in + 1);
                }
            }
            if(!isSwapped) break;
        }
        println("iterationsCount = " + iterationsCount);
        println("swapCount = " + swapCount);
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    private int[] generateInts(int size){
        return Stream.generate(Math::random)
                .mapToInt(r -> (int) (r * 100))
                .limit(size)
                .toArray();
    }

}
