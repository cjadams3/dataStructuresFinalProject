
public class linkTester {

	public static void main(String[] args) {
		linkedList myList = new linkedList();
		
		myList.insert("Set Fire to the Rain", "Adele", "21", 8); // Insert elements into linked list, sort by artist
		myList.insert("I'm a Believer", "The Monkees", "Last Train to Clarksville", 4);
		myList.insert("Hey Jude", "The Beatles", "Abbey Road", 5);
		myList.insert("I and Love and You", "The Avett Brothers", "I and Love and You", 4);
		myList.insert("Even Flow", "Pearl Jam", "Ten", 7);
		myList.insert("Something","The Beatles","Abbey Road", 8);
		myList.insert("Would?", "Alice In Chains", "Dirt", 2);
		myList.insert("Fade Into You", "Mazzy Star", "So Tonight That I Might See", 6);
		myList.insert("Fell On Black Days", "Soundgarden", "Superunknown", 7);
		myList.insert("Far Behind", "Candlebox", "Candlebox", 4);
		myList.insert("Operator", "Jim Croce", "You Don't Mess Around With Jim", 6);
		myList.insert("Fortunate Son","Creedence Clearwater Revival", "Willy and the Poor Boys", 3);
		myList.insert("Who Are You", "The Who", "Who Are You", 6);
		myList.insert("Come Together", "The Beatles", "Abbey Road", 11);
		myList.insert("Come Together", "Aerosmith", "Aerosmith: Greatest Hits", 4);
		myList.libraryCount(); // Display number of songs in music library
		myList.display(); // Display contents of the linked list
		myList.remove(); // Remove the first item in the list
		myList.remove("Fade Into You", "Mazzy Star"); // Remove an item in the list, given the song title and artist
		myList.songSort(); // Sort linked list based on song title
		myList.display(); // Display contents of the linked list
		myList.artistSort(); // Sort linked list based on artist name
		myList.display(); // Display contents of the linked list
		myList.albumSort(); // Sort linked list based on album name
		myList.display(); // Display contents of the linked list
		myList.play("Operator", "Jim Croce"); // Play songs, add 1 to play count 
		myList.play("Come Together", "Aerosmith");
		myList.play("Who Are You", "The Who");
		myList.play("Fell On Black Days", "Soundgarden");
		myList.countSort(); // Sort linked list based on play count
		myList.display(); // Display contents of the linked list
		myList.libraryCount(); // Display number of songs in music library

	}

}
