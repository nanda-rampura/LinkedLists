package linkedList;

public class SinglyLinkedList
{
	SinglyLinkedListNode head = null;
		
	/* Insertion */
	//Add a node at the front(start or first)
	public void addFront(int data) //O(1)
	{
		SinglyLinkedListNode node = new SinglyLinkedListNode();
		node.setData(data);
		if(head == null)
		{
			 head = node;
			 node.setNext(null);
		}
		else
		{
			node.setNext(head);
			head = node;
		}
	}
	
	//Add a node at the last(end)
	public void addLast(int data) //O(n)
	{
		SinglyLinkedListNode currentNode = head;
		if(head == null)
		{
			addFront(data);
		}
		else
		{
			while(true)
			{
				if(currentNode.getNext() != null)
				{
					currentNode = currentNode.getNext();
				}
				else
				{
					SinglyLinkedListNode newNode = new SinglyLinkedListNode();
					currentNode.setNext(newNode);
					newNode.setData(data);
					newNode.setNext(null);
					break;
				}
			}
		}
	}
	
	//Add a node after a given node //O(n)
	public void addAfter(int existingData, int newData)
	{
		SinglyLinkedListNode currentNode = head;
		while(currentNode != null)
		{
			if(currentNode.getData() != existingData)
			{
				currentNode = currentNode.getNext();
			}
			else
			{
				SinglyLinkedListNode newNode = new SinglyLinkedListNode();
				newNode.setData(newData);
				newNode.setNext(currentNode.getNext());
				currentNode.setNext(newNode);
				break;
			}
		}
	}
	
	// Return a node at a given index //O(n)
	public int getElementAt(int i)
	{
		int elem = 0;
		int index = -1;
		SinglyLinkedListNode nextNode = head;
		SinglyLinkedListNode prevNode = null;
		if((i < 0 || i >= size()))
		{
			return -1;
		}
		while(true)
		{
			index = index + 1;
			if(index == i)
			{
				elem = nextNode.getData();
				break;
			}
			else
			{
				prevNode = nextNode;
				nextNode = prevNode.getNext();
			}
		}		
		return elem;
	}
	
	/* Deletion */
	// Delete a node //O(n)
	public boolean deleteElement(int data)
	{
		SinglyLinkedListNode nextNode = head;
		SinglyLinkedListNode prevNode = null;
		while(head != null)
		{
			if(nextNode.getData() == data)
			{
				if(nextNode == head)
				{
					head = nextNode.getNext();
				}
				else
				{
					prevNode.setNext(nextNode.getNext());
				}
				return true;
			}
			else
			{
				prevNode = nextNode;
				nextNode = prevNode.getNext();
				if(nextNode == null)
				{
					return false;
				}
			}
		}
		return false;
	}
	
	// Delete a node at a given index //O(n)
	public boolean deleteAt(int i)
	{
		int index = -1;
		SinglyLinkedListNode nextNode = head;
		SinglyLinkedListNode prevNode = null;
		if((i < 0 || i >= size()))
		{
			return false;
		}
		while(true)
		{
			index = index + 1;
			if(index == i)
			{
				if(nextNode == head)
				{
					head = nextNode.getNext();
				}
				else
				{
					prevNode.setNext(nextNode.getNext());
				}
				break;
			}
			else
			{
				prevNode = nextNode;
				nextNode = prevNode.getNext();
			}
		}
		return true;
	}
	
	//Reseverse a list //O(n)
	public void reverse()
	{
		SinglyLinkedListNode nextNode = head;
		SinglyLinkedListNode prevNode = null;
		SinglyLinkedListNode prevPrevNode = null;
		while(head != null)
		{
			prevPrevNode = prevNode;
			prevNode = nextNode;
			nextNode = prevNode.getNext();
			prevNode.setNext(prevPrevNode);
			if(nextNode == null)
			{
				head = prevNode;
				break;
			}
		}
	}
	
	//check whether the particular element exists in the Linked List or not //O(n)
	public boolean contains(int elemToBeSearched)
	{
		SinglyLinkedListNode nextNode = head;
		SinglyLinkedListNode prevNode = null;
		while(head != null)
		{
			if(nextNode.getData() == elemToBeSearched)
			{
				return true;
			}
			else
			{
				prevNode = nextNode;
				nextNode = prevNode.getNext();
				if(nextNode == null)
				{
					return false;
				}
			}
		}
		return false;
	}
	
