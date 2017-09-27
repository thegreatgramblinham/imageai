package sStudio2.Imaging.Network;

import java.util.Collection;
import java.util.HashMap;

/**
 * Base for a node representing a single neuron. Where:
 * T = Input type - Collection
 * U = Output type
 *
 * Based off of this article: https://medium.com/technology-invention-and-more/how-to-build-a-simple-neural-network-in-9-lines-of-python-code-cc8f23647ca1
 */
public abstract class NeuralNode<T extends Collection, U> {

    //Private Variables
    HashMap<T, U> _domainRangeMapping;

    //Constructor
    /**
     * Base constructor
     * @param domainRangeMapping Starting domain paired with appropriate outputs serving
     *                           as a knowledge base for training.
     */
    protected NeuralNode(HashMap<T,U> domainRangeMapping) {

    }

    //Abstract Methods
    public abstract U eval(T input);

    //Private Methods
    protected void train(T input) {


    }

}
