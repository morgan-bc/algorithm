package sortMethod;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.princeton.cs.algs4.In;
import introduction.Stopwatch;

public class Shell {
	public static void sort ( Comparable[] a) 
	{
		int N = a.length;
		int h = 1; 
		while(h < N/3) h = 3*h +1;
		while(h >= 1){
			for (int i = 0; i < N; i++)
				for (int j = i; j >=h && less(a[j], a[j-h]); j-=h)
					exch(a, j, j-h);
			h = h/3;
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
		double[] b =in.readAllDoubles();
		int n = b.length;
		Double[] a = new Double[n];
		for (int i = 0; i < n; ++i)
			a[i] = b[i];
 		//show(a);
		Stopwatch timer = new Stopwatch();
		sort(a);
		//assert isSorted(a);
		System.out.println(isSorted(a));
		System.out.println(timer.elapsedTime());
	
	}
}
