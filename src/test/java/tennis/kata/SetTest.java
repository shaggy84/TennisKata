package tennis.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SetTest {

	@Test
	public void playerOneScoreGameTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreGame(1, set);
		assertEquals(1, set.getScoreSet().getPlayerOneScore());
		assertEquals(0, set.getScoreSet().getPlayerTwoScore());
	}
	
	@Test
	public void playerTwoScoreGameTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreGame(2, set);
		assertEquals(0, set.getScoreSet().getPlayerOneScore());
		assertEquals(1, set.getScoreSet().getPlayerTwoScore());
	}
	
	@Test
	public void playerOneScoreSetTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreFiveGames(1, set);
		TestUtil.scoreGame(2, set);
		TestUtil.scoreGame(2, set);
		TestUtil.scoreGame(1, set);
		assertEquals(6, set.getScoreSet().getPlayerOneScore());
		assertEquals(2, set.getScoreSet().getPlayerTwoScore());
		assertEquals("playerOneName", set.getWinner());
	}
	
	@Test
	public void playerTwoScoreSetTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreFiveGames(2, set);
		TestUtil.scoreGame(2, set);
		assertEquals(0, set.getScoreSet().getPlayerOneScore());
		assertEquals(6, set.getScoreSet().getPlayerTwoScore());
		assertEquals("playerTwoName", set.getWinner());
	}
	
	@Test
	public void playerOneScoreSetAtSevenTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreFiveGames(1, set);
		TestUtil.scoreFiveGames(2, set);
		TestUtil.scoreGame(1, set);
		TestUtil.scoreGame(1, set);
		assertEquals(7, set.getScoreSet().getPlayerOneScore());
		assertEquals(5, set.getScoreSet().getPlayerTwoScore());
		assertEquals("playerOneName", set.getWinner());
	}
	
	@Test
	public void playerTwoScoreSetAtSevenTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreFiveGames(1, set);
		TestUtil.scoreFiveGames(2, set);
		TestUtil.scoreGame(2, set);
		TestUtil.scoreGame(2, set);
		TestUtil.scoreGame(1, set);
		assertEquals(5, set.getScoreSet().getPlayerOneScore());
		assertEquals(7, set.getScoreSet().getPlayerTwoScore());
		assertEquals("playerTwoName", set.getWinner());
	}
	
	@Test
	public void activatTieBreakTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreFiveGames(1, set);
		TestUtil.scoreFiveGames(2, set);
		TestUtil.scoreGame(2, set);
		TestUtil.scoreGame(1, set);
		assertEquals(6, set.getScoreSet().getPlayerOneScore());
		assertEquals(6, set.getScoreSet().getPlayerTwoScore());
		assertEquals(true, set.hasTieBreakRule());
		assertEquals("No Winner", set.getWinner());
	}
	
	@Test
	public void playerOneScoreTieBreakTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreFiveGames(1, set);
		TestUtil.scoreFiveGames(2, set);
		TestUtil.scoreGame(2, set);
		TestUtil.scoreGame(1, set);
		set.playerScorePoint(1);
		assertEquals(1, set.getScoreTieBreak().getPlayerOneScore());
		assertEquals(0, set.getScoreTieBreak().getPlayerTwoScore());
	}
	
	@Test
	public void playerTwoScoreTieBreakTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreFiveGames(1, set);
		TestUtil.scoreFiveGames(2, set);
		TestUtil.scoreGame(2, set);
		TestUtil.scoreGame(1, set);
		set.playerScorePoint(2);
		assertEquals(0, set.getScoreTieBreak().getPlayerOneScore());
		assertEquals(1, set.getScoreTieBreak().getPlayerTwoScore());
	}
	
	@Test
	public void playerOneWinTieBreakTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreFiveGames(1, set);
		TestUtil.scoreFiveGames(2, set);
		TestUtil.scoreGame(2, set);
		TestUtil.scoreGame(1, set);
		TestUtil.scoreFivePointsTieBreak(1,set);
		set.playerScorePoint(1);
		set.playerScorePoint(1);
		assertEquals(7, set.getScoreTieBreak().getPlayerOneScore());
		assertEquals(0, set.getScoreTieBreak().getPlayerTwoScore());
		assertEquals(7, set.getScoreSet().getPlayerOneScore());
		assertEquals(6, set.getScoreSet().getPlayerTwoScore());
	}
	
	@Test
	public void playerTwoWinTieBreakTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreFiveGames(1, set);
		TestUtil.scoreFiveGames(2, set);
		TestUtil.scoreGame(2, set);
		TestUtil.scoreGame(1, set);
		TestUtil.scoreFivePointsTieBreak(1,set);
		TestUtil.scoreFivePointsTieBreak(2,set);
		set.playerScorePoint(1);
		set.playerScorePoint(2);
		set.playerScorePoint(1);
		set.playerScorePoint(2);
		set.playerScorePoint(2);
		set.playerScorePoint(2);
		assertEquals(7, set.getScoreTieBreak().getPlayerOneScore());
		assertEquals(9, set.getScoreTieBreak().getPlayerTwoScore());
		assertEquals(6, set.getScoreSet().getPlayerOneScore());
		assertEquals(7, set.getScoreSet().getPlayerTwoScore());
		assertEquals("playerTwoName", set.getWinner());
	}
	
	@Test
	public void NoWinnerTieBreakTest() {
		Set set = new Set("playerOneName", "playerTwoName");
		TestUtil.scoreFiveGames(1, set);
		TestUtil.scoreFiveGames(2, set);
		TestUtil.scoreGame(2, set);
		TestUtil.scoreGame(1, set);
		TestUtil.scoreFivePointsTieBreak(1,set);
		TestUtil.scoreFivePointsTieBreak(2,set);
		set.playerScorePoint(1);
		set.playerScorePoint(2);
		set.playerScorePoint(1);
		set.playerScorePoint(2);
		set.playerScorePoint(2);
		assertEquals(7, set.getScoreTieBreak().getPlayerOneScore());
		assertEquals(8, set.getScoreTieBreak().getPlayerTwoScore());
		assertEquals(6, set.getScoreSet().getPlayerOneScore());
		assertEquals(6, set.getScoreSet().getPlayerTwoScore());
		assertEquals("No Winner", set.getWinner());
	}
}
