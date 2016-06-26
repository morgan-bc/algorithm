package sortMethod;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import introduction.Stopwatch;

public class sortCompare {

	public static  void genDoubles (String name, int N) throws IOException {
		File file = new File(name);
		if(! file.exists())  file.createNewFile();
		PrintWriter write = new PrintWriter(file);
		long seed = System.currentTimeMillis();
		Random random = new Random(seed); 
		for (int i = 0; i < N; ++i){
			write.println(random.nextDouble());
		}
		write.close();
	}
	public static Double[] genDoubles (int N) {
		Double[] a = new Double[N];
		long seed = System.currentTimeMillis();
		Random random = new Random(seed); 
		for (int i = 0; i < N; ++i)
			a[i] = random.nextDouble();
		return a;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String name = "D:/Documents/java/data/doubleSort.txt";
		int N = 1000000;
		Double[] a = genDoubles(N);
		Stopwatch timer = new Stopwatch();
		MergeBU.sort(a);
		double t1 = timer.elapsedTime();
		System.out.println(Shell.isSorted(a));
		System.out.println("Shell time is " + t1);
		Double[] b = genDoubles(N);
		timer.begin();
		Merge.sort(b);
		System.out.println(Merge.isSorted(b));
		double t2 = timer.elapsedTime();
		System.out.println("select time is " + t2);
		System.out.println("shell is " + t2/t1 + " timers faster than select");
		
	}

}
