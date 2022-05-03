package datastructures.hashtable;

import static utils.Utils.println;

public class MyHashTableApp {

    public static void main(String[] args) {
        MyHashTable<Word, Translation> myHashTable = new MyHashTable<>(5);

        myHashTable.put(new Word("Cat"), new Translation("Кошка"));
        myHashTable.put(new Word("Paper"), new Translation("Бумага"));
        myHashTable.put(new Word("Sun"), new Translation("Солнце"));
        myHashTable.put(new Word("Monday"), new Translation("Понедельник"));
        myHashTable.put(new Word("Book"), new Translation("Книга"));
        myHashTable.put(new Word("Guitar"), new Translation("Гитара"));
        myHashTable.put(new Word("Table"), new Translation("Стол"));

        MyHashTable.Entry<Word, Translation> entry = myHashTable.get(new Word("Sun"));
        println("entry[\"%s\"] = \"%s\"", entry.getKey(), entry.getValue());
    }

}
