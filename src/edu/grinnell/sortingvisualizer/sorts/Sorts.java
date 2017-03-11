package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;

public class Sorts {

	/* private static <T extends Comparable<T>> void swap(ArrayList<T> l, int i, int j) {
		T temp = l.get(i);
		l.set(i, l.get(j));
		l.set(j, temp);
	} */

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
			//swap(l, i, minIndex);
			ret.add(new SwapEvent<>(i, minIndex));
		}
		return ret;
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(ArrayList<T> l) {
		List<SortEvent<T>> ret = new ArrayList<>();
		for (int i = 1; i < l.size(); i++) {
			T temp = l.get(i);
			for (int x = 0; x <= i; x++) {
				if (x == i) {
					ret.add(new CompareEvent<>(x, i));
					//l.set(x, temp);
					ret.add(new CopyEvent<>(x, temp));
				} else if (l.get(x).compareTo(temp) >= 0) {
					ret.add(new CompareEvent<>(x, l.indexOf(temp)));
					T temp2 = l.get(x);
					//l.set(x, temp);
					ret.add(new CopyEvent<>(x, temp));
					temp = temp2;
				}
			}
		}
		return ret;
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(ArrayList<T> l) {
		List<SortEvent<T>> ret = new ArrayList<>();
		for (int n = 0; n < l.size(); n++) {
			for (int i = 1; i < l.size(); i++) {
				int temp = i - 1;
				if (l.get(temp).compareTo(l.get(i)) > 0) {
					ret.add(new CompareEvent<>(temp, i));
					//swap(l, temp, i);
					ret.add(new SwapEvent<>(temp, i));
				}
			}
		}
		return ret;
	}

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
			//l.set(n, l2.get(n - lo));
			ret.add(new CopyEvent<>(n, l2.get(n - lo)));
		}
		return ret;
	}

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

	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(ArrayList<T> l) {
		List<SortEvent<T>> ret = mergeSortHelper(l, 0, l.size() - 1);
		return ret;
	}

	private static <T extends Comparable<T>> int partition(ArrayList<T> l, int low, int hi, int pivotIndex,
			List<SortEvent<T>> ev) {
		T pivot = l.get(pivotIndex);
		//swap(l, hi, pivotIndex);
		ev.add(new SwapEvent<T>(hi, pivotIndex));
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
			//swap(l, i, j);
			ev.add(new SwapEvent<T>(i, j));
		}
		//swap(l, i, hi);
		ev.add(new SwapEvent<T>(i, j));
		return i;
	}

	private static <T extends Comparable<T>> List<SortEvent<T>> quickSortHelper(ArrayList<T> l, int lo, int hi) {
		List<SortEvent<T>> ret = new ArrayList<>();
		if (lo < hi) {
			int pivot = hi / 2 + lo / 2;
			pivot = partition(l, lo, hi, pivot, ret);
			quickSortHelper(l, lo, pivot);
			quickSortHelper(l, pivot + 1, hi);
		}
		return ret;
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(ArrayList<T> l) {
		List<SortEvent<T>> ret = new ArrayList<>();
		quickSortHelper(l, 0, l.size() - 1);
		return ret;
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> shellSort(ArrayList<T> l) {
		List<SortEvent<T>> ret = new ArrayList<>();
		int gap = l.size() / 2;
		while (gap > 0) {
			for (int p = gap; p < l.size(); p++) {
				if (l.get(p).compareTo(l.get(p - gap)) < 0) {
					ret.add(new CompareEvent<>(p, p-gap));
					//swap(l, p, p - gap);
					ret.add(new SwapEvent<>(p, p-gap));
					for (int i = p - gap; i >= gap; i -= gap) {
						if (l.get(i).compareTo(l.get(i - gap)) < 0) {
							ret.add(new CompareEvent<>(i, i-gap));
							//swap(l, i, i - gap);
							ret.add(new SwapEvent<>(i, i-gap));
						}
					}
				}
			}
			gap = gap / 2;
		}
		return ret;
	}

}
