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

