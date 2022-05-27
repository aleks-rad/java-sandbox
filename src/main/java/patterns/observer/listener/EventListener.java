package patterns.observer.listener;

import patterns.observer.supplier.Event;

/**
 * Описывает слушателя события
 */
public interface EventListener {

    void notify(Event event);

}
