package patterns.state.machine;

import static utils.Utils.println;

/**
 * Дверца закрыта. Можно либо заблокировать дверцу, либо открыть.
 */
public class DoorCloseState implements WashingMachineState {

    private final WashingMachine washingMachine;

    public DoorCloseState(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    @Override
    public void closeDoor() {
        println("Дверца уже закрыта");
    }

    @Override
    public void openDoor() {
        println("ОТКРЫЛИ дверцу");
        washingMachine.setCurrentState(washingMachine.getDoorOpenState());
    }

    @Override
    public void blockDoor() {
        println("ЗАБЛОКИРОВАЛИ дверцу");
        washingMachine.setCurrentState(washingMachine.getDoorBlockState());
    }

    @Override
    public void unblockDoor() {
        println("Дверца уже разблокирована");
    }

    @Override
    public void start() {
        println("Нельзя запустить машинку без блокировки дверцы");
    }

}
