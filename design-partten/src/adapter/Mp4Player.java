package adapter;

/**
 * @author zhenlei
 */
public class Mp4Player implements AdventageMediaPlayer{
    @Override
    public void playVlc() {

    }

    @Override
    public void playMp4() {
        System.out.println("play mp4");
    }
}
