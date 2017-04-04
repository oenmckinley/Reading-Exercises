package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortsTests {

	private static final int SIZE = 4;
	
	@Test
	public void testSelectionSort() {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		for (int i = SIZE; i > 0; i--) {
			l1.add(i);
			l2.add(SIZE+1-i);
		}
		Sorts.selectionSort(l1);
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
	
	@Test
	public void testEventSort() {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		for (int i = SIZE; i > 0; i--) {
			l1.add(i);
			l2.add(i);
		}
		Sorts.eventSort(l2, Sorts.insertionSort(l1));
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("worked", l1.get(i), l2.get(i));
		}
	}
	
}
