import gridelements.*;

public class Game {
    public static void main(String[] args) {
        Grid myGridObject = new Grid();
        GridElement[][] myGrid = myGridObject.createGrid();
        myGridObject.printGrid(myGrid);
        GridElement nagySanyika = myGrid[1][1];
        PipeElement kisSanyika;
        Input inputObject = new Input();
        int i = 0;
        do {
            myGridObject.rotatePipeElement(myGrid, inputObject.elementForRotation());
            myGridObject.printGrid(myGrid);
            i++;
        } while (i<10);

    }
}
