import gridelements.*;

public class Game {
    public static void main(String[] args) {
        PipeElementBuilder pipeBuilder = new PipeElementBuilder();
        PipeElement myFirstElement = new PipeElement(PipeShape.HORIZONTAL);
        myFirstElement.characterComposition = pipeBuilder.buildPipeElement(myFirstElement.shape);
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                System.out.print(myFirstElement.characterComposition[i][j]);
            }
            System.out.println("\u001B[0m");
        }
    }
}
