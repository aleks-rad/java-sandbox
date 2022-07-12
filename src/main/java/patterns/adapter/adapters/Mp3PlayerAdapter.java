package patterns.adapter.adapters;

import patterns.adapter.libraries.Mp3Player;

public class Mp3PlayerAdapter implements Player {

    private final Mp3Player mp3Player;

    public Mp3PlayerAdapter(Mp3Player mp3Player){
        this.mp3Player = mp3Player;
    }

    @Override
    public void play(String fileName) {
        if (fileName.contains(".mp3")) {
            mp3Player.playMp3File(fileName);
        } else {
            throw new UnsupportedOperationException("Неподдерживаемый формат файла - " + fileName);
        }
    }

    @Override
    public void stop() {
        mp3Player.stop();
    }

}
