package gridelements;

public class PipeElement {

    public PipeElement(PipeShape shape) {

        this.shape = shape;
    }
    public PipeShape shape;
    public String[][] characterComposition = new String[3][3];
}
