package sStudio2.Imaging.Interpreters;

import sStudio2.Imaging.Converters.ImageData;
import sStudio2.Imaging.Network.GlyphNeurons.Support.GlyphGrid;

import java.util.List;

/**
 * Standard interface across all image interpreters
 */
public interface IImageInterpreter {

    //Methods
    List<GlyphGrid> extract(ImageData image);
}
