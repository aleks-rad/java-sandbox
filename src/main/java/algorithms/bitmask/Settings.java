package algorithms.bitmask;

import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.StringJoiner;

import static algorithms.bitmask.Settings.DayOfWeekMask.*;

public class Settings {

    private final int daysOfWeekForHandling;

    /**
     * В конструкторе определяется суммарная маска по всем дням недели
     *
     * @param dayOfWeekMask varargs с масками дней недели
     */
    public Settings(DayOfWeekMask... dayOfWeekMask) {
        daysOfWeekForHandling = Arrays.stream(dayOfWeekMask)
                .distinct()
                .mapToInt(day -> day.bitMask)
                .sum();
    }

    /**
     * Метод для определения соответствует ли настройка допустимых дней недели
     * переданному параметру dayOfWeekMask
     *
     * @param dayOfWeekMask Маска дня недели
     * @return
     * true - соответствует
     * false - не соответствует
     */
    public boolean isThisTheSameDay(DayOfWeekMask dayOfWeekMask) {
        return (daysOfWeekForHandling & dayOfWeekMask.bitMask) != 0;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(" ");

        if ((daysOfWeekForHandling & MONDAY.bitMask) != 0) result.add(MONDAY.name());
        if ((daysOfWeekForHandling & TUESDAY.bitMask) != 0) result.add(TUESDAY.name());
        if ((daysOfWeekForHandling & WEDNESDAY.bitMask) != 0) result.add(WEDNESDAY.name());
        if ((daysOfWeekForHandling & THURSDAY.bitMask) != 0) result.add(THURSDAY.name());
        if ((daysOfWeekForHandling & FRIDAY.bitMask) != 0) result.add(FRIDAY.name());
        if ((daysOfWeekForHandling & SATURDAY.bitMask) != 0) result.add(SATURDAY.name());
        if ((daysOfWeekForHandling & SUNDAY.bitMask) != 0) result.add(SUNDAY.name());

        return result.toString();
    }

    /**
     * Метод для получения маски дня недели
     *
     * @param dayOfWeek День недели
     * @return Маска дня недели
     */
    public static DayOfWeekMask getDayOfWeekMask(DayOfWeek dayOfWeek) {
        switch (dayOfWeek){
            case MONDAY: return DayOfWeekMask.MONDAY;
            case TUESDAY: return DayOfWeekMask.TUESDAY;
            case WEDNESDAY: return DayOfWeekMask.WEDNESDAY;
            case THURSDAY: return DayOfWeekMask.THURSDAY;
            case FRIDAY: return DayOfWeekMask.FRIDAY;
            case SATURDAY: return DayOfWeekMask.SATURDAY;
            case SUNDAY: return DayOfWeekMask.SUNDAY;
        }

        return DayOfWeekMask.NONE_DAY;
    }

    @AllArgsConstructor
    public enum DayOfWeekMask {

        NONE_DAY(0b0000000),
        MONDAY(0b0000001),
        TUESDAY(0b0000010),
        WEDNESDAY(0b0000100),
        THURSDAY(0b0001000),
        FRIDAY(0b0010000),
        SATURDAY(0b0100000),
        SUNDAY(0b1000000);

        private final int bitMask;

    }

}
