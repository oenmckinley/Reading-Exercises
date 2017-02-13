import java.util.Objects;

public class Program {
	
	// Problem 1
	public static boolean contains (double[] arr, double eps, double d1) {
		for (double d2: arr) {
			if ((d1-d2 < eps) && (-eps < d1-d2)) {
				return true;
			}
		}
		return false;
	}
	
	// Problem 2
	public static int fastExp(int x, int y) {
		if (y < 0) {
			throw new IllegalArgumentException();
		} else if (y == 0) { 
			return 1;
		} else if (y % 2 == 0) {
			return fastExp (x*x, y/2);
		} else {
			return x * fastExp (x*x, (y-1)/2);
		}
	}
	
	// Problem 3
	public static Pair[] allPairs(int[] arr) {
		if (arr.length == 0) {
			throw new IllegalArgumentException();
		}
		
		int len = arr.length;
		Pair[] pairs = new Pair[len*len];
		
		for (int i = 0; i < len; i++){
			for (int j = 0; j < len; j++){
				pairs[i*len+j] = new Pair(arr[i],arr[j]);
			}
		}
		return pairs;
	}
	
	// Problem 4
	public static String concatAndReplicateAll (String[] arr, int reps) {
		String result = "";
		for (String str: arr) {
			for (int i = 0; i < reps; i++) {
				result += str;
			}
		}
		return result;
	}
	
	//Problem 5
	public static int[] interleave(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int minlen;
		if (arr1.length < arr2.length){
			minlen = arr1.length;
		} else {
			minlen = arr2.length;
		}
		for (int i = 0; i < minlen; i++) {
			result[2 * i] = arr1[i];
			result[2 * i + 1] = arr2[i];
		}
		for (int i = minlen; i < arr1.length; i++) {
			result[minlen + i] = arr1[i];
		}
		for (int i = minlen; i < arr2.length; i++) {
			result[minlen + i] = arr2[i];
		}
		return result;
	}

	public static void main(String[] args) {

		// Problem 1 testing
		double[] arr1 = {-1, 2, 3};
		System.out.println(contains(arr1, 4, 10));
		System.out.println(contains(arr1, 4, 2.5));
		
		// Problem 2 testing
		System.out.println(fastExp(2, 10));
		
		// Problem 3 testing
		int[] arr3 = { 3, 5, 9 };
		Pair[] pairs = allPairs(arr3);
		System.out.printf("{ ");
		for (Pair pair: pairs) {
			System.out.printf("(%d, %d), ", pair.getFst(), pair.getSnd());
		}
		System.out.printf(" }\n");
		
		// Problem 4 testing
		String[] arr4 = {"foo", "bar", "hello", "world", "!"};
		System.out.println(concatAndReplicateAll(arr4, 3));
		
		//Problem 5 testing
		int[] arr51 = {0, 1, 2, 10};
		int[] arr52 = {3, 4, 5};
		int[] arr53 = interleave(arr51, arr52);
		for (int n: arr53) {
			System.out.println(n);	
		}
	}
}
