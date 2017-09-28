package sStudio2.Imaging.Network.GlyphNeurons.UpperCaseLatin;


import sStudio2.Imaging.Network.GlyphNeurons.GlyphMark;
import sStudio2.Imaging.Network.NeuralNode;

import java.util.HashMap;
import java.util.List;

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
    public Float eval(GlyphMark input) {

        return null;
    }

    @Override
    public void train(List<GlyphMark> input, Float output) {

        
    }
}
