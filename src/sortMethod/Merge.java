package sortMethod;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.princeton.cs.algs4.In;
import introduction.Stopwatch;


public class Merge {
	private static  Comparable[] aux;
	public static void sort ( Comparable[] a) 
	{
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	private static void sort (Comparable[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int mid = lo + (hi -lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	public static void merge (Comparable[] a, int lo, int mid, int hi){
		if (!less(a[mid+1], a[mid]))	return;
		int i, j, k;
		for (k = lo; k <= hi; ++k) 
			aux[k] = a[k];
		i = lo;
		j = mid+1;
		for (k = lo; k <= hi; ++k) {
			if (i > mid)		a[k] = aux[j++];
			else if (j > hi)	a[k] = aux[i++];
			else if (less(aux[i], aux[j]))	a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
	public static void exch (Comparable[]a , int i, int j)
	{
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
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
//		String[] a =in.readAllStrings(); 
		double[] b = in.readAllDoubles();
		Double[] a = new Double[b.length];
		for (int i = 0; i < b.length; i++)
			a[i] = b[i];
		Stopwatch timer = new Stopwatch();
		//show(a);
		sort(a);
		System.out.println(isSorted(a));
		System.out.println(timer.elapsedTime());
//		show(a);
	}
}
