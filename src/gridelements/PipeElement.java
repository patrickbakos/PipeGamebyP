package gridelements;

import java.util.HashMap;

public class PipeElement extends GridElement {

    public PipeElement(PipeShape shape, int[] coordinates) {
        this.shape = shape;
        if (shape == PipeShape.START) this.isConnected = true;
        this.characterComposition = PipeElementBuilder.buildPipeElement(shape);
        this.coordinates = coordinates;
        this.activeDirections = PipeElementBuilder.pipeConnections(shape);
        this.nextRotation = PipeElementBuilder.nextElementShape(shape);
        this.isConnected = PipeElementBuilder.startSetupConnection(shape);
        this.flowDirection = PipeElementBuilder.setUpStartingFlow(shape);
    }
    public PipeShape shape;
    public String[][] characterComposition;
    public int[] coordinates;
    public HashMap<Direction,Direction> activeDirections;
    public PipeShape nextRotation;
    public PipeElement rotateElement() {
        return new PipeElement(nextRotation, this.coordinates);
    }
    public boolean isConnected;
    public Direction flowDirection;
}
