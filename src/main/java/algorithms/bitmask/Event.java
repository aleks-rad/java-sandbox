package algorithms.bitmask;

import static utils.Utils.println;

public class Event {

    private final String name;
    private final Settings settings;

    public Event(String name, Settings settings) {
        this.name = name;
        this.settings = settings;

        println("Событие \"%s\" создано", this);
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", name, settings);
    }

    public void handle(Settings.DayOfWeekMask dayOfWeekMask) {
        if (settings.isThisTheSameDay(dayOfWeekMask)) {
            println("Сегодня тот самый день, когда событие \"%s\" будет обработано", name);
        } else {
            println("Событие \"%s\" не будет обработано", name);
        }
    }

}
