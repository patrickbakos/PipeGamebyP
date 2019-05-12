import gridelements.Direction;
import gridelements.GridElement;
import gridelements.PipeElement;
import gridelements.PipeShape;

import java.util.*;

public class Grid {
    PipeElement startingElement;
    GridElement[][] createGrid() {
        GridElement[][] grid = new GridElement[9][9];
        PipeShape[] pipeShapes = {PipeShape.UPRIGHT,PipeShape.UPLEFT,PipeShape.DOWNRIGHT,PipeShape.DOWNLEFT,
                                    PipeShape.HORIZONTAL,PipeShape.VERTICAL};
        Random randomObject = new Random();
        int[] coordinates;
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                coordinates = new int[]{i,j};
                if (i==0 || i==8 || j==0 || j==8) grid[i][j] = new GridElement();
                else if      (i==1 && j==1) grid[i][j] = new PipeElement(PipeShape.UPLEFT, coordinates);
                else if (i==1 && j==7) grid[i][j] = new PipeElement(PipeShape.UPRIGHT, coordinates);
                else if (i==1) grid[i][j] = new PipeElement(PipeShape.HORIZONTAL, coordinates);
                else if (i==7 && j==1) grid[i][j] = new PipeElement(PipeShape.DOWNLEFT, coordinates);
                else if (i==7 && j==7) grid[i][j] = new PipeElement(PipeShape.DOWNRIGHT, coordinates);
                else if (j==1 || j==7) grid[i][j] = new PipeElement(PipeShape.VERTICAL, coordinates);
                else if (i==7) grid[i][j] = new PipeElement(PipeShape.HORIZONTAL, coordinates);
                else grid[i][j] = new PipeElement(pipeShapes[randomObject.nextInt(pipeShapes.length)], coordinates);

            }
        }
        int startJ  = randomObject.nextInt(5)+2;
        int endJ = randomObject.nextInt(5)+2;
        startingElement = new PipeElement(PipeShape.START, new int[]{1,startJ});
        grid[1][startJ] = startingElement;
        grid[7][endJ] = new PipeElement(PipeShape.END, new int[]{7,endJ});

        return grid;
    }
    public int[] getStartingElementCoordinates(GridElement[][] grid) {
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid.length;j++) {
                if (grid[i][j].shape == PipeShape.START) {
                    System.out.println("starticn"+i+ j);
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    void printGrid(GridElement[][] grid) {
        String[][] printableGrid = convertGridToPrintable(grid);
        for (int i=0;i<27;i++) {
            for (int j=0;j<27;j++) {
                System.out.print(printableGrid[i][j]);
            }
            System.out.print("\u001B[0m" + "\n");
        }
    }
    String[][] convertGridToPrintable(GridElement[][] grid) {
        String[][] printableGrid = new String[27][27];
        PipeElement currentPipeElement;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid.length;j++) {
                for (int k=0;k<3;k++) {
                    for (int l=0;l<3;l++) {
                        if (grid[i][j] instanceof PipeElement) {
                            currentPipeElement = (PipeElement) grid[i][j];
                            printableGrid[(i*3)+k][(j*3)+l] = currentPipeElement.characterComposition[k][l];
                        }
                        else printableGrid[(i*3)+k][(j*3)+l] = grid[i][j].characterComposition[k][l];
                    }
                }
            }
        }
        return printableGrid;
    }
    public void rotatePipeElement(GridElement[][] grid, int[] coordinates) {
        PipeElement pipeElement;
        if (grid[coordinates[0]][coordinates[1]] instanceof PipeElement) {
            pipeElement = (PipeElement) grid[coordinates[0]][coordinates[1]];
            grid[coordinates[0]][coordinates[1]] = pipeElement.rotateElement();
        }
    }

    public void waterFlowCheck(GridElement[][] grid, int[] coordinates) {
        PipeElement currentElement;
        if (grid[coordinates[0]][coordinates[1]] instanceof PipeElement) {
            currentElement = (PipeElement) grid[coordinates[0]][coordinates[1]];
        }
        else {currentElement = null;}
        if (currentElement.isConnected) {
            GridElement nextElement;
            switch (currentElement.flowDirection) {
                case DOWN:
                    nextElement = grid[coordinates[0]-1][coordinates[1]];
                    break;
                case LEFT:
                    nextElement = grid[coordinates[0]][coordinates[1]-1];
                    break;
                case RIGHT:
                    nextElement = grid[coordinates[0]][coordinates[1]+1];
                    break;
                case UP:
                    nextElement = grid[coordinates[0]+1][coordinates[1]];
                    break;
                default:
                    nextElement = grid[coordinates[0]][coordinates[1]];
            }
            if (nextElement instanceof PipeElement && nextElement != currentElement) {
                PipeElement nextValidElement = (PipeElement) nextElement;
                if (nextValidElement.activeDirections.containsValue(currentElement.flowDirection)) {
                    nextValidElement.isConnected = true;//TODO colour connected next element
                    Collection<Direction> activeConnections = nextValidElement.activeDirections.values();
                    for (Iterator<Direction> myIterator = activeConnections.iterator();myIterator.hasNext();) {
                        if (myIterator.next() != currentElement.flowDirection) {
                            nextValidElement.flowDirection = myIterator.next();
                        }
                    }
                    waterFlowCheck(grid, ((PipeElement) nextElement).coordinates);
                }
                else System.out.println("nono");
            }
        }
    }

}
