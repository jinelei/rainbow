package adapter;

/**
 * @author zhenlei
 */
public class MediaAdapter implements MediaPlayer {
    private AdventageMediaPlayer adventageMediaPlayer;

    public MediaAdapter(String mediaType) {
        switch (mediaType) {
            case "vlc":
                adventageMediaPlayer = new VlcPlayer();
                break;
            case "mp4":
            default:
                adventageMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void player(String mediaType) {
        switch (mediaType) {
            case "vlc":
                adventageMediaPlayer.playVlc();
                break;
            case "mp4":
            default:
                adventageMediaPlayer.playMp4();
        }
    }
}
