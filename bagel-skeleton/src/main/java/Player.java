import bagel.*;

public class Player {
    private double x;
    private double y;
    private Image plane;

    // constructor
    public Player() {
        x = Window.getWidth() / 2;
        y = Window.getHeight() / 2;
        plane = new Image("res/plane.png");
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void render() {
        plane.draw(x, y);
    }

}
