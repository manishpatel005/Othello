#include<iostream>
#include<cstdio>
#include<string>
using namespace std;
#define B 1
#define W -1

/*Initial Board configuration*/
int board[8][8]={
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0,
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0,
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0,
0 , 0 , 0 , B , W , 0 , 0 , 0,
0 , 0 , 0 , W , B , 0 , 0 , 0,
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0,
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0,
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0
};

class GameState {
    public :
    	GameState() {
	    }
	   	char getNextPlayer() {
	        return nextPlayer;
	    }
		void setPreviousMove(String move) {
	    	previousMove = move;
	    }
    	bool canOutflankInUpwardDirection(int row, int column, int turn) {
		    for(int i = row - 1; i >= 0 && board[i][column] != 0; i--) {
		        if(board[i][column] == turn) {
		            if(row - i > 1) {
		        		return true;
		        	} else {
		        		return false;
		        	}
		        }
		    }
		    return false;
		}
		bool canOutflankInDownwardDirection(int row, int column, int turn) {
		    for(int i = row + 1; i < 8 && board[i][column] != 0; i++) {
		        if(board[i][column] == turn) {
		            if(i - row > 1) {
		        		return true;
		        	} else {
		        		return false;
		        	}
		        }
		    }
		    return false;
		}

    	bool canOutflankInRightDirection(int row, int column, int turn) {
		    for(int j = column + 1; j < 8 && board[row][j] != 0; j++) {
		        if(board[row][j] == turn) {
		            if(j - column > 1) {
		        		return true;
		        	} else {
		        		return false;
		        	}
		        }
		    }
		    return false;
		}

    	bool canOutflankInLeftDirection(int row, int column, int turn) {
		    for(int j = column - 1; j >= 0 && board[row][j] != 0; j--) {
		        if(board[row][j] == turn) {
		            if(column - j > 1) {
		        		return true;
		        	} else {
		        		return false;
		        	}
		        }
		    }
		    return false;
		}

    	bool canOutflankInUpwardLeftDirection(int row, int column, int turn) {
		    for(int i = row - 1, j = column - 1; i >= 0 && j >= 0 && board[i][j] != 0; i--, j--) {
		        if(board[i][j] == turn) {
		            if(row - i > 1) {
		        		return true;
		        	} else {
		        		return false;
		        	}
		        }
		    }
		    return false;
		}

		bool canOutflankInUpwardRightDirection(int row, int column, int turn) {
		    for(int i = row - 1, j = column + 1; i >= 0 && j < 8 && board[i][j] != 0; i--, j++) {
		        if(board[i][j] == turn) {
		            if(row - i > 1) {
		        		return true;
		        	} else {
		        		return false;
		        	}
		        }
		    }
		    return false;
		}

		bool canOutflankInDownwardLeftDirection(int row, int column, int turn) {
		    for(int i = row + 1, j = column - 1; i < 8 && j >= 0 && board[i][j] != 0; i++, j--) {
		        if(board[i][j] == turn) {
		            if(i - row > 1) {
		        		return true;
		        	} else {
		        		return false;
		        	}
		        }
		    }
		    return false;
		}

		bool canOutflankInDownwardRightDirection(int row, int column, int turn) {
		    for(int i = row + 1, j = column + 1; i < 8 && j < 8 && board[i][j] != 0; i++, j++) {
		        if(board[i][j] == turn) {
		        	if(i - row > 1) {
		        		return true;
		        	} else {
		        		return false;
		        	}
		        }
		    }
		    return false;
		}

		void outflankInUpwardDirectionFrom(int row, int column, int turn) {
		    if(canOutflankInUpwardDirection(row, column, turn)) {
		        for(int i = row - 1; board[i][column] != turn; i--) {
		            board[i][column] = turn;
		        }
		    }
		}

		void outflankInDownwardDirectionFrom(int row, int column, int turn) {
		    if(canOutflankInDownwardDirection(row, column, turn)) {
		        for(int i = row + 1; board[i][column] != turn; i++) {
		            board[i][column] = turn;
		        }
		    }
		}

		void outflankInRightDirectionFrom(int row, int column, int turn) {
		    if(canOutflankInRightDirection(row, column, turn)) {
		        for(int j = column + 1; board[row][j] != turn; j++) {
		            board[row][j] = nextPlayer;
		        }
		    }
		}

		void outflankInLeftDirectionFrom(int row, int column, int turn) {
		    if(canOutflankInLeftDirection(row, column, turn)) {
		        for(int j = column - 1; board[row][j] != turn; j--) {
		            board[row][j] = turn;
		        }
		    }
		}

		void outflankInUpwardLeftDirectionFrom(int row, int column, int turn) {
		    if(canOutflankInUpwardLeftDirection(row, column, turn)) {
		        for(int i = row - 1, j = column - 1; board[i][j] != turn; i--, j--) {
		            board[i][j] = turn;
		        }
		    }
		}

		void outflankInUpwardRightDirectionFrom(int row, int column, int turn) {
		    if(canOutflankInUpwardRightDirection(row, column, turn)) {
		        for(int i = row - 1, j = column + 1; board[i][j] != turn; i--, j++) {
		            board[i][j] = turn;
		        }
		    }
		}

		void outflankInDownwardLeftDirectionFrom(int row, int column, int turn) {
		    if(canOutflankInDownwardLeftDirection(row, column, turn)) {
		        for(int i = row + 1, j = column - 1; board[i][j] != turn; i++, j--) {
		            board[i][j] = turn;
		        }
		    }
		}

		void outflankInDownwardRightDirection(int row, int column, int turn) {
		    if(canOutflankInDownwardRightDirection(row, column, turn)) {
		        for(int i = row + 1, j = column + 1; board[i][j] != turn; i++, j++) {
		            board[i][j] = turn;
		        }
		    }
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

    public void Display()
    {
    	int i, j;
    	for(i=0; i<8; i++)
    	{
    		for(j=0; j<8; j++)
    		{
    			System.out.print(board[i][j] + "\t");
    		}
    		System.out.println("");
    	}
    	System.out.println(nextPlayer + " " + blackCount + " " + whiteCount);
    }
}
string stratagicMove(int turn);
void updateBoard(string move,int turn);
int main()
{
	string opponentMove;
	string myMove;
	int turn=B;
	cin>>opponentMove;
	if(opponentMove=="ST")	//starting signal send by judge.
	{

		/* you are black. Play the first move */
		myMove=stratagicMove(turn);
		updateBoard(myMove,turn);
		cout<<myMove;
		fflush(stdout);
		cin>>opponentMove;
		turn= -turn;

	}
	while(true)
	{
		/* you are white.*/ 
		/* first update the board with black players move*/
		updateBoard(opponentMove,turn);
		/*play your move*/
		turn= -turn;
		myMove=stratagicMove(turn);
		updateBoard(myMove,turn);
		cout<<myMove;
		fflush(stdout);
		cin>>opponentMove;
	}
}	
	
string stratagicMove(int turn)
{
/* play your strategey accordinly whether you are white or black
which is denoted by turn
*/
/* implement your stratage here......*/

	return "A1";
}
void updateBoard(string move,int turn)
{
	if(move=="ST" || move =="PS")
	return;
	
	int row=move[1]-'0';
	int col=move[0]-'A';
	board[row][col]=turn;
}

