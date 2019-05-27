package tennis.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {

	Game game = new Game("playerOneName", "playerTwoName");
	
	@Test
	public void playerOneScorePointTest() {
		Game game = new Game("playerOneName", "playerTwoName");
		game.playerScorePoint(1);
		assertEquals(1, game.getLastGamePoint().getPlayerOneScore());
		assertEquals(0, game.getLastGamePoint().getPlayerTwoScore());
	}
	
	@Test
	public void playerTwoScorePointTest() {
		Game game = new Game("playerOneName", "playerTwoName");
		game.playerScorePoint(2);
		assertEquals(0, game.getLastGamePoint().getPlayerOneScore());
		assertEquals(1, game.getLastGamePoint().getPlayerTwoScore());
	}
	
	@Test
	public void playerOneWinGameTest() {
		Game game = new Game("playerOneName", "playerTwoName");
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(1);
		game.playerScorePoint(1);
		game.playerScorePoint(1);
		assertEquals(6, game.getLastGamePoint().getPlayerOneScore());
		assertEquals(-1, game.getLastGamePoint().getPlayerTwoScore());
	}
	
	@Test
	public void playerTwoWinGameTest() {
		Game game = new Game("playerOneName", "playerTwoName");
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(2);
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(2);
		assertEquals(-1, game.getLastGamePoint().getPlayerOneScore());
		assertEquals(6, game.getLastGamePoint().getPlayerTwoScore());
	}
	
	@Test
	public void deuceGameTest() {
		Game game = new Game("playerOneName", "playerTwoName");
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(2);
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(1);
		assertEquals(4, game.getLastGamePoint().getPlayerOneScore());
		assertEquals(4, game.getLastGamePoint().getPlayerTwoScore());
	}
	
	@Test
	public void playerOneAdvTest() {
		Game game = new Game("playerOneName", "playerTwoName");
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(2);
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(1);
		game.playerScorePoint(1);
		assertEquals(5, game.getLastGamePoint().getPlayerOneScore());
		assertEquals(4, game.getLastGamePoint().getPlayerTwoScore());
	}
	
	@Test
	public void playerTwoAdvTest() {
		Game game = new Game("playerOneName", "playerTwoName");
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(2);
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(1);
		game.playerScorePoint(1);
		game.playerScorePoint(2);
		game.playerScorePoint(2);
		assertEquals(4, game.getLastGamePoint().getPlayerOneScore());
		assertEquals(5, game.getLastGamePoint().getPlayerTwoScore());
	}
	
	@Test
	public void deuceGameTestAfterAdv() {
		Game game = new Game("playerOneName", "playerTwoName");
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(2);
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		game.playerScorePoint(1);
		game.playerScorePoint(2);
		game.playerScorePoint(1);
		assertEquals(4, game.getLastGamePoint().getPlayerOneScore());
		assertEquals(4, game.getLastGamePoint().getPlayerTwoScore());
	}
}
