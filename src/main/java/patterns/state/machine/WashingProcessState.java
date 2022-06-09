package patterns.state.machine;

import static utils.Utils.println;

/**
 * Машинка в процессе стирки. Ничего сделать нельзя.
 * Когда стирка завершится, машинка перейдет в состояние DoorCloseState.
 */
public class WashingProcessState implements WashingMachineState {

    private final WashingMachine washingMachine;

    public WashingProcessState(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    @Override
    public void closeDoor() {
        println("Машинка в процессе стирки. Дверца уже закрыта.");
    }

    @Override
    public void openDoor() {
        println("Машинка в процессе стирки. Нельзя открыть дверцу.");
    }

    @Override
    public void blockDoor() {
        println("Машинка в процессе стирки. Дверца уже заблокирована.");
    }

    @Override
    public void unblockDoor() {
        println("Машинка в процессе стирки. Нельзя разблокировать дверцу.");
    }

    @Override
    public void start() {
        println("Машинка уже в процессе стирки.");
    }

}