	// Merge two sorted linked lists	
	public static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2)
	{
		SinglyLinkedList list3 = new SinglyLinkedList();
		int i = 0;
		int j = 0;
		while((i < list1.size()) && (j < list2.size()))
		{
			if(list1.getElementAt(i) < list2.getElementAt(j))
			{
				list3.addLast(list1.getElementAt(i));
				i++;
			}
			else if(list1.getElementAt(i) > list2.getElementAt(j))
			{
				list3.addLast(list2.getElementAt(j));
				j++;
			}
			else if(list1.getElementAt(i) == list2.getElementAt(j))
			{
				list3.addLast(list2.getElementAt(j));
				j++;
			}
		}
		if(i == list1.size())
		{
			for(int k = j; k < list2.size(); k++)
			{
				list3.addLast(list2.getElementAt(k));
			}
		}
		else if(j == list2.size())
		{
			for(int l = i; l < list1.size(); l++)
			{
				list3.addLast(list1.getElementAt(l));
			}
		}
		
		return list3;
	}
	
	//Swap nodes in a linked list without swapping data
	public void swap(int elem1, int elem2)
	{
		SinglyLinkedListNode currNodeFirst = head;
		SinglyLinkedListNode currNodeSecond = null;
		SinglyLinkedListNode prevNodeFirst = null;
		SinglyLinkedListNode prevNodeSecond = null;
		while(!isEmpty())
		{
			if(currNodeFirst.getData() == elem1)
			{
				currNodeSecond = currNodeFirst.getNext();
				while(!isEmpty())
				{
					if(currNodeSecond.getData() == elem2)
					{
						SinglyLinkedListNode temp1;
						if(head == currNodeFirst && currNodeSecond != currNodeFirst.getNext())
						{
							prevNodeSecond.setNext(currNodeFirst);
							
							temp1 = currNodeSecond.getNext();
							currNodeSecond.setNext(currNodeFirst.getNext());
							currNodeFirst.setNext(temp1);
							head = currNodeSecond;
							break;
						}
						else if(head == currNodeFirst && currNodeSecond == currNodeFirst.getNext())
						{
							temp1 = currNodeSecond.getNext();
							currNodeSecond.setNext(currNodeFirst);
							currNodeFirst.setNext(temp1);
							head = currNodeSecond;
							break;
						}
						else if(currNodeSecond == currNodeFirst.getNext() || (currNodeSecond.getNext() == null && currNodeSecond == currNodeFirst.getNext()))
						{
							prevNodeFirst.setNext(currNodeSecond);
							
							temp1 = currNodeSecond.getNext();
							currNodeSecond.setNext(currNodeFirst);
							currNodeFirst.setNext(temp1);	
							break;
						}
						else 
						{
							prevNodeSecond.setNext(currNodeFirst);
							prevNodeFirst.setNext(currNodeSecond);
							
							temp1 = currNodeSecond.getNext();
							currNodeSecond.setNext(currNodeFirst.getNext());
							currNodeFirst.setNext(temp1);
							break;
						}
					}
					else
					{
						prevNodeSecond = currNodeSecond;
						currNodeSecond = prevNodeSecond.getNext();
						if(currNodeSecond == null)
						{
							break;
						}
					}
				}
				break;
			}
			else
			{
				prevNodeFirst = currNodeFirst;
				currNodeFirst = prevNodeFirst.getNext();
				if(currNodeFirst.getNext() == null)
				{
					break;
				}
			}
		}
	}
	
	public int findNthToTheLastElement(int n) //O(n)
	{
		SinglyLinkedListNode nextNode = head;
		int linkSize = size();
		if (n > linkSize)
		{
			// return error;
		}
		int i = ((linkSize-1)-n+1);
		while (i-- != 0)
		{
			nextNode = nextNode.getNext();
		}
		return nextNode.getData();		
	}
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	// print size of the list //O(n)
	public int size()
	{
		int count = 0;
		SinglyLinkedListNode node = head;
		while(head != null)
		{
			count++;
			if(node.getNext() != null)
			{
				node = node.getNext();
			}
			else
			{
				break;
			}
		}
		return count;
	}

	public void printData()
	{
		SinglyLinkedListNode node = head;
		System.out.print("List contains: ");
		while(node != null)
		{
			System.out.print(node.getData()+ " ");
			node = node.getNext();
		}
		System.out.println();
		System.out.println();
	}
}
