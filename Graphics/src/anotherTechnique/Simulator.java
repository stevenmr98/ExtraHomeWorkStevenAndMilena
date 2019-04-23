package anotherTechnique;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;

public final class Simulator implements Runnable {

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;
    private long wait;
    private int FPS = 30;
    private long time = 1000 / FPS;

    //constructor
    public Simulator(DisplayFrame myDisplayer_) {
//        this.myDisplayer=new DisplayFrame(50, 50, 600, 400);
         this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(60);
        myCircle.setWidth(70);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
    }

    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException {
        while (true) {
           this.createImages();
            this.moveCircle();        
            Thread.sleep(waitingTime);
        }
    }//end method

    public void moveCircle() {
     //   Graphics gc = myDisplayer.getGraphicsImage();
        long start;
        long elapsed;

        while (true) {
            try {
               
                myCircle.getRow();
                myCircle.getColumn();
                start = System.nanoTime();
                elapsed = System.nanoTime() - start;

                this.wait = this.time - elapsed / 1000000;
                if (this.wait < 0) {
                    this.wait = 5;
                }
                Thread.sleep(this.wait);
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        } // while
        //ciclo infinito
    }

    public void createImages() {
        myDisplayer.initImage();
        Graphics gc = myDisplayer.getGraphicsImage();
        gc.setColor(Color.BLUE);

myCircle.draw(gc);
//        gc.setColor(Color.PINK);
//        gc.fillRect(getMyRectangle().getColumn(),
//                getMyRectangle().getRow(),
//                getMyRectangle().getWidth(),
//                getMyRectangle().getHeight());

        myDisplayer.paintAgain();
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

    public anotherTechnique.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(anotherTechnique.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }



    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
