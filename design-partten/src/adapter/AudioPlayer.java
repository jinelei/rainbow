package adapter;

/**
 * @author zhenlei
 */
public class AudioPlayer implements MediaPlayer {
    MediaPlayer mediaPlayer;

    @Override
    public void player(String mediaType) {
        switch (mediaType) {
            case "mp3":
                System.out.println("play mp3");
                break;
            case "vlc":
            case "mp4":
                new MediaAdapter(mediaType).player(mediaType);
                break;
            default:
                System.out.println("not support type: " + mediaType);
        }
    }
}
