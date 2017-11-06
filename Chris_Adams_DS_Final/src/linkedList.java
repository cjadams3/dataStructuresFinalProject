
public class linkedList {
	private songLink first;
	
	public linkedList() {
		first = null;
	}
	public void insert(String title, String artist, String album, int count) {
		songLink newLink = new songLink(title, artist, album, count);
		songLink current = first;
		songLink previous = null;
		
		while(current != null) {
			int compare = artist.compareTo(current.getArtist());
			if (compare > 0) {
				previous = current;
				current = current.next;
			}
			else if (compare == 0) {
				while(current != null) {
					int titleCompare = title.compareTo(current.getArtist());
					if (titleCompare > 0) {
						previous = current;
						current = current.next;
					}
					else {
						break;
					}
					
				}
			}
			else {
				break;
			}
		}
		if (previous == null) {
			first = newLink;
		}
		else {
			previous.next = newLink;
		}
		newLink.next = current;
	}
	public songLink remove() {
		songLink temp = first;
		first = first.next;
		return temp;
	}
	public songLink remove(String song, String artist) {
		songLink current = first;
		songLink previous = null;
		
		while (current != null) {
			int compare = artist.compareTo(current.getArtist());
			if (compare == 0) {
				int titleCompare = song.compareTo(current.getSongTitle());
				if (titleCompare == 0) {
					if(previous == null) {
						songLink temp = first;
						first = first.next;
						return temp;
						
					}
					else {
						previous.next = current.next;
						songLink temp = current;
						return temp;
					}
				}
				else {
					previous = current;
					current = current.next;
				}
			}
			else {
				previous = current;
				current = current.next;
			}
		}
		return null;
	}
	public void play(songLink a) {
		int playCount = a.getPlayCount();
		playCount++;
		a.setPlayCount(playCount);
		return;	
	}
	public void display() {
		System.out.println("List (first --> last): ");
		songLink current = first; // Currently item to print is the first item in the list
		while (current != null) {
			current.displayLink(); // Call to displayLink call to print current item
			current = current.next; // Load current to next item in the list
		}
		System.out.println("");
	}
}
