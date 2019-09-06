import bagel.*;
import java.util.Random;

/**
 * An example Bagel game.
 *
 * @author Eleanor McMurtry
 */
public class FlyingGame extends AbstractGame {
    private Player player;
    private Image bagel;
    private Image balloon;
    private double x;
    private double y;
    private double balloonX;
    private double balloonY;

    // constructor
    public FlyingGame() {
        bagel = new Image("res/land.jpeg");
        balloon = new Image("res/balloon.png");

        player = new Player();
        setBalloonNewRandomLocation();
    }

    private void setBalloonNewRandomLocation() {
        Random random = new Random();
        balloonX = random.nextInt(Window.getWidth());
        balloonY = random.nextInt(Window.getHeight());
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        FlyingGame game = new FlyingGame();
        game.run();
    }

    /**
     * Performs a state update. This simple example shows an image that can be controlled with the arrow keys, and
     * allows the game to exit when the escape key is pressed.
     */
    @Override
    public void update(Input input) {
        double speed = 5f;
        double dx = 0;
        double dy = 0;

        if (input.isDown(Keys.LEFT) && (player.getX() >= 0)) {
            dx -= speed;
        }
        if (input.isDown(Keys.RIGHT) && (player.getX() <= Window.getWidth())) {
            dx += speed;
        }
        if (input.isDown(Keys.UP) && (player.getY() >= 0 )) {
            dy -= speed;
        }
        if (input.isDown(Keys.DOWN) && (player.getY() <= Window.getHeight())) {
            dy += speed;
        }
        player.move(dx, dy);

        if (Math.sqrt((player.getX() - balloonX) * (player.getX() - balloonX) + (player.getY() - balloonY) * (player.getY() - balloonY)) < 50) {
            setBalloonNewRandomLocation();
        }

        if (input.wasPressed(Keys.ESCAPE)) {
            Window.close();
        }


        bagel.draw(Window.getWidth() / 2, Window.getHeight() / 2);

        balloon.draw(balloonX, balloonY);
        player.render();
    }
}
