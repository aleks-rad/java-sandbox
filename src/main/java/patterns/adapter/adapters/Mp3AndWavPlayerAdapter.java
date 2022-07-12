package patterns.adapter.adapters;

import patterns.adapter.libraries.ProgressivePlayer;

public class Mp3AndWavPlayerAdapter implements Player {

    private final ProgressivePlayer progressivePlayer;

    public Mp3AndWavPlayerAdapter(ProgressivePlayer progressivePlayer) {
        this.progressivePlayer = progressivePlayer;
    }

    @Override
    public void play(String fileName) {
        if (fileName.contains(".mp3")) {
            progressivePlayer.playMp3(fileName);
        } else if (fileName.contains(".wav")) {
            progressivePlayer.playWav(fileName);
        } else {
            throw new UnsupportedOperationException("Неподдерживаемый формат файла - " + fileName);
        }
    }

    @Override
    public void stop() {
        progressivePlayer.stopPlayer();
    }

}
