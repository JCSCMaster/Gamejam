package model;

/**
 * This exception may be thrown by a TicTacToeStrategy 
 * when it is asked to return the player's move in the
 * case where there are no more move from which to select
 *  
 * @author Rick Mercer
 */
public class IGotNoWhereToGoException extends RuntimeException {

  public IGotNoWhereToGoException(String message) {
    super(message);
  }
}