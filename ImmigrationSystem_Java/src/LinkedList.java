package immigrationSystem;

// This class has the structure and methods to create a linked list with the values from the
// class Person. 
public class LinkedList<E> {
	private Node first;
	private Node last;
	private int nodeCount;

	// Initialisation of the LinkedList class.
	public LinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}

	// This method adds a new person to the end of the list.
	public void addNewPerson(Person person) {
		// Add the first person if the list is empty
		if (first == null) {
			first = new Node(person);
			last = first;
		}
		// If the list has people, we just add a new one.
		else {
			Node newLastNode = new Node(person);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		nodeCount++;
	}

	// This method adds a new person to any given index in the list
	public void addNewPersonAnyIndex(int ip, Person person) {

		if (nodeCount + 1 < ip) {
			throw new IllegalStateException("The list is smaller than the position required");
		}
		Node currentNode = first;
		// Pick a position not as index.
		for (int i = 0; i < ip - 2 && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}
		Node newNode = new Node(person);
		Node nextNode = currentNode.getNextNode();
		newNode.setNextNode(nextNode);
		currentNode.setNextNode(newNode);
		nodeCount++;
	}

	// This method adds a new person always to the first position.
	public void addNewPersonToTheFirstPosition(Person person) {
		if (first == null) {
			first = new Node(person);
			last = first;
		} else {
			Node currentNode = first;
			Node newLastNode = new Node(person);
			Node nextNode = currentNode;
			newLastNode.setNextNode(nextNode);
			first = newLastNode;
		}
		nodeCount++;
	}

	// If the total number of people in the list is odd, the person will be
	// placed 1 position before the meddle
	// E.g: total = 3, then person will be in the second position, and the new
	// total will be 4.
	public Person addNewPersonToTheMidleOfTheList(Person person) {
		if (first == null) {
			first = new Node(person);
			last = first;
		}
		Node currentNode = first;
		// Pick a position not as index.
		for (int i = 1; i < nodeCount / 2 && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}
		Node newNode = new Node(person);
		Node nextNode = currentNode.getNextNode();
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nodeCount++;
		return null;
	}

	// This method checks the position of a person by comparing first name and
	// last name.
	public int checkPositionByName(String fn, String ln) {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		for (int i = 0; i < size() && currentNode != null; i++) {
			if (currentNode.getNodeItem().getFirstName().equals(fn)
					&& currentNode.getNodeItem().getLastName().equals(ln)) {
				return i + 1;
			}
			currentNode = currentNode.getNextNode();
		}
		return -1;
	}

	// This method checks the position of a person by comparing The unique ID
	// number.
	public boolean isEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}
	}

	public int checkPositionById(int id) {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		for (int i = 0; i < size() && currentNode != null; i++) {
			if (currentNode.getNodeItem().getId() == id) {
				return i + 1;
			}
			currentNode = currentNode.getNextNode();
		}
		return -1;
	}

	// This method updates the information of a person without change there
	// position in the list.
	public Person updatePersonById(int id, String fn, String ln, String doa, String pn) {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		for (int i = 0; i < size() && currentNode != null; i++) {
			if (currentNode.getNodeItem().getId() == id) {
				currentNode.getNodeItem().setFirstName(fn);
				currentNode.getNodeItem().setLastName(ln);
				currentNode.getNodeItem().setDateOfArrival(doa);
				currentNode.getNodeItem().setPassportNumber(pn);
			}

			currentNode = currentNode.getNextNode();
		}
		return null;
	}

	public void removeFirstPosition() {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		first = first.getNextNode();
		currentNode.nextNode = null;
		nodeCount--;
	}

	// This method removes all the information of a person by the unique ID
	// number.
	public Person removePersonById(int id) {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		Node prevNode = first;
		for (int i = 0; i < size() && currentNode != null; i++) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
			if (currentNode.getNodeItem().getId() == id) {
				prevNode.setNextNode(currentNode.getNextNode());
				nodeCount--;
			}
		}
		return null;
	}

	// This method removes all the information of a number of people from the
	// end of the list.
	public Person removeNPersonFromTheEndOfTheList(int num) {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		for (int i = 0; i < size(); i++) {
			currentNode = currentNode.getNextNode();
		}
		nodeCount = nodeCount - num;
		return null;
	}

	// This method gets the information from the nodeItem in the class Node to
	// print the full list
	// to the screen.
	public void printList() {

		if (size() > 0) {
			System.out.printf("%45s", "Full List");
			System.out.println();
			System.out.printf("%-4s %-14s %-29s %-20s %-20s", "ID", "First Name", "Last name", "Date of Arrival",
					"Passport Number");
			System.out.println("\n");
			Node currentNode = first;
			for (int i = 0; i < size() && currentNode != null; i++) {
				System.out.println(currentNode.nodeItem);
				currentNode = currentNode.getNextNode();
			}
		}

		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}

	}

	// This method is called every time another method needs to get the full
	// size of the list.
	public int size() {
		return nodeCount;
	}

	// This class gets the objects from the class Person to be passed to the
	// LinkedList class.
	// It contains, get and sets to get from the first object to the last object
	// in the class Person.
	private class Node {
		private Node nextNode;
		private Person nodeItem;

		public Node(Person person) {
			this.nextNode = null;
			this.nodeItem = person;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public Person getNodeItem() {
			return nodeItem;
		}
	}
}
