package tennis.kata;

public enum GameScoreTypes {
	
	ZERO ("   0  "),
	FIFTEEN ("  15  "),
	THIRTEEN ("  30  "),
	FOURTEEN ("  40  "),
	DEUCE (" DEUCE"),
	ADV ("  ADV "),
	GAME("GAME W"),
	LOOSER("   -  ");
	   
	private String gameScore = "";
	   
	GameScoreTypes(String gameScore){
	  this.gameScore = gameScore;
	}
	
	@Override
	public String toString(){
	  return gameScore;
	}
}
