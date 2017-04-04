package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T> {

	private int i;
	private T copy;
	
	public CopyEvent(int i, T copy) {
		this.i = i;
		this.copy = copy;
	}
	
	public void apply(ArrayList<T> arr) {
		arr.set(i, copy);
	}
	
	public List<Integer> getAffectedIndices() {
		ArrayList<Integer> ret = new ArrayList<>();
		ret.add(i);
		return ret;
	}
	
	public boolean isEmphasized() {
		return true;
	}
	
}
