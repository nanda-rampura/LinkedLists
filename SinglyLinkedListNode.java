package linkedList;

public class SinglyLinkedListNode
{
	private int data;
	private SinglyLinkedListNode next;
	
	SinglyLinkedListNode(int data)
	{
		this.setData(data);
	}

	SinglyLinkedListNode()
	{
	}
	
	public int getData()
	{
		return data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public SinglyLinkedListNode getNext()
	{
		return next;
	}

	public void setNext(SinglyLinkedListNode next)
	{
		this.next = next;
	}
}