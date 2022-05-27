package patterns.observer.listener;

import patterns.observer.supplier.Event;

import static utils.Utils.println;

public class PrintEventListener implements EventListener {

    @Override
    public void notify(Event event) {
        println("Произошло событие \"%s\"", event.getName());
    }

}
