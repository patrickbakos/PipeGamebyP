import gridelements.GridElement;
import gridelements.PipeElement;
import gridelements.PipeShape;

import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class Grid {
    GridElement[][] createGrid() {
        GridElement[][] grid = new GridElement[9][9];
        PipeShape[] pipeShapes = {PipeShape.UPRIGHT,PipeShape.UPLEFT,PipeShape.DOWNRIGHT,PipeShape.DOWNLEFT,
                                    PipeShape.HORIZONTAL,PipeShape.VERTICAL};
        Random randomObject = new Random();

        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (i==0 || i==8 || j==0 || j==8) grid[i][j] = new GridElement();
                else if      (i==1 && j==1) grid[i][j] = new PipeElement(PipeShape.UPRIGHT);
                else if (i==1 && j==7) grid[i][j] = new PipeElement(PipeShape.UPLEFT);
                else if (i==1) grid[i][j] = new PipeElement(PipeShape.HORIZONTAL);
                else if (i==7 && j==1) grid[i][j] = new PipeElement(PipeShape.DOWNLEFT);
                else if (i==7 && j==7) grid[i][j] = new PipeElement(PipeShape.DOWNRIGHT);
                else if (j==1 || j==7) grid[i][j] = new PipeElement(PipeShape.VERTICAL);
                else if (i==7) grid[i][j] = new PipeElement(PipeShape.HORIZONTAL);
                else grid[i][j] = new PipeElement(pipeShapes[randomObject.nextInt(pipeShapes.length)]);

            }
        }
        return grid;
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

}
