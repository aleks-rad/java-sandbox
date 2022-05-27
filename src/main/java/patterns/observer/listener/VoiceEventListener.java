package patterns.observer.listener;

import patterns.observer.supplier.Event;

import static utils.Utils.println;

public class VoiceEventListener implements EventListener {

    @Override
    public void notify(Event event) {
        println("Голосовое озвучивание события \"%s\"", event.getName());
    }

}
