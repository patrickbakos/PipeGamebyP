package gridelements;

import java.util.HashMap;

public class PipeElement extends GridElement {

    public PipeElement(PipeShape shape) {
        this.shape = shape;
        if (shape == PipeShape.START) this.isConnected = true;
        this.characterComposition = PipeElementBuilder.buildPipeElement(shape);
        activeDirections = PipeElementBuilder.pipeConnections(shape);
        nextRotation = PipeElementBuilder.nextElementShape(shape);
    }
    public PipeShape shape;
    public String[][] characterComposition;
    public HashMap<Direction,Direction> activeDirections;
    public PipeShape nextRotation;
    public PipeElement rotateElement() {
        return new PipeElement(nextRotation);
    }
    public boolean isConnected;
}
