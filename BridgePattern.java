abstract class ElectronicDevice {
	private int volume = 0;
	
	public void volumeUp() {
		volume++;
	}
	
	public void volumeDown() {
		volume--;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public abstract void previous();
	public abstract void next();
}

abstract class RemoteButton {
	private ElectronicDevice device;
	
	public RemoteButton(ElectronicDevice device) {
		this.device = device;
	}
	
	public void volumeUp() {
		device.volumeUp();
	}
	
	public void volumeDown() {
		device.volumeDown();
	}
	
	public void previous() {
		device.previous();
	}
	
	public void next() {
		device.next();
	}
	
	public abstract void pressRed();
}

class TVRemotePause extends RemoteButton {

	public TVRemotePause(ElectronicDevice device) {
		super(device);
	}

	public void pressRed() {
		System.out.println("TV is paused");
	}
	
}

class TVRemoteMute extends RemoteButton {
	public TVRemoteMute(ElectronicDevice device) {
		super(device);
	}

	public void pressRed() {
		System.out.println("TV is muted");
	}
}

class TelevisionDevice extends ElectronicDevice {
	public void previous() {
		System.out.println("Previous channel");
	}
	
	public void next() {
		System.out.println("Next channel");
	}
}

class CDplayerDevice extends ElectronicDevice {
	public void previous() {
		System.out.println("Previous song");
	}
	
	public void next() {
		System.out.println("Next song");
	}
}

class CDShutDownButton extends RemoteButton {
	public CDShutDownButton(ElectronicDevice device) {
		super(device);
	}

	public void pressRed() {
		System.out.println("CD is shut down");
	}
}

public class BridgePattern {
	public static void main(String[] args) {
		TelevisionDevice tv = new TelevisionDevice();
		RemoteButton tvPause = new TVRemotePause(tv);
		RemoteButton tvMute = new TVRemoteMute(tv);
		
		CDplayerDevice cd = new CDplayerDevice();
		RemoteButton cdShutDown = new CDShutDownButton(cd);
		
		tvPause.volumeUp();
		tvPause.volumeUp();
		tvPause.volumeDown();
		System.out.println("TV volume: " + tv.getVolume());
		tvPause.previous();
		tvPause.next();
		tvPause.pressRed();
		
		tvMute.volumeUp();
		System.out.println("TV volume: " + tv.getVolume());
		tvMute.previous();
		tvMute.next();
		tvMute.pressRed();
		
		cdShutDown.volumeUp();
		cdShutDown.volumeUp();
		cdShutDown.volumeDown();
		System.out.println("CD volume: " + cd.getVolume());
		cdShutDown.previous();
		cdShutDown.next();
		cdShutDown.pressRed();
	}
}
