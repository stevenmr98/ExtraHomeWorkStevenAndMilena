package Domain;
import java.util.Random;
public class Rectangle {
    private int row;
    private int column;
    private int width;
    private int height;
    private int newRow;
    private int newColumn;
    private int aux;
    
    public Rectangle() {
        this.row = new Random().nextInt(600 - 40);
        this.column = new Random().nextInt(400 - 40);
        this.width = 40;
        this.height = 40;
        this.aux = 0;
        this.newRow = new Random().nextInt(600 - 40);
        this.column = new Random().nextInt(400 - 40);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getNewRow() {
        return newRow;
    }

    public Rectangle(int newRow, int newColumn) {
        this.newRow = newRow;
        this.newColumn = newColumn;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }
}
