// Quick union find in union find
package introduction;


import java.util.Scanner;

public class QuickUnionUF 
{
	private int[] id;
	private int count;

	public QuickUnionUF(int N)
	{
		count = N;
		id = new int[N];
		for (int i = 0; i < N; ++i)
			id[i] = i;
	}
	public int count()
	{	return count;	}
	public boolean connected(int p, int q)
	{	return find(p) == find(q); 	}
	public int find (int p) {
		while (p != id[p]) p = id[p];
		return p;
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot )	return;

		// Loop all the number and set the id of number with id pID
		// to be qID. So doing a union will visit the array N times.
		id[pRoot] = id[qRoot];	
		--count;
	}


	// main function to test the method

	public static void main(String[] args) 
	{
		final long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println("The size of test array is " + N);
		QuickUnionUF uf = new QuickUnionUF(N);

		while (sc.hasNext()) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			uf.union(p, q);
			//System.out.println(p + " " + q);
		}
		System.out.println(uf.count() + " components");
		long end = System.currentTimeMillis();
		double usedTime = (end - start)/1000.0;
		System.out.println("The total used time is " + usedTime + "seconds");
	}
}