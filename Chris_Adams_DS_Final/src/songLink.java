
public class songLink {
	private String songTitle;
	private String artist;
	private String albumName;
	private int playCount;
	public songLink next;
	public songLink previous;
	
	public songLink(String song, String artist, String album, int count) {
		this.songTitle = song;
		this.artist = artist;
		this.albumName = album;
		this.playCount = count;
		this.next = null;
		this.previous = null;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	public void displayLink() {
		System.out.println("Title: " + songTitle + " Artist: " + artist + " Album: " + albumName + " Play count: " + playCount + " plays");
	}
}
