package patterns.strategy;

import patterns.strategy.behavior.JsonContentProvider;
import patterns.strategy.behavior.XmlContentProvider;

/**
 * Паттер "Стратегия"
 * Определяет семейство алгоритмов, инкапсулирует каждый из них и обеспечивает их взаимозаменяемость.
 * Он позволяет модифицировать алгоритмы независимо от их использования на стороне клиента.
 */
public class StrategyApp {

    public static void main(String[] args) {
        DataMachine dataMachine = DataMachine.getInstance();

        dataMachine.print();

        dataMachine.setProvider(new JsonContentProvider());
        dataMachine.print();

        dataMachine.setProvider(new XmlContentProvider());
        dataMachine.print();
    }

}
