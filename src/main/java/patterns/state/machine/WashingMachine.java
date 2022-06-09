package patterns.state.machine;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Стиральная машинка реализована в виде конечного автомата.
 * В каждый момент времени машинка находится в одном из 4х возможных состояний.
 * При совершении одного из возможных действий, машинка переходит в новое состояние
 * или остается в прежнем состоянии, если переход невозможен.
 */
@Getter(value = AccessLevel.PACKAGE)
public class WashingMachine {

    private final WashingMachineState doorOpenState;
    private final WashingMachineState doorCloseState;
    private final WashingMachineState doorBlockState;
    private final WashingMachineState washingProcessState;

    @Setter(value = AccessLevel.PACKAGE)
    private WashingMachineState currentState;

    public WashingMachine() {
        this.doorOpenState = new DoorOpenState(this);
        this.doorCloseState = new DoorCloseState(this);
        this.doorBlockState = new DoorBlockState(this);
        this.washingProcessState = new WashingProcessState(this);

        this.currentState = this.doorOpenState;
    }

    public void closeDoor() {
        currentState.closeDoor();
    }

    public void start() {
        currentState.blockDoor();
        currentState.start();
    }

    public void openDoor() {
        currentState.openDoor();
    }

}
