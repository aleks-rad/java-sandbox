package patterns.observer.supplier;

import patterns.observer.listener.EventListener;

import java.util.ArrayList;
import java.util.List;

public class NewsSupplier implements EventSupplier {

    private List<EventListener> listeners = new ArrayList<>();

    @Override
    public void subscribe(EventListener eventListener) {
        listeners.add(eventListener);
    }

    @Override
    public void unsubscribe(EventListener eventListener) {
        listeners.remove(eventListener);
    }

    @Override
    public void post(Event event) {
        listeners.forEach(eventListener -> eventListener.notify(event));
    }

}
