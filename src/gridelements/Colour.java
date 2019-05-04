package gridelements;

public enum Colour {
    BLACK_FG(30),
    BLACK_BG(40),
    WHITE_FG(37),
    WHITE_BG(47);

    private int colourCode;

    public int getCode() {
        return this.colourCode;
    }

    private Colour(int colourCode) {
        this.colourCode = colourCode;
    }
}
