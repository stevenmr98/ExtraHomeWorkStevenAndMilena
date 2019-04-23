package anotherTechnique;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Circle extends Thread {

    private int row;
    private int column;
    private double newRow;
    private double newColumn;
    private int width;
    private int height;
    private int aux;

    public Circle() {
        this.row = new Random().nextInt(600 - 40);
        this.column = new Random().nextInt(400 - 40);
        this.width = 20;
        this.height = 20;
        this.aux = 0;
        this.newRow = new Random().nextInt(600 - 40);
        this.column = new Random().nextInt(400 - 40);

    }

   

    public void setRow(int laFila) {
        row = laFila;
    }

    public void setColumn(int laColumna) {
        column = laColumna;
    }

    public void setWidth(int elAncho) {
        width = elAncho;
    }

    public void setHeight(int elAlto) {
        height = elAlto;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
