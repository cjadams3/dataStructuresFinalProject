
public class linkedList {
	private songLink first; // Set properties of the linkedList class
	private int nElems;
	/**
	 * Constructor for the linkedList class, set first item as null, 0 elements in the list
	 */
	public linkedList() {
		first = null;
		nElems = 0;
	}
	/**
	 * Insert method of the linkedList class, inserts a new songLink class item into the list,
	 * song title, artists, album, and play count is passed in, item is sorted into the list - first
	 * by artist, then by song title
	 * @param title
	 * @param artist
	 * @param album
	 * @param count
	 */
	public void insert(String title, String artist, String album, int count) {
		songLink newLink = new songLink(title, artist, album, count); // Create new songLink item
		nElems++; 
		songLink current = first;
		songLink previous = null; // Prepare to loop through list to place new item
		boolean found = false;
		
		while(current != null && !found) { // Continue to process through list, until end or until place in list is found
			int compare = artist.compareTo(current.getArtist());
			if (compare > 0) { // Is artist alphabetically after current item compared
				previous = current;
				current = current.next; // Load next item to compare
			}
			else if (compare == 0) { // Is artist the same as current item compared
				while(current != null) { // Loop through artists until end
					if (artist.equals(current.getArtist())) { // Loop as long as artist to compare is same as current item
						int titleCompare = title.compareTo(current.getSongTitle());
						if (titleCompare > 0) { // Is song title alphabetically after current item compared
							previous = current;
							current = current.next; // Load next item to compare
						}
						else {
							found = true; // Spot to place in list is found
							break; // Spot in list found, break out of loop
						} 
					}
					else {
						found = true; // Spot to place in list is found
						break; // Spot in list found, break out of loop
					}
				}
			}
			else {
				found = true;
				break; // Spot in list found, break out of loop
			}
		}
		if (previous == null) { 
			if (first != null) { // Is there a first item in the list
				songLink temp = first; // Replace first item in the list
				temp.previous = newLink;
			}
			first = newLink; // First item in linked List doesn't exist, make this item the first
			first.previous = null;
		}
		else {
			if (previous.next != null) { // Is item being added to the end of the list
				songLink temp = previous.next; // Item is not added to end of list
				temp.previous = newLink;
				}
			previous.next = newLink; // Item is being added to end of list
			newLink.previous = previous;
		}
		newLink.next = current; // Load next element of the new Item added
	}
	/**
	 * Remove method of the linked List class, takes no arguments, removes the first item in the list
	 * @return
	 */
	public songLink remove() {
		songLink temp = first;
		first = first.next; // Change first item in the list
		nElems--;
		return temp; // Return removed item
	}
	/**
	 * Remove method of the linked List class, takes arguments that removes item based on song title and artist
	 * @param song
	 * @param artist
	 * @return
	 */
	public songLink remove(String song, String artist) {
		songLink current = first;
		songLink previous = null; // Prepare for loop to remove from list
		
		while (current != null) { // Loop until item is found or end of list
			int compare = artist.compareTo(current.getArtist());
			if (compare == 0) { // Was artist found
				int titleCompare = song.compareTo(current.getSongTitle());
				if (titleCompare == 0) { // Was song title found
					if(previous == null) { // Is item the first item in the list
						songLink temp = first; // Remove first item from the linked List
						first = first.next;
						nElems--;
						return temp; // Return item removed
						
					}
					else {
						previous.next = current.next; // Item is not first item in list, change pointers to remove current item
						songLink temp = current;
						nElems--;
						return temp; // Return removed item
					}
				}
				else {
					previous = current; // Song title does not match, move to next item
					current = current.next;
				}
			}
			else {
				previous = current; // Artist does not match, move to next item
				current = current.next;
			}
		}
		return null; // Item not found, return null
	}
	/**
	 * Play method of the linkedList class, plays the song and increments the play count
	 * @param a
	 */
	public void play(songLink a) {
		int playCount = a.getPlayCount(); // Get play count from songLink getPlayCount() method
		playCount++;
		a.setPlayCount(playCount); // Set play count using songLink setPlayCount() method
		return;	
	}
	/**
	 * Display method of the linkedList class, loops through songLink items and prints them to the console
	 */
	public void display() {
		System.out.println("List (first --> last): ");
		songLink current = first; // Currently item to print is the first item in the list
		while (current != null) {
			current.displayLink(); // Call to displayLink call to print current item
			current = current.next; // Load current to next item in the list
		}
		System.out.println("");
	}
	/**
	 * songSort method of the linkedList class, sorts songLink items based on song title
	 */
	public void songSort() {
		songLink previous = null;
		for(songLink link1 = first;link1 != null; link1 = link1.next) { // Outer loop to get element to swap
			songLink min = link1;
			for(songLink link2 = link1; link2 != null; link2 = link2.next) { // Inner loop to find swapper element based on song title
				int songCompare = min.getSongTitle().compareTo(link2.getSongTitle());
				if (songCompare > 0) {
					min = link2; // New minimum is found
				}
				else if (songCompare == 0) {
					if (min != link2) {
						int artistCompare = min.getArtist().compareTo(link2.getArtist());
						if (artistCompare > 0) min = link2;
					}
				}
					
			}
			songLink resultArray[] = Swap(min, link1, previous); // Call to Swap() method to swap two elements
			min = resultArray[0]; // Load new minimum value
			link1 = resultArray[1]; // Load new outer loop pointer value
			previous = resultArray[2]; // Load new previous songLink element value
		}
	} 
	/**
	 * Swap method of the linkedList class, swaps two elements of a linked List
	 * @param min
	 * @param link1
	 * @param previous
	 * @return
	 */
	public songLink[] Swap(songLink min, songLink link1, songLink previous) {
		if (min != link1) { // Is minimum element already in the correct place?
			if (previous == null) { // Is first element in the list the one to swap?
				songLink temp = first;
				songLink tempPrev = min.previous;
				songLink tempNext = min.next;
				songLink oldTempNext = link1.next;
				if (tempNext == link1 || oldTempNext == min) { // Are elements to swap next to each other?
					min.next = link1; // Swap pointers
					link1.previous = min;
					link1.next = tempNext;
					if (tempNext != null) tempNext.previous = link1; // Is minimum element last in list?
				}
				else { // Elements to swap are not next to each other
					oldTempNext.previous = min; // Swap pointers
					tempPrev.next = temp;
					min.next = oldTempNext;
					temp.previous = min.previous;
					temp.next = tempNext;
					if (tempNext != null) tempNext.previous = link1; // Is minimum element last in list?
				}
				first = min;
				previous = first;
				link1 = min; // Change outer loop element
			}
			else if (previous == first){ // Is item to swap second item in list?
				songLink tempPrev = min.previous; // Swap pointers
				songLink tempNext = min.next;
				songLink oldTempPrev = link1.previous;
				songLink oldTempNext = link1.next;
				if (tempNext == link1 || oldTempNext == min) { // Are elements to swap next to each other?
					min.next = link1; // Swap pointers
					link1.previous = min;
					link1.next = tempNext;
					oldTempPrev.next = min;
					oldTempNext.previous = min;
					if (tempNext != null) tempNext.previous = link1; // Is minimum element last in list?
				}
				else { // Elements to swap are not next to each other
					tempPrev.next = link1; // Swap pointers
					link1.next = tempNext;
					link1.previous = tempPrev;
					oldTempPrev.next = min;
					oldTempNext.previous = min;
					min.next = oldTempNext;
					min.previous = oldTempPrev;
					if (tempNext != null) tempNext.previous = link1; // Is minimum element list in list?
				}
				link1 = min; // Change outer loop element
				previous = first.next;
			}
			else {
				songLink tempPrev = min.previous; 
				songLink tempNext = min.next;
				songLink oldTempPrev = link1.previous;
				songLink oldTempNext = link1.next;
				if (tempNext == link1 || oldTempNext == min) { // Are elements to swap next to each other?
					min.next = link1; // Swap pointers
					link1.previous = min;
					link1.next = tempNext;
					oldTempPrev.next = min;
					oldTempNext.previous = min;
					if (tempNext != null) tempNext.previous = link1; // Is minimum element last in list?
				}
				else {
					tempPrev.next = link1; // Swap pointers
					link1.next = tempNext;
					link1.previous = tempPrev;
					oldTempPrev.next = min;
					oldTempNext.previous = min;
					min.next = oldTempNext;
					min.previous = oldTempPrev;
					if (tempNext != null) tempNext.previous = link1; // Is minimum element last in list?
				}
				previous.next = min;
				previous = previous.next;
				link1 = min; // Change outer loop element
			}
		}
		else { // Minimum element is in the correct position, no need to swap
			previous.next = min;
			previous = previous.next;
			link1 = min; // Change outer loop element
		}
	return new songLink[] {min, link1, previous}; // Return array with results of the swap
	}
}
