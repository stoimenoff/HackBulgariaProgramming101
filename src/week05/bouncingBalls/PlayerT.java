package week05.bouncingBalls;

/**
 * Created by georgipavlov on 16.12.15.
 */
public class PlayerT implements Runnable {
    @Override
    public void run() {
        Game.player.tick();
    }
}
