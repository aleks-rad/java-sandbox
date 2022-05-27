package patterns.observer.listener;

import patterns.observer.supplier.Event;

import static utils.Utils.println;

public class StorageEventListener implements EventListener {

    @Override
    public void notify(Event event) {
        println("Сохранено событие \"%s\"", event.getName());
    }

}
