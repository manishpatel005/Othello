all : p1 p2 client Main.class

p1 : sample_player.cpp
	g++ sample_player.cpp -o p1

p2 : sample_player.cpp
	g++ sample_player.cpp -o p2

client : client.cpp
	g++ client.cpp -o client

Main.class : Player.class GameStateIterator.class InvalidMoveException.class Main.java View.class
	javac Main.java

View.class : View.java
	javac View.java

Player.class : InputSocket.class OutputSocket.class Player.java
	javac Player.java

InputSocket.class : PlayerSocket.class InputSocket.java InvalidMoveException.class
	javac InputSocket.java

OutputSocket.class : PlayerSocket.class OutputSocket.java
	javac OutputSocket.java

PlayerSocket.class : PlayerSocket.java
	javac PlayerSocket.java

GameStateIterator.class : GameState.class InvalidMoveException.class GameStateIterator.java
	javac GameStateIterator.java

GameState.class : InvalidMoveException.class GameState.java
	javac GameState.java

InvalidMoveException.class : InvalidMoveException.java
	javac InvalidMoveException.java

clear :
	rm *.class
	rm p1 p2 client
