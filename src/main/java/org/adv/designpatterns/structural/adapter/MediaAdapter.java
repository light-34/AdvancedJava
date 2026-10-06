package org.adv.designpatterns.structural.adapter;

/**
 * The Adapter design pattern is a structural pattern that allows incompatible interfaces to work together.
 * It acts as a bridge between two incompatible classes by converting the interface of one class into another
 * interface that clients expect.
 */
public class MediaAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
