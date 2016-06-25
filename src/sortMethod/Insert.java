package sortMethod;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.princeton.cs.algs4.*;


public class Insert {
	public static void sort ( Comparable[] a) 
	{
		
	}
	public static boolean less (Comparable x, Comparable y)
	{ return x.compareTo(y) < 0; }
	public static void show (Comparable[] a)
	{
		for(int i = 0; i < a.length; ++i)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public static boolean isSorted(Comparable[] a)
	{
		for (int i = 1; i < a.length; ++i) {
			if(less(a[i], a[i-1]))	return false;
		}
		return true;
	}
	public static void main(String[] args) throws FileNotFoundException {
		In in = new In(args[0]);
		String[] a =in.readAllStrings(); 
		sort(a);
		assert isSorted(a);
		show(a);
	
	}
}
