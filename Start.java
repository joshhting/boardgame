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
 * A JavaFX game
 *
 * @author Josh Ting
 */
public class Start extends Application {
    final static int width = 1200;
    final static int height = 800;
    
    @Override
    public void start(Stage stage) throws Exception {
        Group g = new Group();
        Rectangle r = new Rectangle(0, 0, width, height);
        r.setFill(Color.WHITE);

        Text t = new Text(width/2 - 100, height/2, "Press Enter to begin");
        t.setFont(new Font(20));

        g.getChildren().add(r);
        g.getChildren().add(t);
        Scene scene = new Scene(g, width, height);
        stage.setScene(scene);
        stage.setTitle("Java Game");
        stage.show();

        BoardScreen gameBoard = new BoardScreen(width, height);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ENTER) {
                    System.out.println("hi");
                    stage.setScene(gameBoard.getScene());
                }
            }
        });
    }
    
}