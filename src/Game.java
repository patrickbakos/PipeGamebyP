import gridelements.*;

public class Game {
    public static void main(String[] args) {
        Grid myGridObject = new Grid();
        GridElement[][] myGrid = myGridObject.createGrid();
        myGridObject.printGrid(myGrid);
        System.out.println(myGridObject.startingElement.flowDirection);
        Input inputObject = new Input();
        int i = 0;
        do {
            myGridObject.rotatePipeElement(myGrid, inputObject.elementForRotation());
            myGridObject.waterFlowCheck(myGrid, myGridObject.startingElement.coordinates);
            myGridObject.printGrid(myGrid);
            i++;
        } while (i<10);

    }
}
