package tennis.kata;

public class TestUtil {
	
	
	static void scoreGame(int playerNum, Set set) {
		for (int i=0; i<4; i++) {
			set.playerScorePoint(playerNum);			
		}
	}
	
	static void scoreFiveGames(int playerNum, Set set) {
		for (int i=0; i<5; i++) {
			scoreGame(playerNum, set);
		}
	}
	
	static void scoreFivePointsTieBreak(int playerNum, Set set) {
		for (int i=0; i<5; i++) {
			set.playerScorePoint(playerNum);
		}
	}
}
