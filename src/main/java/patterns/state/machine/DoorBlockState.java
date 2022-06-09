package patterns.state.machine;

import java.util.concurrent.TimeUnit;

import static utils.Utils.println;

/**
 * Дверца заблокирована. Машинка готова к стирке.
 */
public class DoorBlockState implements WashingMachineState {

    private final WashingMachine washingMachine;

    public DoorBlockState(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
    }

    @Override
    public void closeDoor() {
        println("Дверца уже закрыта и заблокирована");
    }

    @Override
    public void openDoor() {
        println("Нельзя открыть заблокированную дверцу");
    }

    @Override
    public void blockDoor() {
        println("Дверца уже заблокирована");
    }

    @Override
    public void unblockDoor() {
        println("РАЗБЛОКИРОВАЛИ дверцу");
        washingMachine.setCurrentState(washingMachine.getDoorCloseState());
    }

    @Override
    public void start() {
        println("ПУСК процесса стирки");
        washingMachine.setCurrentState(washingMachine.getWashingProcessState());
        startWashingProcess();
    }

    /**
     * Процесс стирки идет 5 секунд
     * Дверца разблокируется еще через 5 секунд после окончания стирки
     */
    private void startWashingProcess(){
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                println("Стирка завершена");
                washingMachine.setCurrentState(washingMachine.getDoorBlockState());

                TimeUnit.SECONDS.sleep(5);
                washingMachine.getCurrentState().unblockDoor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
