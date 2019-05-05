package gridelements;


import java.awt.*;
import java.util.HashMap;

public class PipeElementBuilder {

    public static String[][] buildPipeElement(PipeShape shape) {
        final int BLACK_FG = 30;
        final int BLACK_BG = 40;
        final int WHITE_FG = 37;
        final int WHITE_BG = 47;
        String[][] pipeElement = new String[3][3];

        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                switch (shape) {
                    case UPRIGHT:
                        if (i==0 || j==2 || (i==2 && j==0)) {
                            pipeElement[i][j] = "\u001B[" + WHITE_BG + ";" + WHITE_FG + "m" + '\u2589' + ' ';
                        } else pipeElement[i][j] = "\u001B[" + BLACK_BG + ";" + BLACK_FG + "m" + '\u2589' + ' ';
                        break;
                    case UPLEFT: if (i==0 || j==0 || (i==2 && j==2)) {
                            pipeElement[i][j] = "\u001B[" + WHITE_BG + ";" + WHITE_FG + "m" + '\u2589' + ' ';
                        } else pipeElement[i][j] = "\u001B[" + BLACK_BG + ";" + BLACK_FG + "m" + '\u2589' + ' ';
                        break;
                    case DOWNRIGHT: if (i==2 || j==2 || (i==0 && j==0)) {
                            pipeElement[i][j] = "\u001B[" + WHITE_BG + ";" + WHITE_FG + "m" + '\u2589' + ' ';
                        } else pipeElement[i][j] = "\u001B[" + BLACK_BG + ";" + BLACK_FG + "m" + '\u2589' + ' ';
                        break;
                    case DOWNLEFT: if (i==2 || j==0 || (i==0 && j==2)) {
                            pipeElement[i][j] = "\u001B[" + WHITE_BG + ";" + WHITE_FG + "m" + '\u2589' + ' ';
                        } else pipeElement[i][j] = "\u001B[" + BLACK_BG + ";" + BLACK_FG + "m" + '\u2589' + ' ';
                        break;
                    case VERTICAL: if (j==1) {
                            pipeElement[i][j] = "\u001B[" + BLACK_BG + ";" + BLACK_FG + "m" + '\u2589' + ' ';
                        } else pipeElement[i][j] = "\u001B[" + WHITE_BG + ";" + WHITE_FG + "m" + '\u2589' + ' ';
                        break;
                    case HORIZONTAL: if (i==1) {
                            pipeElement[i][j] = "\u001B[" + BLACK_BG + ";" + BLACK_FG + "m" + '\u2589' + ' ';
                        } else pipeElement[i][j] = "\u001B[" + WHITE_BG + ";" + WHITE_FG + "m" + '\u2589' + ' ';
                        break;
                    case START: if (i==1 || (i==2 && j==1)) {
                        pipeElement[i][j] = "\u001B[" + BLACK_BG + ";" + BLACK_FG + "m" + '\u2589' + ' ';
                    } else pipeElement[i][j] = "\u001B[" + WHITE_BG + ";" + WHITE_FG + "m" + '\u2589' + ' ';
                        break;
                    case END: if (i==1 || (i==0 && j==1)) {
                        pipeElement[i][j] = "\u001B[" + BLACK_BG + ";" + BLACK_FG + "m" + '\u2589' + ' ';
                    } else pipeElement[i][j] = "\u001B[" + WHITE_BG + ";" + WHITE_FG + "m" + '\u2589' + ' ';
                        break;
                }
            }
        }
        return pipeElement;
    }
    public static HashMap<Direction,Direction> pipeConnections(PipeShape shape) {
        HashMap<Direction, Direction> activeConnections = new HashMap<>();
        switch (shape) {
            case UPLEFT:
                activeConnections.put(Direction.DOWN, Direction.UP); activeConnections.put(Direction.RIGHT, Direction.LEFT);
                break;
            case UPRIGHT:
                activeConnections.put(Direction.DOWN, Direction.UP); activeConnections.put(Direction.LEFT, Direction.RIGHT);
                break;
            case DOWNRIGHT:
                activeConnections.put(Direction.UP, Direction.DOWN); activeConnections.put(Direction.LEFT, Direction.RIGHT);
                break;
            case DOWNLEFT:
                activeConnections.put(Direction.UP, Direction.DOWN); activeConnections.put(Direction.RIGHT, Direction.LEFT);
                break;
            case VERTICAL:
                activeConnections.put(Direction.UP, Direction.DOWN); activeConnections.put(Direction.DOWN, Direction.UP);
                break;
            case HORIZONTAL:
                activeConnections.put(Direction.RIGHT, Direction.LEFT); activeConnections.put(Direction.LEFT, Direction.RIGHT);
                break;
        }
        return activeConnections;
    }
}
