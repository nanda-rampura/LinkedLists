package linkedList;

public class TestLinkedList {
	public static void main(String[] args) {
		{
			System.out.println("*** Singly-Linked List ***");
			System.out.println("Creating empty list:");
			SinglyLinkedList myList = new SinglyLinkedList();
			System.out.println(myList.isEmpty() == true ? "List is empty" : "List is not empty");
			System.out.println("List size is " + myList.size());
			System.out.println();
			
			System.out.println("Adding 10, 20, 30, 40:");
			myList.addFront(20);
			myList.addLast(40);
			myList.addFront(10);
			myList.addAfter(20, 30);
			System.out.println(myList.isEmpty() == true ? "List is empty" : "List is not empty");
			System.out.println("List size is " + myList.size());
			myList.printData();
	
			System.out.println("Checking if 30 is present:");
			System.out.println("30 is " + (myList.contains(30) ? "present" : "not present"));
			System.out.println("Checking if 50 is present:");
			System.out.println("50 is " + (myList.contains(50) ? "present" : "not present"));
			System.out.println();
			
			System.out.println("Getting element at index 3:");
			System.out.println("Element at index 3: " + myList.getElementAt(3));
			System.out.println("Getting 3rd element from last:");
			System.out.println("3rd element from last: " + myList.findNthToTheLastElement(3));
			System.out.println();
	
			System.out.println("Reversing list:");
			myList.reverse();
			myList.printData();
			
			System.out.println("Swapping elements - 30 and 10:");
			myList.swap(30, 10);
			myList.printData();
			System.out.println("Swapping elements - 40 and 10:");
			myList.swap(40, 10);
			myList.printData();
			System.out.println("Swapping elements - 10 and 30:");
			myList.swap(10, 30);
			myList.printData();
			System.out.println("Swapping elements - 10 and 10:");
			myList.swap(10, 10);
			myList.printData();
	
			System.out.println("Creating a second list:");
			SinglyLinkedList myList2 = new SinglyLinkedList();
			myList2.addLast(100);
			myList2.addLast(200);
			myList2.addLast(300);
			myList2.printData();
	
			System.out.println("Merging two linked lists:");
			SinglyLinkedList mergedList = SinglyLinkedList.merge(myList, myList2);
			mergedList.printData();
			
			System.out.println("Deleting element at index 2:");
			myList.deleteAt(2);
			myList.printData();
			System.out.println("Deleting element with data = 30, 40, 100, 200, 300:");
			myList.deleteElement(30);
			myList.deleteElement(40);
			myList.deleteElement(100);
			myList.deleteElement(200);
			myList.deleteElement(300);
			myList.printData();
			System.out.println("Deleting element at index 0:");
			myList.deleteAt(0);
	
			System.out.println(myList.isEmpty() == true ? "List is empty" : "List is not empty");
			System.out.println("List size is " + myList.size());
			System.out.println();
		}

		{
			System.out.println("*** Doubly-Linked List ***");
			DoublyLinkedList myList = new DoublyLinkedList();
			System.out.println("Creating empty list:");
			System.out.println(myList.isEmpty() == true ? "List is empty" : "List is not empty");
			System.out.println("List size is " + myList.size());
			System.out.println();
			
			System.out.println("Adding 10, 20, 30, 40:");
			myList.addFront(20);
			myList.addLast(40);
			myList.addBefore(20, 10);
			myList.addAfter(20, 30);
			System.out.println(myList.isEmpty() == true ? "List is empty" : "List is not empty");
			System.out.println("List size is " + myList.size());
			myList.printData();
			
			System.out.println("Reversing list:");
			myList.reverse();
			myList.printData();
			
			System.out.println("Deleting element at index 2:");
			myList.deleteAt(2);
			myList.printData();
			System.out.println("Deleting element with data = 10:");
			myList.deleteElement(10);
			myList.printData();
			
			System.out.println("Deleting remaining elements:");
			myList.clear();
			System.out.println(myList.isEmpty() == true ? "List is empty" : "List is not empty");
			System.out.println("List size is " + myList.size());
			System.out.println();
		}
	}
}