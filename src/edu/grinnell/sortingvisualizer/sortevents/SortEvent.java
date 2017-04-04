package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;
import java.util.List;

public interface SortEvent<T> {
	public void apply(ArrayList<T> arr);
	public List<Integer> getAffectedIndices();
	public boolean isEmphasized();
}
