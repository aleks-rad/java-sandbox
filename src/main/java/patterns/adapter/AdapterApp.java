package patterns.adapter;

import patterns.adapter.adapters.Mp3AndWavPlayerAdapter;
import patterns.adapter.adapters.Mp3PlayerAdapter;
import patterns.adapter.adapters.Player;
import patterns.adapter.libraries.Mp3Player;
import patterns.adapter.libraries.ProgressivePlayer;

/**
 * Паттерн "Адаптер"
 * Преобразует интерфейс класса к другому интерфейсу, на который рассчитан клиент.
 * Адаптер обеспечивает совместную работу классов, невозможную в обычных условиях
 * из-за несовместимости интерфейсов.
 */
public class AdapterApp {

    public static void main(String[] args) {
        /*
        Сначала мы использовали библиотеку, которая могла проигрывать только mp3 файлы.
         */
        Player oldPlayer = new Mp3PlayerAdapter(new Mp3Player());
        playMusic(oldPlayer, "Nothing else matters.mp3");
        //playMusic(oldPlayer, "Nothing else matters.wav");

        /*
        Но затем нашли более продвинутую либу, которая умееет проигрывать еще и формат wav.
        Хорошо что наш клиентский код был рассчитан на такой поворот. Мы просто добавим новый адаптер.
         */
        Player newPlayer = new Mp3AndWavPlayerAdapter(new ProgressivePlayer());
        playMusic(newPlayer, "Nothing else matters.mp3");
        playMusic(newPlayer, "Nothing else matters.wav");
    }

    private static void playMusic(Player player, String fileName){
        player.play(fileName);
    }

}
