package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.TicTacToeModel;

/**
 * Provides a GUI view and the listeners required for players to make Tic Tac
 * Toe moves with mouse clicks.
 * 
 * @author Wes Rodgers
 *
 */
public class TicTacToeControllerView extends Canvas implements Observer {

    private TicTacToeModel gameModel;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    private GraphicsContext gc;
    private Image xImage, yImage;

    public TicTacToeControllerView() {
        gameModel = new TicTacToeModel();
        gameModel.setAIStrategy(/* TODO add strategy info here */);
        initializeGame();
    }

    /**
     * Overridden constructor for loading specific models into the controller
     * view
     * 
     * @param ticTacToeModel the model of the game that we want to load
     */
    public TicTacToeControllerView(TicTacToeModel ticTacToeModel) {
        // TODO stub for loading game from a particular model
        initializeGame();

    }

    /**
     * initializes this object by setting various fields and setting up the
     * listeners.
     */
    private void initializeGame() {
        gameModel.addObserver(this);
        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);
        setupResources();
        setupListeners();
        setupBoard();
    }

    /**
     * gets the resources for this game
     */
    private void setupResources() {
        // TODO xImage = new Image("xImage file path");
        // TODO yImage = new Image("yImage file path");
    }

    /**
     * gets the graphics context we are drawing to and draws the board and
     * current moves to it.
     */
    private void setupBoard() {
        gc = this.getGraphicsContext2D();
        gc.setLineWidth(5);
        drawBoard();
    }

    /**
     * draws the move at position (row,col) to board
     * 
     * @param row the row the move is in
     * @param col the column the move is in
     * @param c   the move, 'X' or 'O'
     */
    private void drawMove(int row, int col, char c) {
        Image drawImage = c == 'X' ? xImage : yImage;
        gc.drawImage(drawImage, 0, 0, drawImage.getWidth(),
                drawImage.getHeight(), col * 200 + 10, row * 200 + 10, 180,
                180);
    }

    /**
     * Draws the 4 lines that make up the board and checks
     * the moves on the game model and draws those.
     */
    private void drawBoard() {
        gc.strokeLine(200, 0, 200, 600);
        gc.strokeLine(400, 0, 400, 600);
        gc.strokeLine(0, 200, 600, 200);
        gc.strokeLine(0, 400, 600, 400);
        char[][] currState = gameModel.getBoard();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (currState[row][col] != '_') {
                    drawMove(row, col, currState[row][col]);
                }
            }
        }
    }

    /**
     * sets up the click listener for the board. Finds which spot the user
     * clicked on and attempts to make a move at that spot.
     */
    private void setupListeners() {
        this.setOnMouseClicked((click) -> {
            int x = (int) click.getX() / 200;
            int y = (int) click.getY() / 200;
            gameModel.humanMove(x, y, false);
        });
    }

    /**
     * When the board changes and notifies this observer, clear the graphics
     * context and redraw it.
     */
    @Override
    public void update(Observable arg0, Object arg1) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        drawBoard();
        if (gameModel.won('X') || gameModel.won('C')) {
            String dir = gameModel.getWinningDirection();
            int[] points = gameModel.getWinningPoints();
            for (int i : points) {
                i = i * 200;
            }
            gc.setStroke(Color.PALEVIOLETRED);

            // since we know the two winning points, from left to right
            // and top to bottom with that priority, we can use the direction
            // of the win to determine how to draw our line
            switch (dir) {
            case "vertical":
                points[0] += 100;
                points[2] += 100;
                points[3] += 200;
                break;
            case "horizontal":
                points[1] += 100;
                points[2] += 200;
                points[3] += 100;
                break;
            case "topLeftDiagonal":
                points[2] += 200;
                points[3] += 200;
                break;
            case "bottomLeftDiagonal":
                points[1] += 200;
                points[2] += 200;
                break;
            }
        }
    }

}
