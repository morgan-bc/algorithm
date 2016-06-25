package introduction;

import java.util.Iterator;
import java.util.Scanner;

public class ListQueue<Item> implements Iterable<Item>
{
	private class Node {
		Item item;
		Node next;
	}
	private Node first, last;
	private int N;
	public boolean isEmpty()	{return first == null;}
	public int getSize()		{return N;}
	public void push(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty())	first = last;
		else oldlast.next = last;
		N++;
	}
	public Item pop() {
		if (isEmpty()) 	return null;
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext()	{return current != null;}
		public Item next () {
			Item item = current.item;
			current = current.next;	    
		    return item;
		}
		public void remove() {}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListQueue<Integer> a = new ListQueue<Integer>();
		while (sc.hasNext()){
			a.push(sc.nextInt());
		}
		for (int x: a)
			System.out.println(x);
	}

}
