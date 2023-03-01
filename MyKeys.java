import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeys extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if (Snake.direction != "LEFT") {
                    Snake.direction = "RIGHT";
                }break;
            case KeyEvent.VK_LEFT:
                if (Snake.direction != "RIGHT") {
                    Snake.direction = "LEFT";
                }break;
            case KeyEvent.VK_UP:
                if (Snake.direction != "DOWN") {
                    Snake.direction = "UP";
                }break;
            case KeyEvent.VK_DOWN:
                if (Snake.direction != "UP") {
                    Snake.direction = "DOWN";
                }break;
        }
    }
}
