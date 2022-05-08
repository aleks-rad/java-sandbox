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

        int[] ints1 = app.generateInts(30);
        println("BUBBLE SORT:");
        println(Arrays.toString(ints1));
        app.bubbleSort(ints1);
        println(Arrays.toString(ints1));

        int[] ints2 = app.generateInts(30);
        println("INSERTION SORT:");
        println(Arrays.toString(ints2));
        app.insertionSort(ints2);
        println(Arrays.toString(ints2));

        int[] ints3 = app.generateInts(30);
        println("SELECTION SORT:");
        println(Arrays.toString(ints3));
        app.selectionSort(ints3);
        println(Arrays.toString(ints3));
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

    /**
     * Сортировка методом вставки
     */
    public void insertionSort(int[] arr) {
        for(int out = 1; out < arr.length; out++){
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp){
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }

    /**
     * Сортировка методом выбора
     */
    public void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            int indMin = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[indMin]){
                    indMin = j;
                }
            }
            swap(arr, i, indMin);
        }
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
