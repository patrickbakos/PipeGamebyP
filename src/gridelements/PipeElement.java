package gridelements;

public class PipeElement extends GridElement {

    public PipeElement(PipeShape shape) {
        this.characterComposition = PipeElementBuilder.buildPipeElement(shape);
        this.shape = shape;
    }
    public PipeShape shape;
    public String[][] characterComposition;

}
