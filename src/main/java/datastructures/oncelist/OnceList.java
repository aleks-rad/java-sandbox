package datastructures.oncelist;

import java.util.NoSuchElementException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Реализация односвязного двустороннего списка
 */
public class OnceList<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    /**
     * Вставка элемента в начало списка
     */
    public void addFirst(T data) {
        if (isNull(first)) {
            first = new Node<>(data, null);
            last = first;
        } else {
            first = new Node<>(data, first);
        }
        size++;
    }

    /**
     * Вставка элемента в конец списка
     */
    public void addLast(T data) {
        if (isNull(last)) {
            last = new Node<>(data, null);
            first = last;
        } else {
            last.next = new Node<>(data, null);
            last = last.next;
        }
        size++;
    }

    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();

        int count = 0;
        Node<T> cursor = first;
        while (count <= index) {
            if (count == index) return cursor.data;
            cursor = cursor.next;
            count++;
        }

        return null;
    }

    public T removeFirst(){
        if (size <= 0) throw new NoSuchElementException();

        Node<T> result = first;
        first = first.next;
        size--;

        return result.data;
    }

    public T remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            return removeFirst();
        }

        int count = 1;
        Node<T> cursorPrev = first;
        Node<T> cursor = first.next;

        while (count <= index) {
            if (count == index) {
                cursorPrev.next = cursor.next;
                if (count == size - 1) last = cursorPrev;
                size--;
                return cursor.data;
            }
            cursorPrev = cursor;
            cursor = cursor.next;
            count++;
        }

        return null;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        Node<T> cursor = first;
        while (nonNull(cursor)){
            result.append("cursor.data = ");
            result.append(cursor.data);
            result.append(", cursor.next = ");
            result.append(cursor.next);
            result.append("\n");
            cursor = cursor.next;
        }

        return result.toString();
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

}
