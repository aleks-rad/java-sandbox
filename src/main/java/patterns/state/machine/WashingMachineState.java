package patterns.state.machine;

public interface WashingMachineState {

    void closeDoor();
    void openDoor();
    void blockDoor();
    void unblockDoor();
    void start();

}
