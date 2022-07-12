package patterns.adapter.libraries;

import static utils.Utils.println;

public class ProgressivePlayer {

    public void playMp3(String fileName) {
        println("Исполняется файл: " + fileName);
    }

    public void playWav(String fileName) {
        println("Исполняется файл: " + fileName);
    }

    public void stopPlayer() {
        println("Проигрывание музыки остановлено");
    }

}
