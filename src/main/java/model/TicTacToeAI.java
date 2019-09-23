package model;

import java.awt.Point;

/**
 * This class lets a person choose from a variety of different AIs to play
 * against in Tic Tac Toe. Dependent on TODO insert tictactoe strategy name
 * 
 * @author Wes Rodgers
 *
 */

public class TicTacToeAI {

    // TODO insert tictactoestrategy field

    /**
     * Constructor for the TicTacToeAI
     */
    public TicTacToeAI() {
        // TODO strategy = new strategy();
    }

    /**
     * Setter for strategy type
     */
    public void setStrategy(/* TODO insert strategy here */) {
        // TODO strategy = parameterStrategy;
    }

    /**
     * Asks the strategy what the next move it would make is.
     * 
     * @param ticTacToeModel the current state of the tictactoe game
     * @return a java.awt.Point storing an x and y (row and col) value
     */
    public Point nextMove(TicTacToeModel ticTacToeModel) {
        // TODO return strategy.nextMove(ticTacToeModel);
        return null;
    }

}
