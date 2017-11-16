
public class linkTester {

	public static void main(String[] args) {
		linkedList myList = new linkedList();
		
		myList.insert("Set Fire to the Rain", "Adele", "21", 8);
		myList.insert("I'm a believer", "The Monkees", "Last Train to Clarksville", 4);
		myList.insert("Hey Jude", "The Beatles", "Abbey Road", 5);
		myList.insert("I and Love and You", "The Avett Brothers", "I and Love and You", 4);
		myList.display();
		myList.songSort();

	}

}
