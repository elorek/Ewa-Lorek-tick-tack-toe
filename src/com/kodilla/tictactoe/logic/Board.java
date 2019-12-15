package com.kodilla.tictactoe.logic;

public class Board {
    private Figure[][] figures;

    public Board() {
        figures = new Figure[3][];
        for(int n=0; n<3; n++) {
            figures[n] = new Figure[3];
        }
        for(int x=0; x<3; x++) {
            for(int y=0; y<3; y++) {
                figures[x][y] = new Figure(FigureColor.NONE);
            }
        }
    }
    public Figure getFigure(int x, int y) {
        return figures[x][y];
    }
    public void setFigure(int x, int y, Figure figure) {
        figures[x][y] = figure;
    }

    public boolean doMove(int x, int y, Figure figure) {
        if(getFigure(x, y).getColor() == FigureColor.NONE) {
            setFigure(x, y, figure);
            return true;
        } else {
            return false;
        }
    }
}
