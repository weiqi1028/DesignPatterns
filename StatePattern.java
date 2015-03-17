interface CDPlayerState {
	public void insert();
	public void eject();
	public void play();
}

class NoCDState implements CDPlayerState {
	private CDPlayer player;
	
	public NoCDState(CDPlayer player) {
		this.player = player;
	}
	
	public void insert() {
		System.out.println("A CD is inserted successfully");
		player.changeState(player.getHasCDState());
	}

	public void eject() {
		System.out.println("No CD in the player");
	}

	public void play() {
		System.out.println("No CD in the player, please insert a CD");
	}
	
}

class HasCDState implements CDPlayerState {
	private CDPlayer player;
	
	public HasCDState(CDPlayer player) {
		this.player = player;
	}
	
	public void insert() {
		System.out.println("A CD is already in the player, you can not insert another one");
	}

	public void eject() {
		System.out.println("CD is ejected successfully");
		player.changeState(player.getNoCDState());
	}

	public void play() {
		System.out.println("Playing the CD");
		player.changeState(player.getPlayingCDState());
	}
	
}

class PlayingCDState implements CDPlayerState {
	private CDPlayer player;
	
	public PlayingCDState(CDPlayer player) {
		this.player = player;
	}
	
	public void insert() {
		System.out.println("A CD is playing, you can not insert another one");
	}

	public void eject() {
		System.out.println("Stop playing the CD, the CD is ejected successfully");
		player.changeState(player.getNoCDState());
	}

	public void play() {
		System.out.println("The CD is playing now");
	}
	
}

class CDPlayer {
	private CDPlayerState noCD;
	private CDPlayerState hasCD;
	private CDPlayerState playingCD;
	
	private CDPlayerState curState;
	
	public CDPlayer() {
		noCD = new NoCDState(this);
		hasCD = new HasCDState(this);
		playingCD = new PlayingCDState(this);
		curState = noCD;
	}
	
	public CDPlayerState getNoCDState() {
		return noCD;
	}
	
	public CDPlayerState getHasCDState() {
		return hasCD;
	}
	
	public CDPlayerState getPlayingCDState() {
		return playingCD;
	}
	
	public void changeState(CDPlayerState newState) {
		curState = newState;
	}
	
	public void insert() {
		curState.insert();
	}
	
	public void eject() {
		curState.eject();
	}
	
	public void play() {
		curState.play();
	}
}

public class StatePattern {
	public static void main(String[] args) {
		CDPlayer player = new CDPlayer();
		player.eject();
		player.play();
		player.insert();
		player.play();
		player.play();
		player.eject();
		player.insert();
		player.eject();
	}
}
