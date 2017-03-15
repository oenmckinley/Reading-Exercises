package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T extends Comparable<T>> implements SortEvent<T> {
	
	private int i;
	private int j;
	private T val;
	
	public CompareEvent(int i, int j) {
		this.i = i;
		this.j = j;
		this.val = null;
	}
	
	/*public CompareEvent(int i, T val) {
		this.i = i;
		this.j = -1;
		this.val = val;
	}*/
	
	public void apply(ArrayList<T> arr) {
		if (j == -1) {
			arr.get(i).compareTo(val);
		} else {
			arr.get(i).compareTo(arr.get(j));
		}
	}
	
	public List<Integer> getAffectedIndices() {
		ArrayList<Integer> ret = new ArrayList<>();
		ret.add(i);
		ret.add(j);
		return ret;
	}
	
	public boolean isEmphasized() {
		return false;
	}
	
}