package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;




/** Sorts
 * Various sorting algorithms that are implemented on data lists*/
public class Sorts {
	
	/** Selection Sort
	 * @param l: An array list 
	 * @return A list of sorting events
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(ArrayList<T> l) {
		List<SortEvent<T>> ret = new ArrayList<>();
		for (int i = 0; i < l.size(); i++) {
			int minIndex = i;
			for (int j = i; j < l.size(); j++) {
				if (l.get(j).compareTo(l.get(minIndex)) < 0) {
					ret.add(new CompareEvent<>(j, minIndex));
					minIndex = j;
				}
			}
			SortEvent<T> e1=new SwapEvent<>(i, minIndex);
			ret.add(e1);
			e1.apply(l);
		}
		return ret;
	}
	/** Insertion Sort
	 * @param l: An array list 
	 * @return A list of sorting events
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(ArrayList<T> l) {
		List<SortEvent<T>> ret = new ArrayList<>();
		for (int i = 1; i < l.size(); i++) {
			T temp = l.get(i);
			for (int x = 0; x <= i; x++) {
				if (x == i) {
					SortEvent<T> e1= new CopyEvent<>(x,temp);
					ret.add(e1);
					e1.apply(l);
				} else if (l.get(x).compareTo(temp) >= 0) {
					if (l.indexOf(temp) >= 0) {
						ret.add(new CompareEvent<>(x, l.indexOf(temp)));
					}
					T temp2 = l.get(x);
					SortEvent<T> e2= new CopyEvent<>(x,temp);
					ret.add(e2);
					e2.apply(l);
					temp = temp2;
				}
			}
		}
		return ret;
	}
	/** Bubble Sort
	 * @param l: An array list 
	 * @return A list of sorting events
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(ArrayList<T> l) {
		List<SortEvent<T>> ret = new ArrayList<>();
		for (int n = 0; n < l.size(); n++) {
			for (int i = 1; i < l.size(); i++) {
				int temp = i - 1;
				if (l.get(temp).compareTo(l.get(i)) > 0) {
					ret.add(new CompareEvent<>(temp, i));
					SortEvent<T> e1= new SwapEvent<>(i,temp);
					ret.add(e1);
					e1.apply(l);
					
				}
			}
		}
		return ret;
	}
	/** Merge
	 * @param l: An array list 
	 * @param lo an integer that is the index of the first element in the array
	 * @param mid an integer that is is the index of the middle element
	 * @param hi an integer that is the index of the highest element
	 * @return A list of sorting events
	 */
	private static <T extends Comparable<T>> List<SortEvent<T>> merge(ArrayList<T> l, int lo, int mid, int hi) {
		List<SortEvent<T>> ret = new ArrayList<>();
		ArrayList<T> l2 = new ArrayList<>();
		int j = mid + 1;
		int i = lo;
		while (i <= mid && j <= hi) {
			if (l.get(i).compareTo(l.get(j)) <= 0) {
				ret.add(new CompareEvent<>(i, j));
				l2.add(l.get(i));
				i++;
			} else {
				l2.add(l.get(j));
				j++;
			}
		}
		while (i <= mid) {
			l2.add(l.get(i));
			i++;
		}
		while (j <= hi) {
			l2.add(l.get(j));
			j++;
		}
		for (int n = lo; n <= hi; n++) {
			SortEvent<T> e1= new CopyEvent<>(n,l2.get(n-lo));
			ret.add(e1);
			e1.apply(l);
		}
		return ret;
	}
	/** Merge Sort Helper
	 * @param l: An array list 
	 * @param lo Index of the first element in the array
	 * @param hi index of the last element in the array
	 * @return A list of sorting events
	 */
	private static <T extends Comparable<T>> List<SortEvent<T>> mergeSortHelper(ArrayList<T> l, int lo, int hi) {
		List<SortEvent<T>> ret = new ArrayList<>();
		if (lo < hi) {
			int mid = hi / 2 + lo / 2;
			ret.addAll(mergeSortHelper(l, lo, mid));
			ret.addAll(mergeSortHelper(l, mid + 1, hi));
			ret.addAll(merge(l, lo, mid, hi));
		} else if (lo == hi) {
			int mid = lo;
			ret.addAll(merge(l, lo, mid, hi));
		}
		return ret;
	}
	/** Merge Sort
	 * @param l: An array list 
	 * @return A list of sorting events
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(ArrayList<T> l) {
		List<SortEvent<T>> ret = mergeSortHelper(l, 0, l.size() - 1);
		return ret;
	}
	/** partition
	 * @param l: An array list 
	 * @param low index of first element in array
	 * @param hi index of last element in array
	 * @param pivotIndex Index of element acting as pivot
	 * @return A list of sorting events
	 */
	private static <T extends Comparable<T>> int partition(ArrayList<T> l, int low, int hi, int pivotIndex,
			List<SortEvent<T>> ev) {
		T pivot = l.get(pivotIndex);
		SortEvent<T> e1 = new SwapEvent<T>(hi, pivotIndex);
		ev.add(e1);
		e1.apply(l);
		int i = low;
		int j = hi;
		while (i != j) {
			while (l.get(i).compareTo(pivot) < 0 && i < j) {
				ev.add(new CompareEvent<T>(i, l.indexOf(pivot)));
				i++;
			}
			while (l.get(j).compareTo(pivot) >= 0 && j > i) {
				ev.add(new CompareEvent<T>(j, l.indexOf(pivot)));
				j--;
			}
			SortEvent<T> e2 = new SwapEvent<T>(i, j);
			ev.add(e2);
			e2.apply(l);
		}
		SortEvent<T> e3 = new SwapEvent<T>(i, hi);
		ev.add(e3);
		e3.apply(l);
		return i;
	}
	/** Quicksort helper
	 * @param ArrayList<T>: An array list 
	 * @param lo index of first element in array
	 * @param hi index of last element in array
	 * @return A list of sorting events
	 */
	private static <T extends Comparable<T>> List<SortEvent<T>> quickSortHelper(ArrayList<T> l, int lo, int hi) {
		List<SortEvent<T>> ret = new ArrayList<>();
		if (lo < hi) {
			int pivot = hi / 2 + lo / 2;
			pivot = partition(l, lo, hi, pivot, ret);
			ret.addAll(quickSortHelper(l, lo, pivot));
			ret.addAll(quickSortHelper(l, pivot + 1, hi));
		}
		return ret;
	}
	/** Quick Sort
	 * @param ArrayList<T>: An array list 
	 * @return A list of sorting events
	 */

