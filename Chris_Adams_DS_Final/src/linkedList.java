
public class linkedList {
	private songLink first;
	private int nElems;
	
	public linkedList() {
		first = null;
		nElems = 0;
	}
	public void insert(String title, String artist, String album, int count) {
		songLink newLink = new songLink(title, artist, album, count);
		nElems++;
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
			if (first != null) {
				songLink temp = first;
				temp.previous = newLink;
			}
			first = newLink;
			first.previous = null;
		}
		else {
			if (previous.next != null) {
				songLink temp = previous.next;
				temp.previous = newLink;
				}
			previous.next = newLink;
			newLink.previous = previous;
		}
		newLink.next = current;
	}
	public songLink remove() {
		songLink temp = first;
		first = first.next;
		nElems--;
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
						nElems--;
						return temp;
						
					}
					else {
						previous.next = current.next;
						songLink temp = current;
						nElems--;
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
	public void songSort() {
		songLink previous = null;
		for(songLink link1 = first;link1 != null; link1 = link1.next) {
			songLink min = link1;
			for(songLink link2 = link1; link2 != null; link2 = link2.next) {
				int songCompare = min.getSongTitle().compareTo(link2.getSongTitle());
				if (songCompare > 0) min = link2;
			}
			if (min != link1) {
				if (previous == null) {
					songLink temp = first;
					songLink tempPrev = min.previous;
					songLink tempNext = min.next;
					songLink oldTempNext = link1.next;
					if (tempNext == link1 || oldTempNext == min) {
						min.next = link1;
						link1.previous = min;
						link1.next = tempNext;
						if (tempNext != null) tempNext.previous = link1;
					}
					else {
						oldTempNext.previous = min;
						tempPrev.next = temp;
						min.next = temp.next;
						temp.previous = min.previous;
						temp.next = tempNext;
						if (tempNext != null) tempNext.previous = link1;
					}
					first = min;
					previous = first;
					link1 = min;
					display();
				}
				else if (previous == first){
					songLink tempPrev = min.previous;
					songLink tempNext = min.next;
					songLink oldTempPrev = link1.previous;
					songLink oldTempNext = link1.next;
					if (tempNext == link1 || oldTempNext == min) {
						min.next = link1;
						link1.previous = min;
						link1.next = tempNext;
						oldTempPrev.next = min;
						if (tempNext != null) tempNext.previous = link1;
					}
					else {
						tempPrev.next = link1;
						link1.next = tempNext;
						link1.previous = tempPrev;
						oldTempPrev.next = min;
						min.next = link1.next;
						min.previous = oldTempPrev;
						if (tempNext != null) tempNext.previous = link1;
					}
					link1 = min;
					previous = first.next;
					display();
				}
				else {
					songLink tempPrev = min.previous;
					songLink tempNext = min.next;
					songLink oldTempPrev = link1.previous;
					songLink oldTempNext = link1.next;
					if (tempNext == link1 || oldTempNext == min) {
						min.next = link1;
						link1.previous = min;
						link1.next = tempNext;
						oldTempPrev.next = min;
						if (tempNext != null) tempNext.previous = link1;
					}
					else {
						tempPrev.next = link1;
						link1.next = tempNext;
						link1.previous = tempPrev;
						oldTempPrev.next = min;
						min.next = link1.next;
						min.previous = oldTempPrev;
						if (tempNext != null) tempNext.previous = link1;
					}
					previous.next = min;
					previous = previous.next;
					link1 = min;
				}
			}	
			
		}
	}
}
