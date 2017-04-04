package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;
import java.util.List;

public class SwapEvent<T> implements SortEvent<T> {

	private int i;
	private int j;

	public SwapEvent(int i, int j) {
		this.i = i;
		this.j = j;
	}

	private static <T> void swap(ArrayList<T> arr, int i, int j) {
		T temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
	public void apply(ArrayList<T> arr) {
		swap(arr, i, j);
	}

	public List<Integer> getAffectedIndices() {
		ArrayList<Integer> ret = new ArrayList<>();
		ret.add(i);
		ret.add(j);
		return ret;
	}

	public boolean isEmphasized() {
		return true;
	}

}
