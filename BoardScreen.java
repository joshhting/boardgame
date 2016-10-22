import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * Gameplay screen
 *
 * @author Josh Ting
 */
public class BoardScreen {
    Group boardGroup;
    Scene scene;

    public BoardScreen(int width, int height) {
        boardGroup = new Group();
        Rectangle boardBackground = new Rectangle(0, 0, width, height);
        boardBackground.setFill(Color.BLUE);
        boardGroup.getChildren().add(boardBackground);
        scene = new Scene(boardGroup, width, height);
    }

    public Scene getScene() {
        return scene;
    }
    
}