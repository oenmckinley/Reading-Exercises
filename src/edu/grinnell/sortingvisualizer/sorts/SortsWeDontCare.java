package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;

public class SortsWeDontCare {
	
	public static void insertionSort(ArrayList<Integer> l) {
		for (int i = 1; i < l.size(); i++) {
			Integer temp = l.get(i);
			for (int x = 0; x <= i; x++) {
				while (l.get(x) < temp) {
					x++;
					continue;
				}
				if (x == i) {
					l.set(x, temp);
				} else {
					int temp2 = l.get(x);
					l.set(x, temp);
					temp = temp2;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		for (int i = 10; i > 0; i--) {
			l1.add(i);
			l2.add(11-i);
		}
		Sorts.insertionSort(l1);
		System.out.println(l1.get(1)+ "+"+ l2.get(1));
	}

}
