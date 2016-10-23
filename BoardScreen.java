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
    final int numTileRows = 5;
    final int numTileCols = 7;
    final int tileEdgeWidth = 5;

    public BoardScreen(int width, int height) {
        boardGroup = new Group();
        Rectangle boardBackground = new Rectangle(0, 0, width, height);
        boardBackground.setFill(Color.BLUE);
        boardGroup.getChildren().add(boardBackground);
        // add edges of tiles to board
        int tileLength = Math.min(width, height) / 9;
        for (int i = 0; i <= numTileCols; i++) {
                boardGroup.getChildren().add(new Rectangle(width / 2 + tileLength * (i - numTileRows / 2.0), tileLength,
                        tileEdgeWidth, tileLength * numTileRows));
        }
        for (int j = 0; j <= numTileRows; j++) {
                boardGroup.getChildren().add(new Rectangle(width / 2 - tileLength * numTileRows / 2.0, tileLength * (j + 1),
                        tileLength * numTileCols + tileEdgeWidth, tileEdgeWidth));
        }
        scene = new Scene(boardGroup, width, height);
    }

    public Scene getScene() {
        return scene;
    }
    
}