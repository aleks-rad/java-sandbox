package patterns.strategy;

import patterns.strategy.behavior.ContentProvider;

public interface DataMachine {

    void setProvider(ContentProvider provider);

    void print();

    static DataMachine getInstance(){
        return new DataMachineImpl();
    }

}
