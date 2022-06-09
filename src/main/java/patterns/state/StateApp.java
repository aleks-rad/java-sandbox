package patterns.state;

import lombok.SneakyThrows;
import patterns.state.machine.WashingMachine;

import java.util.concurrent.TimeUnit;

/**
 * Паттерн "Состояние"
 * Управляет изменением поведения объекта при изменении его внутреннего состояния.
 * Внешне это выглядит так, словно объект меняет свой класс.
 */
public class StateApp {

    @SneakyThrows
    public static void main(String[] args) {
        WashingMachine washingMachine = new WashingMachine();

        /*
        Нельзя заблокировать открытую дверцу
        Нельзя запустить машинку с открытой дверцей
         */
        washingMachine.start();

        washingMachine.closeDoor();
        washingMachine.start();

        /*
        Машинка в процессе стирки. Дверца уже заблокирована.
        Машинка уже в процессе стирки.
         */
        washingMachine.start();

        // Машинка в процессе стирки. Нельзя открыть дверцу.
        washingMachine.openDoor();

        // Ждем пока машинка закончит стирку. Через 7 секунд уже закончила стирать, но дверца еще заблокирована
        TimeUnit.SECONDS.sleep(7);
        washingMachine.openDoor();

        // Ждем пока машинка разблокирует дверцу
        TimeUnit.SECONDS.sleep(4);
        washingMachine.openDoor();
    }

}
