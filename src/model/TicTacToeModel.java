package model;

import java.io.Serializable;
import java.util.Observable;

public class TicTacToeModel extends Observable implements Serializable{

    /**
     * default serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    private char[][] board;
    private int size;
    private TicTacToeAI computer;
    
    /**
     * Construct a Tic Toe Game that one human user can play against 
     * a Computer player with swappable strategies.
     */
    public TicTacToeModel() {
      size = 3;
      initializeBoard();
      computer = new TicTacToeAI();
      computer.setStrategy(/*TODO fill in strategy name*/);
      setChanged();
      notifyObservers();
    }

    private void initializeBoard() {
        
    }
    
}
