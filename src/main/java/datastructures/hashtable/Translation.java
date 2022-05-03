package datastructures.hashtable;

public class Translation {

    private final String value;

    public Translation(String value){
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
        if(other instanceof Translation){
            Translation otherWord = (Translation) other;
            return this.value.equals(otherWord.value);
        }

        return false;
    }

    @Override
    public String toString(){
        return value;
    }

}
