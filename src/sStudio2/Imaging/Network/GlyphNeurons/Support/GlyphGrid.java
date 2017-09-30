package sStudio2.Imaging.Network.GlyphNeurons.Support;


import java.util.*;


public class GlyphGrid {

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
}
