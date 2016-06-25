// Quick union find in union find
package introduction;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class PathCompressedUF 
{
	private int[] id;
	private int[] sz;
	private int count;

	public PathCompressedUF(int N)
	{
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; ++i) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	public int getID(int p)	{ return id[p];}
	public int count()
	{	return count;	}
	public boolean connected(int p, int q)
	{	return find(p) == find(q); 	}
	public int find (int p) {
		int r = id[p];
		if (r == id[r])	return r;
		while (r != id[r]) r = id[r];
		int t;
		while (id[p] != r) {
			t = p; 
			id[t] = r;
			p = id[p];
		}	
		return r;
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot )	return;

		// Loop all the number and set the id of number with id pID
		// to be qID. So doing a union will visit the array N times.
		if (sz[pRoot] < sz[qRoot]) {
			id[pRoot] = id[qRoot];
			sz[qRoot] += sz[pRoot];
		}
		else {
			id[qRoot] = id[pRoot];
			sz[pRoot] += sz[qRoot];
		}
		--count;
	}


	// main function to test the method

	public static void main(String[] args) throws FileNotFoundException 
	{
		final long start = System.currentTimeMillis();
		File f = new File(args[0]);
		Scanner sc = new Scanner(f);
		int N = sc.nextInt();
		System.out.println("The size of test array is " + N);
		PathCompressedUF uf = new PathCompressedUF(N);

		while (sc.hasNext()) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			uf.union(p, q);
			//System.out.println(p + " " + q);
			//System.out.println(uf.count() + " components");
		}
		System.out.println(uf.count() + " components");
		long end = System.currentTimeMillis();
		double usedTime = (end - start)/1000.0;
		System.out.println("The total used time is " + usedTime + "seconds");
		//for (int i = 0; i < N; ++i) 
		//	System.out.println(uf.getID(i));
		sc.close();
	}
}