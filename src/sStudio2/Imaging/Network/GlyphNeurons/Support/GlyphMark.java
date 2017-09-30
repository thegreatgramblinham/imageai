package sStudio2.Imaging.Network.GlyphNeurons.Support;

import java.awt.*;

/**
 * Represents a pivotal point in a glyph's identification process.
 */
public class GlyphMark {

    //Private Variables
    private Point _loc;

    //Constructor
    public GlyphMark(Point location) {
        _loc = location;
    }

    //Public Methods
    public void setLocation(Point newLocation) {
        _loc = newLocation;
    }

    public Point getLocation() {
        return _loc;
    }
}
