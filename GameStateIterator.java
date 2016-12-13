import java.util.LinkedList;
import java.util.ListIterator;

public class GameStateIterator {
    private LinkedList<GameState> gameList;
    private ListIterator<GameState> gameListIterator;
    private boolean gameFinishedFlag;
    private char winner;
    public GameStateIterator() {
         gameList = new LinkedList<GameState>();
         gameList.add(new GameState());
         gameListIterator = gameList.listIterator();
         gameFinishedFlag = false;
         winner = 0;
    }

    public GameState getNextGameState() {
        if(gameListIterator.hasNext()) {
            return gameListIterator.next();
        } else {
            GameState gameState = gameListIterator.previous();
            gameListIterator.next();
            return gameState;
        }
    }
    public GameState getPreviousGameState() {
        if(gameListIterator.hasPrevious()) {
            return gameListIterator.previous();
        } else {
	    GameState gameState = gameListIterator.next();
            gameListIterator.previous();
            return gameState;
        }
    }

	public void setWinner(char winner) {
		this.winner = winner;
	}
	
	public char getWinner() {
		return winner;
	}
	
	public void setGameFinished() {
		this.gameFinishedFlag = true;
	}

	public boolean isGameFinished() {
		return gameFinishedFlag;
	}
	
    public GameState getNextGameState(String move) throws InvalidMoveException {
        GameState presentGameState = getPreviousGameState();
        gameListIterator.next();
        GameState nextGameState = presentGameState.setMove(move);
        gameListIterator.add(nextGameState);
        
		if(presentGameState.getPreviousMove().equals("PS") && nextGameState.getPreviousMove().equals("PS") ||
				nextGameState.getBlackCount() + nextGameState.getWhiteCount() == 64) {
            gameFinishedFlag = true;
            if(nextGameState.getBlackCount() > nextGameState.getWhiteCount()) {
        		winner = 'B';
            } else if(nextGameState.getBlackCount() < nextGameState.getWhiteCount()) {
	        	winner = 'W';
            } else {
            	winner = 'D';
            }
        }       
        return nextGameState;
    }
}

