package datastructures.stack;

public interface MyStack<T> extends Iterable<T> {

    void push(T data);

    T pop();

    boolean isEmpty();

}
