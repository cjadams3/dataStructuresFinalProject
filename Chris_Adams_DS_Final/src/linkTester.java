
public class linkTester {

	public static void main(String[] args) {
		linkedList myList = new linkedList();
		
		myList.insert("Set Fire to the Rain", "Adele", "21", 8);
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
		myList.display();
		myList.songSort();
		myList.display();

	}

}
