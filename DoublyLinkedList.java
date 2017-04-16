package linkedList;

public class DoublyLinkedList {
	
	DoublyLinkedListNode head = null;
	
	/* Insertion */
	//Add a node at the front(start or first)//O(n)
	public void addFront(int data)
	{
		DoublyLinkedListNode currnode = new DoublyLinkedListNode();
		DoublyLinkedListNode prevnode = null;
		currnode.setData(data);
		if(head == null)
		{
			 head = currnode;
			 currnode.setNext(null);
			 currnode.setPrevious(null);
		}
		else
		{
			currnode.setNext(head);
			prevnode = head;
			prevnode.setPrevious(currnode);
			currnode.setPrevious(null);
			head = currnode;
		}
	}
	
	//Add a node at the last(end)//O(n)
	public void addLast(int data)
	{
		DoublyLinkedListNode currnode = new DoublyLinkedListNode();
		DoublyLinkedListNode prevnode = head;
		
		if(isEmpty())
		{
			addFront(data);
		}
		else
		{
			while(true)
			{
				if(prevnode.getNext() == null)
				{
					currnode.setData(data);
					currnode.setNext(null);
					currnode.setPrevious(prevnode);
					prevnode.setNext(currnode);
					break;
				}
				else
				{
					prevnode = prevnode.getNext();
				}
			}
		}
	}
	
	//Add a node after a given node//O(n)
	public void addAfter(int existingData, int newData)
	{
		DoublyLinkedListNode currnode = new DoublyLinkedListNode();
		DoublyLinkedListNode prevnode = head;
		DoublyLinkedListNode nextnode = null;
		while(!isEmpty())
		{
			if(prevnode.getData() == existingData)
			{
				if(prevnode.getNext() != null)
				{
					currnode.setData(newData);
					currnode.setNext(prevnode.getNext());
					currnode.setPrevious(prevnode);
					prevnode.setNext(currnode);
					nextnode = prevnode.getNext();
					nextnode.setPrevious(currnode);
				}
				else
				{
					currnode.setData(newData);
					currnode.setNext(prevnode.getNext());
					currnode.setPrevious(prevnode);
					prevnode.setNext(currnode);						
				}
				break;
			}
			else
			{
				prevnode = prevnode.getNext();
				if(prevnode == null)
				{
					break;
				}
			}
		}
	}
		
	// Before a given node.//O(n)
	public void addBefore(int existingData, int newData)
	{
		DoublyLinkedListNode currnode = new DoublyLinkedListNode();
		DoublyLinkedListNode prevnode = null;
		DoublyLinkedListNode nextnode = head;
		while(!isEmpty())
		{
			if(nextnode.getData() == existingData)
			{
				currnode.setData(newData);
				currnode.setNext(nextnode);
				currnode.setPrevious(nextnode.getPrevious());
				prevnode = nextnode.getPrevious();
				nextnode.setPrevious(currnode);

				if(nextnode == head)
				{
					head = currnode;
				}
				else
				{
					prevnode.setNext(currnode);
				}
				break;					
			}
			else
			{
				nextnode = nextnode.getNext();
				if(nextnode == null)
				{
					break;
				}
			}
		}
	}
	
	public boolean deleteElement(int data)
	{
		DoublyLinkedListNode currNode = head;
		DoublyLinkedListNode nextNode = null;
		DoublyLinkedListNode prevNode = null;
		while(!isEmpty())
		{
			if(currNode.getData() == data)
			{
				if(currNode == head)
				{
					nextNode = currNode.getNext();
					nextNode.setPrevious(currNode.getPrevious());
					head = nextNode;
				}
				else
				{
					nextNode = currNode.getNext();
					if(nextNode != null)
					{
						nextNode.setPrevious(currNode.getPrevious());
					}
					prevNode.setNext(currNode.getNext());
				}
				return true;
			}
			else
			{
				prevNode = currNode;
				currNode = prevNode.getNext();
				if(prevNode.getNext() == null)
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
		DoublyLinkedListNode currNode = head;
		DoublyLinkedListNode prevNode = null;
		DoublyLinkedListNode nextNode = null;
		if((i < 0 || i >= size()))
		{
			return false;
		}
		while(!isEmpty())
		{
			index = index + 1;
			if(index == i)
			{
				if(currNode == head)
				{
					nextNode = currNode.getNext();
					nextNode.setPrevious(currNode.getPrevious());;
					head = currNode.getNext();
				}
				else if(currNode.getNext() == null)
				{
					prevNode.setNext(currNode.getNext());
				}
				else
				{
					nextNode = currNode.getNext();
					nextNode.setPrevious(currNode.getPrevious());
					prevNode.setNext(nextNode);
				}
				break;
			}
			else
			{
				prevNode = currNode;
				currNode = prevNode.getNext();
			}
		}
		return true;
	}

	//Reseverse a list //O(n)
	public void reverse()
	{
		DoublyLinkedListNode nextNode = head;
		DoublyLinkedListNode prevNode = null;
		DoublyLinkedListNode prevPrevNode = null;
		while(head != null)
		{
			prevPrevNode = prevNode;
			prevNode = nextNode;
			nextNode = prevNode.getNext();
			prevNode.setNext(prevPrevNode);
			prevNode.setPrevious(nextNode);
			if(nextNode == null)
			{
				head = prevNode;
				break;
			}
		}
	}
	
	// print size of the list //O(n)
	public int size()
	{
		int count = 0;
		DoublyLinkedListNode node = head;
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
	
	// clear all the elements in the list
	public void clear()
	{		
		while(!isEmpty())
		{
			head = null;
		}
	}
	
	//check is the list empty or not
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	// print the elements in the list	//O(n)
	public void printData()
	{
		DoublyLinkedListNode currnode = head;
		while(!isEmpty())
		{
			System.out.print(currnode.getData()+ " ");
			if(currnode.getNext() == null)
			{
				break;
			}
			else
			{
				currnode = currnode.getNext();
			}
		}
		System.out.println();
		System.out.println();
	}

}