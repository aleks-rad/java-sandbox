package datastructures.twicelist;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Двусвязный двусторонний список
 */
public class TwiceList<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    public void addFirst(T data) {
        if (isNull(first)) {
            first = new Node<>(data, null, null);
            last = first;
        } else {
            Node<T> newNode = new Node<>(data, first, null);
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        if (isNull(last)) {
            last = new Node<>(data, null, null);
            first = last;
        } else {
            Node<T> newNode = new Node<>(data, null, last);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        /*
          Одна из причин использовать двусторонний список: возможность проитерировать до узла с искомым индексом
          с той стороны от куда ближе
         */
        if (index < size / 2) {
            int count = 0;
            Node<T> cursor = first;
            while (count <= index) {
                if (count == index) {
                    return cursor.data;
                }
                cursor = cursor.next;
                count++;
            }
        } else {
            int count = size - 1;
            Node<T> cursor = last;
            while (count >= index) {
                if(count == index){
                    return cursor.data;
                }
                cursor = cursor.prev;
                count--;
            }
        }

        return null;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
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
            result.append(", cursor.prev = ");
            result.append(cursor.prev);
            result.append("\n");
            cursor = cursor.next;
        }

        return result.toString();
    }

}
