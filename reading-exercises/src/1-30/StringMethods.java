
public class StringMethods {

	public static boolean endsWithRep(String s1, String s2, int n) {
		String suffix = s2;
		for (int i = 1; i < n; i++)
			suffix = suffix + s2;
		return s1.endsWith(suffix);
	}
	
	public static void main(String[] args) {
		System.out.println(endsWithRep("scraaa", "a", 3));
		System.out.println(endsWithRep("scraaa", "a", 4));
		System.out.println(endsWithRep("scraaa", "a", 2));
		System.out.println(endsWithRep("foobarbar", "bar", 2));
		System.out.println(endsWithRep("foobarbar", "baz", 3));
	}

}
