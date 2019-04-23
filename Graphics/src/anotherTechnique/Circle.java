package anotherTechnique;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;

public class Circle extends Thread {

    private int row;
    private int column;
    private double newRow;
    private double newColumn;
    private int width;
    private int height;
    private int aux;

    public Circle() {
        this.row = new Random().nextInt(600 - 20);
        this.column = new Random().nextInt(400 - 20);
        this.width = 20;
        this.height = 20;
        this.aux = 0;
        this.newRow = new Random().nextInt(600 - 20);
        this.column = new Random().nextInt(400 - 20);

    }

    public void draw(Graphics gc) {
        gc.fillOval(row, column, 20, 20);

    } // draw

    private void moveCircle() { 
        this.row += (this.newRow - this.row);
        this.column += (this.newColumn - this.column);

        if (column > newColumn) {
            aux = 1;
        }
        if (aux == 1 && this.column <= this.newColumn) {
            this.newRow = new Random().nextInt(600 - 20);
            this.newColumn = new Random().nextInt(400 - 20);
            aux = 0;
        } else if (aux == 0 && this.column >= this.newColumn) {
            this.newRow = new Random().nextInt(600 - 20);
            this.newColumn = new Random().nextInt(400 - 20);
            aux = 0;
        }
    } // route

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                moveCircle();
            } catch (InterruptedException ex) {
                Logger.getLogger(Circle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } // while
    } // run

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
