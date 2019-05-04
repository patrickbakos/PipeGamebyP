package gridelements;

public class GridElement {
    public GridElement() {

        this.shape = PipeShape.FILL;
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                characterComposition[i][j] = "\u001B[" + 30 + ";" + 40 + "m" + '\u2589' + ' ';
            }
        }
    }
    public PipeShape shape;
    public String[][] characterComposition = new String[3][3];
}
