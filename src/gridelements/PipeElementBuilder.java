package gridelements;


public class PipeElementBuilder {

    public String[][] buildPipeElement(PipeShape shape) {

        String[][] pipeElement = new String[3][3];
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                    switch (shape) {
                        case UPRIGHT:
                            if (i==0 || j==2 || (i==2 && j==0)) {
                                pipeElement[i][j] = "\u001B[" + 30 + ";" + 40 + "m" + '\u2589';
                            } else pipeElement[i][j] = "\u001B[" + 37 + ";" + 47 + "m" + '\u2589';
                            break;
                        case UPLEFT:
                            if (i==0 || j==0 || (i==2 && j==2)) {
                                pipeElement[i][j] = "\u001B[" + 30 + ";" + 40 + "m" + '\u2589';
                            } else pipeElement[i][j] = "\u001B[" + 37 + ";" + 47 + "m" + '\u2589';
                            break;
                        case DOWNRIGHT:
                            if (i==2 || j==2 || (i==0 && j==0)) {
                                pipeElement[i][j] = "\u001B[" + 30 + ";" + 40 + "m" + '\u2589';
                            } else pipeElement[i][j] = "\u001B[" + 37 + ";" + 47 + "m" + '\u2589';
                            break;
                        case DOWNLEFT:
                            if (i==2 || j==0 || (i==0 && j==2)) {
                                pipeElement[i][j] = "\u001B[" + 30 + ";" + 40 + "m" + '\u2589';
                            } else pipeElement[i][j] = "\u001B[" + 37 + ";" + 47 + "m" + '\u2589';
                            break;
                        case VERTICAL:
                            if (j==1) {
                                pipeElement[i][j] = "\u001B[" + 30 + ";" + 40 + "m" + '\u2589';
                            } else pipeElement[i][j] = "\u001B[" + 37 + ";" + 47 + "m" + '\u2589';
                            break;
                        case HORIZONTAL:
                            if (i==1) {
                                pipeElement[i][j] = "\u001B[" + 30 + ";" + 40 + "m" + '\u2589';
                            } else pipeElement[i][j] = "\u001B[" + 37 + ";" + 47 + "m" + '\u2589';
                            break;
        }
    }
        }
        return pipeElement;
    }
}
