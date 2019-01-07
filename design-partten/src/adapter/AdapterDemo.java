package adapter;

/**
 * @author zhenlei
 */
public class AdapterDemo {
    static public void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.player("mp3");
        audioPlayer.player("mp4");
        audioPlayer.player("vlc");
        audioPlayer.player("acc");
    }
}
