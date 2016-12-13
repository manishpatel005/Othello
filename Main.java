import java.io.IOException;

public class Main {
    static View view;
    static Player player1;
    static Player player2;
    static GameState nextState;
    static GameStateIterator gameIterator;
    private static String playPlayer(Player player, String move) throws IOException {
        try {
            player.setNextMove(move);
            move = player.getNextMove();
            nextState = gameIterator.getNextGameState(move);
            view.update(nextState);
            if(player.equals(player1)) {
                    System.out.println("Player 1 move -: " + move);
            } else {
                    System.out.println("Player 2 move -: " + move);
            }
            if(gameIterator.isGameFinished()) {
		        if(gameIterator.getWinner() == 'W') {
		            view.display("Player 2 is Winner");
		        } if(gameIterator.getWinner() == 'B') {
		            view.display("Player 1 is Winner");
		        } else if(gameIterator.getWinner() == 'D') {
		        	view.display("Game Drawn");
		        }
            }
        } catch(InvalidMoveException exception) {
            System.out.println("Wrong Move : " + exception.getMessage());
        	if(player.equals(player1)) {
                view.display("Player 2 is Winner");
            } else {
                view.display("Player 1 is Winner");
            }
        }
        return move;
    }
    public static void main(String[] args) throws IOException {
        player1 = new Player(8001, 8000);
        player2 = new Player(9001, 9000);
        nextState = new GameState();
		gameIterator = new GameStateIterator();
        view = new View();
        view.update(nextState);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
		        view.setVisible(true);
            }
        });
        String move = new String("ST");
        while(true) {
                move = playPlayer(player1, move);
                move = playPlayer(player2, move);
        }
    }
}
