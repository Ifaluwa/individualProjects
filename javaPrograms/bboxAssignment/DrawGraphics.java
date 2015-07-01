import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class DrawGraphics {
    ArrayList<BouncingBox> boxes = new ArrayList<>();
    Football ball;

    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        boxes.add(new BouncingBox(50, 50, Color.RED));
        boxes.add(new BouncingBox(50, 80, Color.BLUE));
        boxes.add(new BouncingBox(50, 110, Color.GREEN));
        boxes.get(0).setMovementVector(1, 0);   
        boxes.get(1).setMovementVector(0, 1);   
        boxes.get(2).setMovementVector(1, 1);
        ball = new Football(100, 250, Color.ORANGE);    
        ball.setMovementVector(2,2);  
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 150, 250, 150);
        for (BouncingBox box : boxes){
            box.draw(surface);
        }
        surface.drawRect(50, 160, 20, 50);
        surface.drawOval(50,220,20,40);
        ball.draw(surface);

        surface.drawString("Laolu the GOAT", 200, 10);
    }
} 