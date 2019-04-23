package Interface;

import java.awt.*;
import java.util.Random;

public class Simulator {
//variables

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;
    private int row;
    private int column;
    private int rowR;
    private int columnR;
    private int aux;
    private int newRow;
    private int newColumn;
    private int newRowR;
    private int newColumnR;
     private int rowR2;
    private int columnR2;
private int newRowR2;
    private int newColumnR2;
    //constructor
    public Simulator(DisplayFrame myDisplayer_) throws InterruptedException {
        myDisplayer_.setBackground(Color.BLACK);
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());
        //valores de las figuras
        myCircle.setHeight(80);
        myCircle.setWidth(80);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
        newRow = new Random().nextInt(600 - 40);
        newColumn = new Random().nextInt(400 - 40);
        newRowR = new Random().nextInt(600 - 40);
        newColumnR = new Random().nextInt(400 - 40);

    }//Constructor

    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException {
        //ciclo infinito
        while (true) {
            row = new Random().nextInt(600 - 40);
            column = new Random().nextInt(400 - 40);
            rowR = new Random().nextInt(600 - 40);
            columnR = new Random().nextInt(400 - 40);
            rowR2 = new Random().nextInt(600 - 40);
            columnR2 = new Random().nextInt(400 - 40);
            this.createImages(25);
            //pone en espera el flujo del programa
            Thread.sleep(waitingTime);
        }
    }//startSimulation

    //coloca nuevos valores aleatorios en las figuras
    public void createImages(int waitingTime) throws InterruptedException {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();
        while (true) {

            moveCircle();
            moveSquare();
            moveSquareRectangle();
            myDisplayer.paintAgain();
            Thread.sleep(waitingTime);
        }
    }//CreateImages

    public void moveCircle() throws InterruptedException {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();
      
        //este metodo hace que vaya siga un camino como tal y no se pinte aleatorio en a pantalla
        double path = Math.sqrt(Math.pow(this.newRow - this.row, 2) + Math.pow(this.newColumn - this.column, 2));
        //le da movimiento
        this.row += (this.newRow - this.row) / path;
        this.column += (this.newColumn - this.column) / path;
        
//
            graphic.setColor(Color.cyan);
            graphic.fillOval(row, column, 40, 40);
        
        if (column > newColumn) {
            aux = 1;
        }
        if (aux == 1 && this.column <= this.newColumn) {
            System.out.println("Primer if");
            this.newRow = new Random().nextInt(600 - 40);
            this.newColumn = new Random().nextInt(400 - 40);
            aux = 0;

        } else if (aux == 0 && this.column >= this.newColumn) {
            System.out.println("segundo if");

            this.newRow = new Random().nextInt(600 - 40);
            this.newColumn = new Random().nextInt(400 - 40);
            aux = 0;
        }

    }//moveCircle

    public void moveSquare() throws InterruptedException {
        Graphics graphic = myDisplayer.getGraphicsImage();
        double path = Math.sqrt(Math.pow(this.newRowR - this.rowR, 2) + Math.pow(this.newColumnR - this.columnR, 2));
        this.rowR += (this.newRowR - this.rowR) / path;
        this.columnR += (this.newColumnR - this.columnR) / path;

        if (columnR > newColumnR) {
            aux = 1;
        }
        if (aux == 1 && this.columnR <= this.newColumnR) {
            System.out.println("Primer if");
            this.newRowR = new Random().nextInt(600 - 40);
            this.newColumnR = new Random().nextInt(400 - 40);
            aux = 0;
        } else if (aux == 0 && this.columnR >= this.newColumnR) {
            System.out.println("segundo if");
            graphic.setColor(Color.cyan);
            this.newRowR = new Random().nextInt(600 - 40);
            this.newColumnR = new Random().nextInt(400 - 40);
            aux = 0;
        } else if (this.rowR == 0) {
            System.out.println("tercer if");
            graphic.setColor(Color.cyan);
            this.newRowR = new Random().nextInt(600 - 40);
            this.newColumnR = new Random().nextInt(400 - 40);

            aux = 1;
        }
        graphic.setColor(Color.PINK);
        graphic.fillRect(rowR, columnR, 40, 40);
    }
    public void moveSquareRectangle() throws InterruptedException {
        Graphics graphic = myDisplayer.getGraphicsImage();
        double path = Math.sqrt(Math.pow(this.newRowR2 - this.rowR2, 2) + Math.pow(this.newColumnR2 - this.columnR2, 2));
        this.rowR2 += (this.newRowR2 - this.rowR2) / path;
        this.columnR2 += (this.newColumnR2 - this.columnR2) / path;

        if (columnR2 > newColumnR2) {
            aux = 1;
        }
        if (aux == 1 && this.columnR2 <= this.newColumnR2) {
            System.out.println("Primer if");
            this.newRowR2 = new Random().nextInt(600 - 40);
            this.newColumnR2 = new Random().nextInt(400 - 40);
            aux = 0;
        } else if (aux == 0 && this.columnR2 >= this.newColumnR2) {
            System.out.println("segundo if");
            graphic.setColor(Color.cyan);
            this.newRowR2 = new Random().nextInt(600 - 40);
            this.newColumnR2 = new Random().nextInt(400 - 40);
            aux = 0;
        } else if (this.rowR2 == 0) {
            System.out.println("tercer if");
            graphic.setColor(Color.cyan);
            this.newRowR2 = new Random().nextInt(600 - 40);
            this.newColumnR2 = new Random().nextInt(400 - 40);

            aux = 1;
        }
        graphic.setColor(Color.yellow);
        graphic.fillRect(rowR2, columnR2, 60, 40);
    }
    //**************************************************************************
    /*     metodos accesores      */
    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public Interface.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(Interface.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }
}//fin de clase
