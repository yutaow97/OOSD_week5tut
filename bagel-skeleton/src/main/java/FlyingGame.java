import bagel.*;
import java.util.Random;

import javax.swing.*;

/**
 * An example Bagel game.
 *
 * @author Eleanor McMurtry
 */
public class FlyingGame extends AbstractGame {
    private Image plane;
    private Image bagel;
    private Image balloon;
    private double x = Window.getWidth() / 2;
    private double y = Window.getHeight() / 2;

    private static Random random = new Random();
    private double balloonX = random.nextInt(Window.getWidth());
    private double balloonY = random.nextInt(Window.getHeight());


    public FlyingGame() {

        bagel = new Image("res/land.jpeg");
        plane = new Image("res/plane.png");
        balloon = new Image("res/balloon.png");
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
        if (input.isDown(Keys.LEFT) && (x >= 0)) {
            x -= speed;
        }
        if (input.isDown(Keys.RIGHT) && (x <= Window.getWidth())) {
            x += speed;
        }
        if (input.isDown(Keys.UP) && (y >= 0 )) {
            y -= speed;
        }
        if (input.isDown(Keys.DOWN) && (y <= Window.getHeight())) {
            y += speed;
        }

        if (input.wasPressed(Keys.ESCAPE)) {
            Window.close();
        }

        bagel.draw(Window.getWidth() / 2, Window.getHeight() / 2);
        plane.draw(x, y);
        balloon.draw(balloonX, balloonY);

    }
}
