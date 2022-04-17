package datastructures.stack;

import utils.Utils;

public class StackApp {

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStackImpl<>();

        myStack.push("first");
        myStack.push("second");
        myStack.push("third");

        myStack.forEach(Utils::println);
    }

}
