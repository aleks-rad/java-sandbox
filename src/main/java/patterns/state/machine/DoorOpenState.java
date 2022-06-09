package patterns.state.machine;

import static utils.Utils.println;

/**
 * Дверца открыта. Можно только закрыть дверцу.
 */
public class DoorOpenState implements WashingMachineState {

    private final WashingMachine washingMachine;

    public DoorOpenState(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    @Override
    public void closeDoor() {
        println("ЗАКРЫЛИ дверцу");
        washingMachine.setCurrentState(washingMachine.getDoorCloseState());
    }

    @Override
    public void openDoor() {
        println("Дверца уже открыта");
    }

    @Override
    public void blockDoor() {
        println("Нельзя заблокировать открытую дверцу");
    }

    @Override
    public void unblockDoor() {
        println("Дверца уже разблокирована и открыта");
    }

    @Override
    public void start() {
        println("Нельзя запустить машинку с открытой дверцей");
    }

}
