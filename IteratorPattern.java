import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class SongInfo {
	private String name;
	private String artist;
	
	public SongInfo(String name, String artist) {
		this.name = name;
		this.artist = artist;
	}
	
	public String getName() {
		return name;
	}
	
	public String getArtist() {
		return artist;
	}
}

interface SongIterator {
	public Iterator getIterator();
}

class RockMusicList implements SongIterator {
	private ArrayList<SongInfo> list = new ArrayList<SongInfo>();
	
	public RockMusicList() {
		list.add(new SongInfo("Bad", "Michael Jackson"));
		list.add(new SongInfo("New divide", "Linkin Park"));
		list.add(new SongInfo("Wake me when September ends", "Green Day"));
	}
	
	public void addSong(SongInfo song) {
		list.add(song);
	}
	
	public Iterator getIterator() {
		return list.iterator();
	}
}

class PopMusicList implements SongIterator {
	private HashMap<Integer, SongInfo> map = new HashMap<Integer, SongInfo>();
	private int key = 0;
	
	public PopMusicList() {
		addSong(new SongInfo("As long as you love me", "Backstreet boys"));
		addSong(new SongInfo("Just one last dance", "Sarah Connor"));
		addSong(new SongInfo("Yesterday once more", "The Carpenters"));
	}
	
	public void addSong(SongInfo song) {
		map.put(key, song);
		key++;
	}
	
	public Iterator getIterator() {
		return map.values().iterator();
	}
}

class MusicPlayer {
	private SongIterator rockList;
	private SongIterator popList;
	
	public MusicPlayer(SongIterator rock, SongIterator pop) {
		this.rockList = rock;
		this.popList = pop;
	}
	
	public void play() {
		System.out.println("Playing rock music");
		playList(rockList.getIterator());
		System.out.println("\nPlaying pop music");
		playList(popList.getIterator());
	}
	
	private void playList(Iterator iterator) {
		while(iterator.hasNext()) {
			SongInfo song = (SongInfo) iterator.next();
			System.out.println("Song: " + song.getName() + ", Artist: " + song.getArtist());
		}
	}
}


public class IteratorPattern {
	public static void main(String[] args) {
		RockMusicList rock = new RockMusicList();
		PopMusicList pop = new PopMusicList();
		MusicPlayer player = new MusicPlayer(rock, pop);
		player.play();
	}
}
