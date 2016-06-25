package introduction;

import java.util.Iterator;
import java.util.Scanner;

public class ListStack<Item> implements Iterable<Item>
{
	private class Node {
		Item item;
		Node next;
	}
	
	private Node first;
	private int N;
	
	public boolean isEmpty()	{return first == null;}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		--N;
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext()
		{	return current != null;	}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void remove()	{}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListStack<Integer> a = new ListStack<Integer>();
		while (sc.hasNext()){
			a.push(sc.nextInt());
		}
		for (int x: a)
			System.out.println(x);
	}

}

