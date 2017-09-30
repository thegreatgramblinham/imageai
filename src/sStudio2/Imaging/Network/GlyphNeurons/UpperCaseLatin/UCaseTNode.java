package sStudio2.Imaging.Network.GlyphNeurons.UpperCaseLatin;


import sStudio2.Imaging.Network.GlyphNeurons.Support.GlyphMark;
import sStudio2.Imaging.Network.NeuralNode;

import java.util.HashMap;

/**
 * Represents a single, 'T' character recognising neuron.
 */
public class UCaseTNode extends NeuralNode<GlyphMark, Float> {


    //Constructor
    public UCaseTNode(HashMap<GlyphMark, Float> weightedDomain) {

        super(weightedDomain);
    }

    //Public Methods
    @Override
    public Float eval(Iterable<GlyphMark> input) {

        return null;
    }

    @Override
    public void train(Iterable<GlyphMark> input, Float output) {

        
    }
}
