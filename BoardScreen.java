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
import javafx.scene.input.MouseEvent;

/**
 * Gameplay screen
 *
 * @author Josh Ting
 */
public class BoardScreen {
    Group boardGroup;
    Scene scene;
    Board board;
    final int numTileRows = 5;
    final int numTileCols = 7;
    final int tileEdgeWidth = 5;
    int tileLength;
    int[] corners; // the pixel coordinates of the 4 corners of the playing board

    public BoardScreen(int width, int height) {
        board = new Board();
        boardGroup = new Group();
        corners = new int[4];
        Rectangle boardBackground = new Rectangle(0, 0, width, height);
        boardBackground.setFill(Color.BLUE);
        boardGroup.getChildren().add(boardBackground);
        // add edges of tiles to board
        tileLength = Math.min(width, height) / 9;
        corners[0] = (int)(width / 2 - tileLength * numTileCols / 2);
        corners[1] = (int)(width / 2 + tileLength * numTileCols / 2);
        corners[2] = tileLength;
        corners[3] = tileLength * (1 + numTileRows);
        for (int i = corners[0]; i <= corners[1]; i += tileLength) {
                boardGroup.getChildren().add(new Rectangle(i, corners[2],
                        tileEdgeWidth, tileLength * numTileRows));
        }
        for (int j = corners[2]; j <= corners[3]; j += tileLength) {
                boardGroup.getChildren().add(new Rectangle(corners[0], j,
                        tileLength * numTileCols + tileEdgeWidth, tileEdgeWidth));
        }
        scene = new Scene(boardGroup, width, height);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                // find board tile
                if (e.getX() > corners[0] && e.getX() < corners[1] && e.getY() > corners[2] && e.getY() < corners[3]) {
                    // within bounds of board
                    int[] tile = pixelToTile(e.getX(), e.getY());
                    int[] coords = tileToPixel(tile[0], tile[1]);
                    if (board.getSpaces()[tile[0]][tile[1]] == null) { // empty space
                        // summon unit
                        board.addUnit(new Unit(1, "", 1, 1, ""), tile[0], tile[1]);
                        boardGroup.getChildren().add(new Rectangle(coords[0], coords[1], tileLength, tileLength));

                    }
                }
            }
        });
    }

    private int[] pixelToTile(double x, double y) {
        int[] coords = {(int)(x - corners[0]) / tileLength, (int)(y - corners[2]) / tileLength};
        return coords;
    }

    private int[] tileToPixel(int x, int y) {
        int[] coords = {corners[0] + x * tileLength, corners[2] + y * tileLength};
        return coords;
    }

    public Scene getScene() {
        return scene;
    }
    
}