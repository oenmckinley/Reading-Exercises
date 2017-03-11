package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;
import java.util.List;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortsTests {

	private static final int SIZE = 10;
	
	@Test
	public void testSelectionSort() {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		for (int i = SIZE; i > 0; i--) {
			l1.add(i);
			l2.add(SIZE+1-i);
		}
		/*List<SortEvent<Integer>> ev = Sorts.selectionSort(l1);
		for (int n = 0; n < ev.size(); n++) {
			ev.get(n).apply(l1);
		}*/
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("worked", l1.get(i), l2.get(i));
		}
	}
	
	@Test
	public void testInsertionSort() {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		for (int i = SIZE; i > 0; i--) {
			l1.add(i);
			l2.add(SIZE+1-i);
		}
		Sorts.insertionSort(l1);
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("worked", l1.get(i), l2.get(i));
		}
	}
	
	@Test
	public void testBubbleSort() {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		for (int i = SIZE; i > 0; i--) {
			l1.add(i);
			l2.add(SIZE+1-i);
		}
		Sorts.bubbleSort(l1);
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("worked", l1.get(i), l2.get(i));
		}
	}
	
	@Test
	public void testMergeSort() {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		for (int i = SIZE; i > 0; i--) {
			l1.add(i);
			l2.add(SIZE+1-i);
		}
		Sorts.mergeSort(l1);
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("worked", l1.get(i), l2.get(i));
		}
	}
	
	@Test
	public void testQuickSort() {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		for (int i = SIZE; i > 0; i--) {
			l1.add(i);
			l2.add(SIZE+1-i);
		}
		Sorts.quickSort(l1);
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("worked", l1.get(i), l2.get(i));
		}
	}
	
	@Test
	public void testShellSort() {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		for (int i = SIZE; i > 0; i--) {
			l1.add(i);
			l2.add(SIZE+1-i);
		}
		Sorts.shellSort(l1);
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("worked", l1.get(i), l2.get(i));
		}
	}
	
}
