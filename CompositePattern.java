import java.util.ArrayList;
import java.util.Iterator;

abstract class SongComponent {
	public abstract void display();
	public void add(SongComponent component) {
		throw new UnsupportedOperationException();
	};
}

class SongGroup extends SongComponent {
	private String name;
	private String description;
	private ArrayList<SongComponent> components = new ArrayList<SongComponent>();
	
	public SongGroup(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	private String getName() {
		return name;
	}
	
	private String getDescription() {
		return description;
	}
	
	public void add(SongComponent component) {
		components.add(component);
	}
	
	public void display() {
		System.out.println(getName() + ", " + getDescription());
		for (Iterator i = components.iterator(); i.hasNext();) {
			SongComponent song = (SongComponent) i.next();
			song.display();
		}
	}

}

class SingleSong extends SongComponent {
	private String name;
	private String artist;
	
	public SingleSong(String name, String artist) {
		this.name = name;
		this.artist = artist;
	}
	
	private String getName() {
		return name;
	}
	
	private String getArtist() {
		return artist;
	}
	
	public void display() {
		System.out.println("Song: " + getName() + ", Artist: " + getArtist());
	}
}

class DJ {
	private SongComponent list;
	
	public DJ(SongComponent list) {
		this.list = list;
	}
	
	public void play() {
		list.display();
	}
}
public class CompositePattern {
	public static void main(String[] args) {
		SongComponent rockMusic = new SongGroup("Rock music", "I love rock music");
		SongComponent heavyMetal = new SongGroup("Heave metal music", "This is heavy metal music");
		SongComponent punk = new SongGroup("Punk music", "This is punk music");
		
		heavyMetal.add(new SingleSong("New divide", "Linkin park"));
		heavyMetal.add(new SingleSong("Faint", "Linkin park"));
		punk.add(new SingleSong("punk music 1", "punker 1"));
		punk.add(new SingleSong("punk music 2", "punker 2"));
		rockMusic.add(heavyMetal);
		rockMusic.add(punk);
		rockMusic.add(new SingleSong("Wake me up when September ends", "Green day"));
		
		DJ dj = new DJ(rockMusic);
		dj.play();
	}
}
