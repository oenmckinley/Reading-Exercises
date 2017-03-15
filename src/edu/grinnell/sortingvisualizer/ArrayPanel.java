package edu.grinnell.sortingvisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;
    
    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
    	g.clearRect(0, 0, (int)this.getPreferredSize().getWidth(), (int)this.getPreferredSize().getHeight());
    	g.setColor(Color.RED);
    	int len = notes.getNotes().size();
    	int wid = (int) (this.getPreferredSize().getWidth()/len);
    	int hei = (int) (this.getPreferredSize().getHeight());
    	for (int i = 0; i < len; i++) {
    		if (notes.isHighlighted(i)) {
    			g.setColor(Color.YELLOW);
    		}
    		int y = (len - 1 - notes.getNotes().get(i)) * hei/len;
    		g.fillRect(wid*i, y, wid, hei - y);
    		g.setColor(Color.RED);
    	}
    }
}