package introduction;
import java.util.Iterator;
import java.util.Scanner;

public class ResizingStack<Item> implements Iterable<Item> {

	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	public void resize(int max){
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; ++i)
			temp[i] = a[i];
		a = temp;
	}
	
	public void push (Item item) {
		if (N == a.length) resize(2*N);
		a[N++] = item;
	}
	
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length/4)	resize(a.length/2);
		return item;
	}
	

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}
		
	private class StackIterator implements Iterator<Item> {
		private int i = N;
		public boolean hasNext() { return i > 0;}
		public Item next() {return a[--i];}
		public void remove() {}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ResizingStack<Integer> a = new ResizingStack<Integer>();
		while (sc.hasNext()){
			a.push(sc.nextInt());
		}
		for (int x: a)
			System.out.println(x);
	}

}
