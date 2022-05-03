package datastructures.hashtable;

import java.util.LinkedList;

import static java.util.Objects.nonNull;

/**
 * Реализация структуры данных хеш-таблица
 */
public class MyHashTable<K, V> {

    private final LinkedList<Entry<K, V>>[] entries;

    public MyHashTable(int size){
        entries = new LinkedList[size];

        for (int i = 0; i < entries.length; i++) {
            entries[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value){
        if(nonNull(get((key)))) return;

        int index = hashFunc(key);
        entries[index].add(new Entry<>(key, value));
    }

    public Entry<K, V> get(K key){
        int index = hashFunc(key);

        LinkedList<Entry<K, V>> subEntries = entries[index];
        for (Entry<K, V> entry : subEntries) {
            if(entry.key.equals(key)){
                return entry;
            }
        }
        return null;
    }

    public int hashFunc(K key){
        int hashCode = Math.abs(key.hashCode());

        return hashCode % entries.length;
    }

    public static class Entry<K, V>{
        private final K key;
        private final V value;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
