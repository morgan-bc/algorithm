package introduction;
import java.util.Scanner;

// Quick find method in union find

public class UF 
{
	private int[] id;
	private int count;

	public UF(int N)
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
		return id[p];
	}

	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if (pID == qID )	return;

		// Loop all the number and set the id of number with id pID
		// to be qID. So doing a union will visit the array N times.
		for (int i = 0; i < id.length; ++i){
			if (id[i] == pID)	id[i] = qID;
		} 
		--count;
	}


	// main function to test the method

	public static void main(String[] args) {
		
		final long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		UF uf = new UF(N);
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