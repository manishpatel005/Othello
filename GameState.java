public class GameState {

    private char board[][];
    private char nextPlayer;
    private int blackCount;
    private int whiteCount;
    private String previousMove;
    public GameState() {
        board = new char[8][8];
        nextPlayer = 'B';
        blackCount = 2;
        whiteCount = 2;
        board[3][3] = 'W';
        board[4][4] = 'W';
        board[3][4] = 'B';
        board[4][3] = 'B';
        previousMove = "ST";
    }

    public GameState(GameState gameState) {
        board = gameState.getBoard();
        nextPlayer = gameState.getNextPlayer();
        blackCount = gameState.getBlackCount();
        whiteCount = gameState.getWhiteCount();
    }

    public char getNextPlayer() {
        return nextPlayer;
    }

    public int getBlackCount() {
        return blackCount;
    }

    public int getWhiteCount() {
        return whiteCount;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setPreviousMove(String move) {
    	previousMove = move;
    }
    
    public String getPreviousMove() {
    	return previousMove;
    }
    
    public void changeNextPlayer() {
        if(nextPlayer == 'B') {
            nextPlayer = 'W';
        } else if(nextPlayer == 'W') {
            nextPlayer = 'B';
        }
    }

    public void updateBlackCount() {
        blackCount = 0;
        for(int row = 0; row < 8; row ++) {
            for(int column = 0; column < 8; column ++) {
                if(board[row][column] == 'B') {
                    blackCount++;
                }
            }
        }
    }

    public void updateWhiteCount() {
        whiteCount = 0;
        for(int row = 0; row < 8; row ++) {
            for(int column = 0; column < 8; column ++) {
                if(board[row][column] == 'W') {
                    whiteCount++;
                }
            }
        }
    }

    private boolean canOutflankInUpwardDirection(int row, int column) {
        for(int i = row - 1; i >= 0 && board[i][column] != 0; i--) {
            if(board[i][column] == nextPlayer) {
                if(row - i > 1) {
            		return true;
            	} else {
            		return false;
            	}
            }
        }
        return false;
    }

    private boolean canOutflankInDownwardDirection(int row, int column) {
        for(int i = row + 1; i < 8 && board[i][column] != 0; i++) {
            if(board[i][column] == nextPlayer) {
                if(i - row > 1) {
            		return true;
            	} else {
            		return false;
            	}
            }
        }
        return false;
    }

    private boolean canOutflankInRightDirection(int row, int column) {
        for(int j = column + 1; j < 8 && board[row][j] != 0; j++) {
            if(board[row][j] == nextPlayer) {
                if(j - column > 1) {
            		return true;
            	} else {
            		return false;
            	}
            }
        }
        return false;
    }

    private boolean canOutflankInLeftDirection(int row, int column) {
        for(int j = column - 1; j >= 0 && board[row][j] != 0; j--) {
            if(board[row][j] == nextPlayer) {
                if(column - j > 1) {
            		return true;
            	} else {
            		return false;
            	}
            }
        }
        return false;
    }

    private boolean canOutflankInUpwardLeftDirection(int row, int column) {
        for(int i = row - 1, j = column - 1; i >= 0 && j >= 0 && board[i][j] != 0; i--, j--) {
            if(board[i][j] == nextPlayer) {
                if(row - i > 1) {
            		return true;
            	} else {
            		return false;
            	}
            }
        }
        return false;
    }

    private boolean canOutflankInUpwardRightDirection(int row, int column) {
        for(int i = row - 1, j = column + 1; i >= 0 && j < 8 && board[i][j] != 0; i--, j++) {
            if(board[i][j] == nextPlayer) {
                if(row - i > 1) {
            		return true;
            	} else {
            		return false;
            	}
            }
        }
        return false;
    }

    private boolean canOutflankInDownwardLeftDirection(int row, int column) {
        for(int i = row + 1, j = column - 1; i < 8 && j >= 0 && board[i][j] != 0; i++, j--) {
            if(board[i][j] == nextPlayer) {
                if(i - row > 1) {
            		return true;
            	} else {
            		return false;
            	}
            }
        }
        return false;
    }

    private boolean canOutflankInDownwardRightDirection(int row, int column) {
        for(int i = row + 1, j = column + 1; i < 8 && j < 8 && board[i][j] != 0; i++, j++) {
            if(board[i][j] == nextPlayer) {
            	if(i - row > 1) {
            		return true;
            	} else {
            		return false;
            	}
            }
        }
        return false;
    }

    private void outflankInUpwardDirectionFrom(int row, int column) {
        if(canOutflankInUpwardDirection(row, column)) {
            for(int i = row - 1; board[i][column] != nextPlayer; i--) {
                board[i][column] = nextPlayer;
            }
        }
        updateBlackCount();
        updateWhiteCount();
    }

    private void outflankInDownwardDirectionFrom(int row, int column) {
        if(canOutflankInDownwardDirection(row, column)) {
            for(int i = row + 1; board[i][column] != nextPlayer; i++) {
                board[i][column] = nextPlayer;
            }
        }
        updateBlackCount();
        updateWhiteCount();
    }

    private void outflankInRightDirectionFrom(int row, int column) {
        if(canOutflankInRightDirection(row, column)) {
            for(int j = column + 1; board[row][j] != nextPlayer; j++) {
                board[row][j] = nextPlayer;
            }
        }
        updateBlackCount();
        updateWhiteCount();
    }

    private void outflankInLeftDirectionFrom(int row, int column) {
        if(canOutflankInLeftDirection(row, column)) {
            for(int j = column - 1; board[row][j] != nextPlayer; j--) {
                board[row][j] = nextPlayer;
            }
        }
        updateBlackCount();
        updateWhiteCount();
    }

    private void outflankInUpwardLeftDirectionFrom(int row, int column) {
        if(canOutflankInUpwardLeftDirection(row, column)) {
            for(int i = row - 1, j = column - 1; board[i][j] != nextPlayer; i--, j--) {
                board[i][j] = nextPlayer;
            }
        }
        updateBlackCount();
        updateWhiteCount();
    }

    private void outflankInUpwardRightDirectionFrom(int row, int column) {
        if(canOutflankInUpwardRightDirection(row, column)) {
            for(int i = row - 1, j = column + 1; board[i][j] != nextPlayer; i--, j++) {
                board[i][j] = nextPlayer;
            }
        }
        updateBlackCount();
        updateWhiteCount();
    }

    private void outflankInDownwardLeftDirectionFrom(int row, int column) {
        if(canOutflankInDownwardLeftDirection(row, column)) {
            for(int i = row + 1, j = column - 1; board[i][j] != nextPlayer; i++, j--) {
                board[i][j] = nextPlayer;
            }
        }
        updateBlackCount();
        updateWhiteCount();
    }

    private void outflankInDownwardRightDirection(int row, int column) {
        if(canOutflankInDownwardRightDirection(row, column)) {
            for(int i = row + 1, j = column + 1; board[i][j] != nextPlayer; i++, j++) {
                board[i][j] = nextPlayer;
            }
        }
        updateBlackCount();
        updateWhiteCount();
    }

    public boolean canOutflankAtPostion(int row, int column) throws InvalidMoveException {
        if(board[row][column] != 0) {
            throw new InvalidMoveException("Invalid : Cannot Place a Token on Position Already Occupied");
        }
        if(canOutflankInUpwardDirection(row, column)) {
            return true;
        }
        if(canOutflankInDownwardDirection(row, column)) {
            return true;
        }
        if(canOutflankInLeftDirection(row, column)) {
            return true;
        }
        if(canOutflankInRightDirection(row, column)) {
            return true;
        }
        if(canOutflankInUpwardLeftDirection(row, column)) {
            return true;
        }
        if(canOutflankInUpwardRightDirection(row, column)) {
            return true;
        }
        if(canOutflankInDownwardLeftDirection(row, column)) {
            return true;
        }
        if(canOutflankInDownwardRightDirection(row, column)) {
            return true;
        }
        throw new InvalidMoveException("Invalid : Atleast One piece must be outflanked");
    }

    public boolean canOutflank() {
            for(int row = 0; row < 8; row++) {
                for(int column = 0; column < 8; column++) {
                    try {
                        if(canOutflankAtPostion(row, column)){
                            return true;
                        }
                    } catch(InvalidMoveException e) { }
                }
            }
            return false;
    }

    public void outflankFromPosition(int row, int column) {
            outflankInUpwardDirectionFrom(row, column);
            outflankInDownwardDirectionFrom(row, column);
            outflankInRightDirectionFrom(row, column);
            outflankInLeftDirectionFrom(row, column);
            outflankInDownwardLeftDirectionFrom(row, column);
            outflankInDownwardRightDirection(row, column);
            outflankInUpwardLeftDirectionFrom(row, column);
            outflankInUpwardRightDirectionFrom(row, column);
            board[row][column] = nextPlayer;
            updateBlackCount();
            updateWhiteCount();
    }


    public GameState setMove(String move) throws InvalidMoveException {
    	if(move == null) {
        	throw new InvalidMoveException("Null object exception");
        }
    	
        if(move.length() != 2) {
        	throw new InvalidMoveException("Wrong Move Format");
        }

        if(!move.equals("PS") && ( move.charAt(0) < 'A' || move.charAt(0) > 'H' ||
       	        move.charAt(1) < '0' || move.charAt(1) > '8')) {
        	throw new InvalidMoveException("Wrong Move Format");
        }

        GameState nextState = new GameState(this);
        if(move.equals("PS")) {
            if(canOutflank()) {
                throw new InvalidMoveException("Cannot Pass when you can Outflank");
            } else {
                nextState =  new GameState(this);
            }
        } else {
            int row = move.charAt(1) - '1';
            int column = move.charAt(0) - 'A';
            if(canOutflankAtPostion(row, column)) {
               nextState.outflankFromPosition(row, column);
            }
        }
        nextState.changeNextPlayer();
        nextState.setPreviousMove(move);
        return nextState;
    }
}
