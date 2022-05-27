package patterns.observer.supplier;

import patterns.observer.listener.EventListener;

/**
 * Описывает объект наблюдения, с возможностью подписки на изменения
 */
public interface EventSupplier {

    void subscribe(EventListener eventListener);
    void unsubscribe(EventListener eventListener);
    void post(Event event);

}
