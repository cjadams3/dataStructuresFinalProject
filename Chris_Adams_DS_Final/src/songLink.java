
public class songLink {
	private String songTitle; // Properties of the songLink class
	private String artist;
	private String albumName;
	private int playCount;
	public songLink next;
	public songLink previous;
	/**
	 * Constructor of the songLink class, creates new songLink item
	 * @param song
	 * @param artist
	 * @param album
	 * @param count
	 */
	public songLink(String song, String artist, String album, int count) {
		this.songTitle = song; // Load songLink item properties from elements passed in
		this.artist = artist;
		this.albumName = album;
		this.playCount = count;
		this.next = null;
		this.previous = null;
	}
	/**
	 * Getter method for the songTitle element of the songLink class
	 * @return
	 */
	public String getSongTitle() {
		return songTitle;
	}
	/**
	 * Setter method for the songTitle element of the songLink class
	 * @param songTitle
	 */
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	/**
	 * Getter method for the Artist element of the songLink class
	 * @return
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * Setter method for the Artist element of the songLink class
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * Getter method for the Album element of the songLink class
	 * @return
	 */
	public String getAlbumName() {
		return albumName;
	}
	/**
	 * Setter method for the Album element of the songLink class
	 * @param albumName
	 */
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	/**
	 * Getter method for the playCount element of the songLink class
	 * @return
	 */
	public int getPlayCount() {
		return playCount;
	}
	/**
	 * Setter method for the playCount element of the songLink class
	 * @param playCount
	 */
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	/**
	 * Display elements of the current songLink item
	 */
	public void displayLink() {
		System.out.println("Title: " + songTitle + " Artist: " + artist + " Album: " + albumName + " Play count: " + playCount + " plays");
	}
}
