package patterns.strategy;

import patterns.strategy.behavior.ContentProvider;
import patterns.strategy.behavior.EmptyContentProvider;

import static utils.Utils.println;

public class DataMachineImpl implements DataMachine {

    /**
     * Переменный аспект поведения, инкапсулирован в семействе взаимозаменяемых алгоритмов типа ContentProvider
     */
    private ContentProvider provider;

    public DataMachineImpl(){
        provider = new EmptyContentProvider();
    }

    public DataMachineImpl(ContentProvider provider){
        this.provider = provider;
    }

    @Override
    public void setProvider(ContentProvider provider){
        this.provider = provider;
    }

    @Override
    public void print() {
        println("PROVIDER: " + provider.getClass().getSimpleName());
        println("CONTENT:\n" + provider.getContent());
    }

}
