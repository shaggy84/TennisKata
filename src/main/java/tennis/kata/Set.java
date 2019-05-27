package tennis.kata;

import java.util.ArrayList;
import java.util.List;

public class Set {
	
	private List<Game> gamesSetList = new ArrayList<>();
	private SetGame scoreSet = new SetGame();
	private TieBreakScore tieBreakScore = new TieBreakScore();
	private String playerOneName;
	private String playerTwoName;
	
	public Set(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
		gamesSetList.add(new Game(playerOneName, playerTwoName));
	}

	public SetGame getScoreSet() {
		return scoreSet;
	}
	
	public TieBreakScore getScoreTieBreak() {
		return tieBreakScore;
	}
	
	public void playerScorePoint(int playerNum) {
		if (hasTieBreakRule()) {
			if (!hasTieBreakWinner()) {
				updateScoreTieBreak(playerNum);
			}
		} else {
			if (!hasSetGameWinner()) {
				getlastSetGame().playerScorePoint(playerNum);
				updateSetWhithGameResult();
			}
		}
	}
	
	public String getWinner() {
		String winner = "No Winner";
		if (hasSetGameWinner()) {
			if (scoreSet.getPlayerOneScore() > scoreSet.getPlayerTwoScore()) {
				winner = playerOneName;
			} else {
				winner = playerTwoName;
			}
		}
		if (hasTieBreakWinner()) {
			if (tieBreakScore.getPlayerOneScore() > tieBreakScore.getPlayerTwoScore()) {
				winner = playerOneName;
			} else {
				winner = playerTwoName;
			}
		}
		return winner;
	}
	
	public boolean hasTieBreakRule() {
		return (scoreSet.getPlayerOneScore() >= 6 && scoreSet.getPlayerTwoScore() >= 6);
	}
	
	public void displayScoreSet() {
		StringBuilder scoreOne = new StringBuilder();
		StringBuilder scoreTwo = new StringBuilder();	
		scoreOne.append(gamesSetList.get(gamesSetList.size() - 2).displayScoreGame(1));
		scoreOne.append(scoreSet.getPlayerOneScore());
		scoreOne.append(Constants.DELIMITER);
		scoreTwo.append(gamesSetList.get(gamesSetList.size() - 2).displayScoreGame(2));
		scoreTwo.append(scoreSet.getPlayerTwoScore());
		scoreTwo.append(Constants.DELIMITER);
		if (hasTieBreakRule()) {
			scoreOne.append(" " + tieBreakScore.getPlayerOneScore());
			scoreOne.append(Constants.DELIMITER);
			scoreTwo.append(" " + tieBreakScore.getPlayerTwoScore());
			scoreTwo.append(Constants.DELIMITER);
		}
		System.out.println(scoreOne);
		System.out.println(scoreTwo);
		System.out.println();
	}
	
	private void updateSetWhithGameResult() {
		if (getlastSetGame().getGameEnded()) {
			if (getlastSetGame().getLastGamePoint().getPlayerOneScore() == 6) {
				int playerOneScoreSet = scoreSet.getPlayerOneScore();
				scoreSet.setPlayerOneScore(++playerOneScoreSet);
			} else {
				int playerTwoScoreSet = scoreSet.getPlayerTwoScore();
				scoreSet.setPlayerTwoScore(++playerTwoScoreSet);
			}
			if (!hasSetGameWinner()) {
				gamesSetList.add(new Game(playerOneName, playerTwoName));
			}
		}
	}
	
	private void updateScoreTieBreak(int playerNum) {
		if (playerNum == 1) {
			int playerOneScore = tieBreakScore.getPlayerOneScore();
			tieBreakScore.setPlayerOneScore(++playerOneScore);
		} else if (playerNum == 2) {
			int playerTwoScore = tieBreakScore.getPlayerTwoScore();
			tieBreakScore.setPlayerTwoScore(++playerTwoScore);
		}
		if (hasTieBreakWinner()) {
			if (playerNum == 1) {
				int playerOneScoreSet = scoreSet.getPlayerOneScore();
				scoreSet.setPlayerOneScore(++playerOneScoreSet);
			} else {
				int playerTwoScoreSet = scoreSet.getPlayerTwoScore();
				scoreSet.setPlayerTwoScore(++playerTwoScoreSet);
			}
		}
	}
	
	private Game getlastSetGame() {
		return gamesSetList.get(gamesSetList.size() - 1);
	}
	
	private boolean hasSetGameWinner() {
		boolean hasSetWinner =false;
		if (((scoreSet.getPlayerOneScore() >= 6) && 
				(scoreSet.getPlayerOneScore() >= scoreSet.getPlayerTwoScore() + 2)) || 
			((scoreSet.getPlayerTwoScore() >= 6) && 
				(scoreSet.getPlayerTwoScore() >= scoreSet.getPlayerOneScore() + 2))) {
			hasSetWinner =  true;
		}
		return hasSetWinner;
	}
	
	public boolean hasTieBreakWinner() {
		boolean hasTieBreakWinner =false;
		if (((tieBreakScore.getPlayerOneScore() >= 7) && 
				(tieBreakScore.getPlayerOneScore() >= tieBreakScore.getPlayerTwoScore() + 2)) || 
			((tieBreakScore.getPlayerTwoScore() >= 7) && 
				(tieBreakScore.getPlayerTwoScore() >= tieBreakScore.getPlayerOneScore() + 2))) {
			hasTieBreakWinner=true;
		}
		return hasTieBreakWinner;
	}
}
