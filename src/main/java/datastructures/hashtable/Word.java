package datastructures.hashtable;

public class Word {

    private final String value;

    public Word(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Word){
            Word otherWord = (Word) other;
            return this.value.equals(otherWord.value);
        }

        return false;
    }

    @Override
    public String toString(){
        return value;
    }

}
