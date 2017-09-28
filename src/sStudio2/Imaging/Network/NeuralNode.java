package sStudio2.Imaging.Network;

import java.util.HashMap;
import java.util.List;

/**
 * Base for a node representing a single neuron. Where:
 * T = Input type
 * U = Output type
 *
 * Based off of this article: https://medium.com/technology-invention-and-more/how-to-build-a-simple-neural-network-in-9-lines-of-python-code-cc8f23647ca1
 */
public abstract class NeuralNode<T, U> {

    //Private Variables
    protected HashMap<T, Float> _domainMemberToWeight;

    //Constructor
    /**
     * Base Constructor
     * @param weightedDomain The set of discrete inputs with their required starting weights.
     */
    protected NeuralNode(HashMap<T, Float> weightedDomain) {

        _domainMemberToWeight = weightedDomain;
    }

    //Abstract Methods
    public abstract U eval(T input);
    public abstract void train(List<T> input, U output);

}
