package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T extends Comparable<T>> implements SortEvent<T> {
	
	private int i;
	private int j;
	
	public CompareEvent(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public void apply(ArrayList<T> arr) {
		arr.get(i).compareTo(arr.get(j));
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