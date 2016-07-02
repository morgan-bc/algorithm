package sortMethod;
import java.io.FileNotFoundException;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;;


public class QuickSort {
	
	public static void sort ( Comparable[] a) 
	{
		StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[]a, int lo, int hi) {
		if (lo >= hi) return;
		int j = partrition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	private static int partrition (Comparable[] a, int lo, int hi) {
		
		int i = lo, j = hi+1;
		Comparable v = a[lo];
		while(true){
			while (less(a[++i], v))			if(i == hi) break;
			while (!less(a[--j], v)) 		if(j == lo) break;
			if (i >= j) 	break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
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
		double[] b =in.readAllDoubles();
		Double[] a = new Double[b.length];
		for (int i = 0; i < b.length; ++i)
			a[i] = b[i];
		show(a);
		sort(a);
		System.out.println(isSorted(a));
		show(a);
	
	}
}
