package datastructures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStackImpl<T> implements MyStack<T> {

    private int size;
    private Node<T> top;

    @Override
    public void push(T data){
        if(top == null)
            top = new Node<T>(data, null);
        else {
            Node<T> temp = top;
            top = new Node<T>(data, temp);
        }
        size++;
    }

    @Override
    public T pop(){
        if(top == null) throw new NoSuchElementException();

        Node<T> result = top;
        top = result.ref;
        size--;

        return result.data;
    }

    @Override
    public boolean isEmpty(){
        return size <= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public T next() {
                return pop();
            }
        };
    }

    private static class Node<T>{
        private final T data;
        private final Node<T> ref;

        Node(T data, Node<T> ref){
            this.data = data;
            this.ref = ref;
        }
    }

}
