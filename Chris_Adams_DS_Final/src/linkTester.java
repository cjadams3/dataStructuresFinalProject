
public class linkTester {

	public static void main(String[] args) {
		linkedList myList = new linkedList();
		
		myList.insert("Hey Jude", "The Beatles", "Abbey Road", 5);
		myList.insert("Set Fire to the Rain", "Adele", "21", 8);
		myList.insert("I'm a Believer", "The Monkees", "Last Train to Clarksville", 4);
		myList.remove("Hey Jude", "The Beatles");
		myList.display();

	}

}
