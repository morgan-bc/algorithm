package searchMethod;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private int N;
	private Key[] keys;
	private Value[] vals;
	BinarySearchST(int capacity) {
		N = 0;
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	int rank(Key key) {
		int lo = 0, hi = N -1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp == 0)	return mid;
			else if (cmp < 0) 	hi = mid -1;
			else				lo = mid +1;
		}
		return lo;
	}
	
	public void put (Key key, Value val){
		int i = rank(key);
		if (i < N && keys[i].compareTo(key)==0)
		{vals[i] = val; return;}
		for (int j = N; j > i; j--)
		{keys[j] = keys[j-1]; vals[j] = vals[j-1];}
		keys[i] = key;	vals[i] = val;
		N++;
	}
	
	public Value get(Key key) {
		if (isEmpty())	return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0)	return vals[i];
		else 											return null;
	}
	
	public void delete(Key key) {
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) {
			for (int j = i +1; j < N; j++)
			{keys[j-1] = keys[j]; vals[j-1] = vals[j];}
			N--;
		}
		else	System.out.println(key + "is not in the table");
	}
	
	boolean contains(Key key) {
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0)	return true;
		return false;
	}
	
	boolean isEmpty() {
		return N==0;
	}
	
	int size() { return N; }

	public Key select(int k) {return keys[k]; }
	
	public Value selectVal(int k)	{return vals[k]; }
	
	public void output() {
		for(int i = 0; i < N; i++)
			System.out.println(keys[i] + "\t" + vals[i]);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		int minlen = 6;
		int capacity = 100;
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(capacity);
		Scanner sc = new Scanner(new File(args[0]));
		while (sc.hasNext()){
			String word = sc.next();
			if (word.length() < minlen) continue;
			if (!st.contains(word))		st.put(word, 1);
			else 	st.put(word, st.get(word)+1);
		}
	st.output();
	st.delete("darkness");
	System.out.println("-----------------");
	st.output();
	}
}