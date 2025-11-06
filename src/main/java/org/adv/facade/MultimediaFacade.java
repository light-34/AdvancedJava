package org.adv.facade;

public class MultimediaFacade {
    private AudioPlayer audioPlayer;
    private VideoPlayer videoPlayer;
    private Projector projector;

    public MultimediaFacade() {
        this.audioPlayer = new AudioPlayer();
        this.videoPlayer = new VideoPlayer();
        this.projector = new Projector();
    }

    public void playMultimedia() {
        audioPlayer.play();
        videoPlayer.play();
        projector.play();
    }
}
