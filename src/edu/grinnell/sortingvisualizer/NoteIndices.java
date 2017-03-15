package edu.grinnell.sortingvisualizer;
import java.util.ArrayList;
import java.util.Random;

/**
 * A collection of indices into a Scale object. These indices are the subject of
 * the various sorting algorithms in the program.
 */
public class NoteIndices {

	private ArrayList<Integer> indices;
	private boolean[] highlights;

	/**
	 * @param n
	 *            the size of the scale object that these indices map into
	 */
	public NoteIndices(int n) {
		indices = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			indices.add(i);
		}
		highlights = new boolean[n]; 
	}

	/**
	 * Reinitializes this collection of indices to map into a new scale object
	 * of the given size. The collection is also shuffled to provide an initial
	 * starting point for the sorting process.
	 * 
	 * @param n
	 *            the size of the scale object that these indices map into
	 */
	public void initializeAndShuffle(int n) {
		indices = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			indices.add(i);
		}
		highlights = new boolean[n];
		Random rnd = new Random();
		for (int i = 1; i < indices.size(); i++) {
			int index = rnd.nextInt(i);
			int a = indices.get(index);
			indices.set(index, indices.get(i));
			indices.set(i, a);
		}
	}

	/** @return the indices of this NoteIndices object */
	public ArrayList<Integer> getNotes() {
		return indices;
	}

	/**
	 * Highlights the given index of the note array
	 * 
	 * @param index
	 *            the index to highlight
	 */
	public void highlightNote(int index) {
		highlights[index] = true;
	}

	/** @return true if the given index is highlighted */
	public boolean isHighlighted(int index) {
		return highlights[index];
	}

	/** Clears all highlighted indices from this collection */
	public void clearAllHighlighted() {
		for (int i = 0; i < highlights.length; i++) {
			highlights[i] = false;
		}
	}
}