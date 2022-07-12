package patterns.adapter.libraries;

import static utils.Utils.println;

public class Mp3Player {

    public void playMp3File(String fileName) {
        println("Сейчас играет " + fileName);
    }

    public void stop() {
        println("Плеер выключен");
    }

}
