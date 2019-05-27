package tennis.kata;

import java.util.List;
import java.util.ArrayList;

public class Game {
	
	private List<GamePoint> gameScoresList = new ArrayList<>();
	private String playerOneName;
	private String playerTwoName;
	private boolean gameEnded = false;
	
	public Game(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
		gameScoresList.add(new GamePoint());		
	}
	
	public List<GamePoint> getGameScoresList() {
		return gameScoresList;
	}
	
	public boolean getGameEnded() {
		return gameEnded;
	}
	
	public void playerScorePoint(int playerNum) {
		int playerOneScore = getLastGamePoint().getPlayerOneScore();
		int playerTwoScore = getLastGamePoint().getPlayerTwoScore();
		GamePoint newGamePoint = new GamePoint();
		if (playerNum ==1) {
			newGamePoint.setPlayerOneScore(++playerOneScore);
			newGamePoint.setPlayerTwoScore(playerTwoScore);
		} else {
			newGamePoint.setPlayerTwoScore(++playerTwoScore);
			newGamePoint.setPlayerOneScore(playerOneScore);
		}
		if (!gameEnded) updateScoreList(newGamePoint);
	}

	public GameScoreTypes translatePointToDisplay(int actualPoint) {
		GameScoreTypes point;
		switch (actualPoint) {
		case 0:
			point = GameScoreTypes.ZERO;
			break;
		case 1:
			point = GameScoreTypes.FIFTEEN;
			break;
		case 2:
			point = GameScoreTypes.THIRTEEN;
			break;
		case 3:
			point = GameScoreTypes.FOURTEEN;
			break;
		case 4:
			point = GameScoreTypes.DEUCE;
			break;
		case 5:
			point = GameScoreTypes.ADV;
			break;
		case 6:
			point = GameScoreTypes.GAME;
			break;
		case -1:
			point = GameScoreTypes.LOOSER;
			break;
		default:
			throw new IllegalArgumentException();
		}
		return point;
	}
	
	public GamePoint getLastGamePoint(){
		return gameScoresList.get(this.gameScoresList.size() - 1);
	}
	
	public StringBuilder displayScoreGame(int playerNum) {
		StringBuilder scoreGame = new StringBuilder();
		if (playerNum ==1) {
			scoreGame.append(playerOneName + Constants.SPACE);
			gameScoresList.forEach(point -> scoreGame.append(
					translatePointToDisplay(point.getPlayerOneScore()) 
					+ Constants.SPACE + Constants.DELIMITER));
		} else {
			scoreGame.append(playerTwoName + Constants.SPACE);
			gameScoresList.forEach(point -> scoreGame.append(
					translatePointToDisplay(point.getPlayerTwoScore()) + Constants.SPACE 
					+ Constants.DELIMITER));
		}
		return scoreGame;
	}
	
	private void updateScoreList(GamePoint gamePoint){
		if (hasWinner(gamePoint)) {
			if (gamePoint.getPlayerOneScore() > gamePoint.getPlayerTwoScore()) {
				gamePoint.setPlayerOneScore(6);
				gamePoint.setPlayerTwoScore(-1);
			}else {
				gamePoint.setPlayerOneScore(-1);
				gamePoint.setPlayerTwoScore(6);				
			}
			gameEnded = true; 
		}
		if (isDeuce(gamePoint)) {
			gamePoint.setPlayerOneScore(4);
			gamePoint.setPlayerTwoScore(4);
		}
		if (hasAdvantage(gamePoint)) {
			if (gamePoint.getPlayerOneScore() > gamePoint.getPlayerTwoScore()) {
				gamePoint.setPlayerOneScore(5);
				gamePoint.setPlayerTwoScore(4);
			}else {
				gamePoint.setPlayerOneScore(4);
				gamePoint.setPlayerTwoScore(5);				
			}
		}
		gameScoresList.add(gamePoint);
	}
	
	private boolean isDeuce(GamePoint gamePoint) {
		boolean isDeuce = false;
		if ((gamePoint.getPlayerOneScore() >= 3) && 
				(gamePoint.getPlayerOneScore() == gamePoint.getPlayerTwoScore())) {
					isDeuce = true;
		}
		return isDeuce;
	}
	
	private boolean hasWinner(GamePoint gamePoint) {
		int playerOneScore = gamePoint.getPlayerOneScore();
		int playerTwoScore = gamePoint.getPlayerTwoScore();
		boolean hasWinner = false;
		if ((playerOneScore == 4 && playerTwoScore <3) || 
				(playerTwoScore == 4 && playerOneScore <3) ||
				(playerOneScore >= 4 && playerTwoScore >= playerOneScore + 2) ||
				(playerTwoScore >= 4 && playerTwoScore >= playerOneScore + 2))
			hasWinner = true;
		return hasWinner;
	}
	
	private boolean hasAdvantage(GamePoint gamePoint) {
		boolean hasAdvantage = false;
		if (((gamePoint.getPlayerOneScore() >= 4) && (gamePoint.getPlayerTwoScore() == 5)) || 
				((gamePoint.getPlayerTwoScore() >= 4) && (gamePoint.getPlayerOneScore() == 5))) {
			hasAdvantage =  true;
		}
		return hasAdvantage;
	}
}
