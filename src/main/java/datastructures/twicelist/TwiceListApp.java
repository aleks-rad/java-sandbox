package datastructures.twicelist;

import static utils.Utils.println;

public class TwiceListApp {

    public static void main(String[] args) {
        TwiceList<Integer> twiceList = new TwiceList<>();

        twiceList.addFirst(1);
        twiceList.addFirst(2);
        twiceList.addFirst(3);
        twiceList.addLast(4);
        twiceList.addLast(5);
        twiceList.addLast(6);

        println(twiceList); // [0] = 3, [1] = 2, [2] = 1, [3] = 4, [4] = 5, [5] = 6

        println(twiceList.get(2)); // 1
        println(twiceList.get(4)); // 5
    }

}