	public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(ArrayList<T> l) {
		return quickSortHelper(l, 0, l.size() - 1);
	}
	/** Shellsort Sort
	 * @param ArrayList<T>: An array list 
	 * @return A list of sorting events
	 */

	public static <T extends Comparable<T>> List<SortEvent<T>> shellSort(ArrayList<T> l) {
		List<SortEvent<T>> ret = new ArrayList<>();
		int gap = l.size() / 2;
		while (gap > 0) {
			for (int p = gap; p < l.size(); p++) {
				if (l.get(p).compareTo(l.get(p - gap)) < 0) {
					ret.add(new CompareEvent<>(p, p-gap));
					SortEvent<T> e1 = new SwapEvent<>(p, p-gap);
					ret.add(e1);
					e1.apply(l);
					for (int i = p - gap; i >= gap; i -= gap) {
						if (l.get(i).compareTo(l.get(i - gap)) < 0) {
							ret.add(new CompareEvent<>(i, i-gap));
							SortEvent<T> e2 = new SwapEvent<>(i, i-gap);
							ret.add(e2);
							e2.apply(l);
						}
					}
				}
			}
			gap = gap / 2;
		}
		return ret;
	}
	/** Event sort
	 * @param l: An array list
	 * @param events: A list of sorting events 
	 */
	public static <T extends Comparable<T>> void eventSort(ArrayList<T> l, List<SortEvent<T>> events) {
		for (int i = 0; i < events.size(); i++) {
			events.get(i).apply(l); 
		}
	}
	
}
