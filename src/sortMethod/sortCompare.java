package sortMethod;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String name = "D:/Documents/java/data/doubleSort.txt";
		int N = 10000;
		genDoubles(name, N);

	}

}
