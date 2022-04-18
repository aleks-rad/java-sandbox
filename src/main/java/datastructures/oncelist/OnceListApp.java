package datastructures.oncelist;

import static utils.Utils.println;

public class OnceListApp {

    public static void main(String[] args) {
        OnceList<Integer> onceList = new OnceList<>();

        onceList.addFirst(1);
        onceList.addFirst(2);
        onceList.addFirst(3);
        onceList.addLast(4);
        onceList.addLast(5);
        onceList.addFirst(6);

        println(onceList); //ожидание: 6 3 2 1 4 5
    }

}
