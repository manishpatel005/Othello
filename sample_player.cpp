#include<iostream>
#include<cstdio>
#include<cstring>
#include<string>
using namespace std;
#define B 1
#define W -1

/*Initial Board configuration*/
int board[8][8]={
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0,
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0,
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0,
0 , 0 , 0 , W , B , 0 , 0 , 0,
0 , 0 , 0 , B , W , 0 , 0 , 0,
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0,
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0,
0 , 0 , 0 , 0 , 0 , 0 , 0 , 0
};

class GameState {
    public :
    	GameState() {
    		memset(board, 0, sizeof(board));
    		board[3][3] = board[4][4] = W;
    		board[3][4] = board[4][3] = B;
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
		            board[row][j] = turn;
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

		bool canOutflankAtPostion(int row, int column, int turn) {
        if(board[row][column] != 0) {
           return false;
        }
        if(canOutflankInUpwardDirection(row, column, turn)) {
            return true;
        }
        if(canOutflankInDownwardDirection(row, column, turn)) {
            return true;
        }
        if(canOutflankInLeftDirection(row, column, turn)) {
            return true;
        }
        if(canOutflankInRightDirection(row, column, turn)) {
            return true;
        }
        if(canOutflankInUpwardLeftDirection(row, column, turn)) {
            return true;
        }
        if(canOutflankInUpwardRightDirection(row, column, turn)) {
            return true;
        }
        if(canOutflankInDownwardLeftDirection(row, column, turn)) {
            return true;
        }
        if(canOutflankInDownwardRightDirection(row, column, turn)) {
            return true;
        }
        return false;
    }

    bool canOutflank(int turn) {
            for(int row = 0; row < 8; row++) {
                for(int column = 0; column < 8; column++) {
                        if(canOutflankAtPostion(row, column, turn)){
                            return true;
                        }
                }
            }
            return false;
    }

    void outflankFromPosition(int row, int column, int turn) {
            outflankInUpwardDirectionFrom(row, column, turn);
            outflankInDownwardDirectionFrom(row, column, turn);
            outflankInRightDirectionFrom(row, column, turn);
            outflankInLeftDirectionFrom(row, column, turn);
            outflankInDownwardLeftDirectionFrom(row, column, turn);
            outflankInDownwardRightDirection(row, column, turn);
            outflankInUpwardLeftDirectionFrom(row, column, turn);
            outflankInUpwardRightDirectionFrom(row, column, turn);
            board[row][column] = turn;
    }


	void setMove(string move, int turn) {
		if(move == "PS" || move == "ST")
		return;
        int row = move[1] - '1';
        int column = move[0] - 'A';
        outflankFromPosition(row, column, turn);
    }

    void Display() {
    	int row, column;
    	for(row = 0; row < 8; row++) {
    		for(column = 0; column < 8; column++) {
    			printf("%d\t", board[row][column]);
    		}
    		printf("\n");
    	}
    }

    string generateNextMove(int turn) {
    	int row, column;
    	for(row = 0; row < 8; row++) {
	    	for(column = 0; column < 8; column++) {
    			if(canOutflankAtPostion(row, column, turn)) {
					string st = "  ";
					st[0] = column + 'A';
					st[1] = row + '1';
					return st;
				}
			}
    	}
    	return "PS";
    }
} currentGame;

string stratagicMove(int turn);
void updateBoard(string move,int turn);

int main() {
	string opponentMove;
	string myMove;
	int turn = B;
	cin >> opponentMove;
	if(opponentMove == "ST")	{ //starting signal send by judge.
		/* you are black. Play the first move */
	    myMove = stratagicMove(turn);
		updateBoard(myMove, turn);
		cout << myMove << endl;
		fflush(stdout);
		cin >> opponentMove;
		turn= -turn;

	}
	while(true) {
		/* you are white.*/ 
		/* first update the board with black players move*/
		updateBoard(opponentMove, turn);
		/*play your move*/
		turn = -turn;
		myMove = stratagicMove(turn);
		updateBoard(myMove, turn);
		cout << myMove<<endl;
		fflush(stdout);
		cin >> opponentMove;
		turn = -turn;
	}
}
string stratagicMove(int turn)
{
/* play your strategey accordinly whether you are white or black
which is denoted by turn
*/
/* implement your stratage here......*/
	return currentGame.generateNextMove(turn);
}
void updateBoard(string move,int turn)
{
	currentGame.setMove(move, turn);
}

