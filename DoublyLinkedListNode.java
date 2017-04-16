package linkedList;

public class DoublyLinkedListNode {
	private int data;
	private DoublyLinkedListNode next;
	private DoublyLinkedListNode previous;
	
	public DoublyLinkedListNode getPrevious()
	{
		return previous;
	}
	
	public void setPrevious(DoublyLinkedListNode previous)
	{
		this.previous = previous;
	}
	
	public DoublyLinkedListNode getNext()
	{
		return next;
	}
	
	public void setNext(DoublyLinkedListNode next)
	{
		this.next = next;
	}
	
	public int getData()
	{
		return data;
	}
	
	public void setData(int data)
	{
		this.data = data;
	}
}