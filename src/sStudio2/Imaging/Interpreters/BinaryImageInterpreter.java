package sStudio2.Imaging.Interpreters;


import marvin.image.MarvinImage;
import sStudio2.Imaging.Converters.ImageData;
import sStudio2.Imaging.Network.GlyphNeurons.Support.GlyphGrid;

import java.util.List;

public class BinaryImageInterpreter implements IImageInterpreter {

    //Constructors
    public BinaryImageInterpreter() {

    }

    //Public Methods
    @Override
    public List<GlyphGrid> extract(ImageData image) {

        if(!(image.getDataClass().equals(Boolean.class)))
            throw new IllegalArgumentException("ImageData is of incompatible type.");

        return null;
    }
}
