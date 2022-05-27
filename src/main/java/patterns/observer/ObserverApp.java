package patterns.observer;

import patterns.observer.listener.PrintEventListener;
import patterns.observer.listener.StorageEventListener;
import patterns.observer.listener.VoiceEventListener;
import patterns.observer.supplier.Event;
import patterns.observer.supplier.EventSupplier;
import patterns.observer.supplier.NewsSupplier;

/**
 * Паттерн "Наблюдатель"
 * Позволяет уведомлять подписчиков об изменении состояния обозреваемого объекта
 */
public class ObserverApp {

    public static void main(String[] args) {
        EventSupplier eventSupplier = new NewsSupplier();

        eventSupplier.subscribe(new PrintEventListener());
        eventSupplier.subscribe(new VoiceEventListener());
        eventSupplier.subscribe(new StorageEventListener());

        eventSupplier.post(new Event("Кошка родила 1 котенка"));
        eventSupplier.post(new Event("Кошка родила 2 котенка"));
        eventSupplier.post(new Event("Кошка родила 3 котенка"));
    }

}
