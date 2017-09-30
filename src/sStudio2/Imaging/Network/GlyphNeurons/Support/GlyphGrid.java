package sStudio2.Imaging.Network.GlyphNeurons.Support;


import java.util.*;

/**
 * Represents the outline and traversal order of a single glyph.
 */
public class GlyphGrid implements Iterable<GlyphMark> {

    //Private Constants
    private static final int GRID_WIDTH = 10;
    private static final int GRID_HEIGHT = 10;

    //Private Variables
    private HashSet<GlyphMark> _markSet;
    private HashMap<Integer, GlyphMark> _traversalPriority;

    //Constructor
    public GlyphGrid() {

        _markSet = new HashSet<>();
        _traversalPriority = new HashMap<>();
    }

    //Public Methods
    public void add(GlyphMark mark, int traversalPriority) {

        if(_markSet.contains(mark))
            throw new IllegalArgumentException("GlyphMark already contained within grid.");
        if(_traversalPriority.containsKey(traversalPriority))
            throw new IllegalArgumentException("Grid already contains item with identical priority.");

        if(mark.getLocation().getX() < 0 || mark.getLocation().getX() > GRID_WIDTH)
            throw new IndexOutOfBoundsException("GlyphMark X coordinate falls outside the 0.0 - 10.0 range.");
        if(mark.getLocation().getY() < 0 || mark.getLocation().getY() > GRID_HEIGHT)
            throw new IndexOutOfBoundsException("GlyphMark Y coordinate falls outside the 0.0 - 10.0 range.");

        _markSet.add(mark);
        _traversalPriority.put(traversalPriority, mark);
    }

    public boolean contains(GlyphMark mark) {
        return _markSet.contains(mark);
    }

    public int size() {
        return _markSet.size();
    }

    public GlyphMark getMarkAtPriority(int priority) {
        return _traversalPriority.getOrDefault(priority, null);
    }

    @Override
    public Iterator<GlyphMark> iterator() {
        return _markSet.iterator();
    }
}
