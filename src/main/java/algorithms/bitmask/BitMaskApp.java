package algorithms.bitmask;

import java.time.LocalDate;
import java.util.List;

import static algorithms.bitmask.Settings.DayOfWeekMask.*;
import static algorithms.bitmask.Settings.getDayOfWeekMask;

/**
 * Используем битовую маску для элегантной и эффективной замены группы булевых значений
 */
public class BitMaskApp {

    public static void main(String[] args) {
        List<Event> events = List.of(
                new Event("Event1", new Settings(SUNDAY, THURSDAY, FRIDAY)),
                new Event("Event2", new Settings(TUESDAY)),
                new Event("Event3", new Settings(NONE_DAY)),
                new Event("Event4", new Settings(MONDAY, THURSDAY, FRIDAY)),
                new Event("Event5", new Settings(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY))
        );

        var dayOfWeekMask = getDayOfWeekMask(LocalDate.now().getDayOfWeek());

        events.forEach(event -> event.handle(dayOfWeekMask));
    }

}
