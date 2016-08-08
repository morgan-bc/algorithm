package searchMethod;

import edu.princeton.cs.algs4.In;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FrequencyCounter {
	public static void main(String[] args) throws FileNotFoundException {
		int minlen = 5;
		int capacity = 100;
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(capacity);
		Scanner sc = new Scanner(new File(args[0]));
		while (sc.hasNext()){
			String word = sc.next();
			if (word.length() < minlen) continue;
			if (!st.contains(word))		st.put(word, 1);
			else 	st.put(word, st.get(word)+1);
		}
	}
}
