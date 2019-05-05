package gridelements;

import java.util.HashMap;

public class PipeElement extends GridElement {

    public PipeElement(PipeShape shape) {
        this.characterComposition = PipeElementBuilder.buildPipeElement(shape);
        this.shape = shape;
        activeDirections = PipeElementBuilder.pipeConnections(shape);
    }
    public PipeShape shape;
    public String[][] characterComposition;
    public HashMap<Direction,Direction> activeDirections;

}
