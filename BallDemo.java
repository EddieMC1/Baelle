import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Die Klasse BallDemo bietet eine kurze Demonstration, wie die
 * Klasse Canvas benutzt werden kann.
 *
 * @author Eduard Gradwald
 * @version 10.09.2019
 */

public class BallDemo   
{
    private Canvas leinwand;
    private final int boden = 400;   // Position der Bodenlinie
    private final int decke = 50;   // Position der Deckenlinie 
    private int anzahlBaelle;  // Anzahl der Bälle
    private Ball[] baelle;   // Array mit Ball-Objekte
    private Color[] colors;   // Array mit Farben
    private Random zufallsZahl;   // Zufallszahl mit RANDOM

    /**
     * Erzeuge ein Exemplar von BallDemo.
     * Es wird ein frischer Canvas erzeugt und sichtbar gemacht.
     */
    public BallDemo(int anzahlBaelle) 
    {
        this.leinwand = new Canvas("Ball Demo", 600, 500, Color.white);
        this.anzahlBaelle = anzahlBaelle;
        this.baelle = new Ball[anzahlBaelle];
        this.zufallsZahl = new Random();
        this.colors = new Color[]{Color.gray, Color.orange, Color.blue, Color.black, Color.lightGray, Color.red, Color.magenta, Color.yellow, Color.green, Color.pink, Color.cyan, Color.darkGray};
    }
 
    /**
     * Simuliere zwei springende Bälle.
     */
    public void springenLassen()
    {
        
        leinwand.setVisible(true);

//        // Den Boden zeichnen.
//        leinwand.setForegroundColor(Color.BLACK);
//        leinwand.drawLine(50, boden, 550, boden);
//        
//        // Die Decke zeichnen.
//        leinwand.setForegroundColor(Color.BLACK);
//        leinwand.drawLine(50, decke, 550, decke);
//        
//        // Die linke Wand zeichnen.
//        leinwand.setForegroundColor(Color.BLACK);
//        leinwand.drawLine(50, 50, 50, boden);
//        
//        // Die rechte Wand zeichnen.
//        leinwand.setForegroundColor(Color.BLACK);
//        leinwand.drawLine(550, boden, 550, 50);
        
        for(int i = 0; i < anzahlBaelle; i++) {
       	
        	int x = zufallsZahl.nextInt(550) + 50;
            int y = zufallsZahl.nextInt(400) + 50;
            int z = zufallsZahl.nextInt(20)  + 10;
        	// Array mit Farben
        	int colorIndex = zufallsZahl.nextInt(6) + 0;
        	
        	
	        
	        
	        baelle[i] = new Ball(x, y, z, colors[colorIndex], boden, decke, 50, 550, leinwand);
        }
//	      Die Bälle erzeugen und anzeigen.
//	      Ball ball = new Ball(50, 50, 16, Color.BLUE, boden, decke, 50, 550, leinwand);
//	      ball.zeichnen();
//        Ball ball2 = new Ball(70, 80, 20, Color.RED, boden, decke, 50, 550, leinwand);
//        ball2.zeichnen();
//        Ball ball3 = new Ball(90, 100, 24, Color.GREEN, boden, decke, 50, 550, leinwand);
//        ball3.zeichnen();

        // Die Bälle springen lassen.
        boolean fertig =  false;
        while(!fertig) {
            leinwand.wait(50);           // kurze Pause
            
            for (Ball ball : baelle) { 
                
                ball.bewegen();
                if(ball.gibXPosition() >= 550) {
                    fertig = true;
                }
            
            }          
            
//            ball.bewegen();
//            ball2.bewegen();
//            ball3.bewegen();
            
            // Stoppen, wenn die Bälle weit genug gesprungen sind.
//            if(ball.gibXPosition() >= 550 || ball2.gibXPosition() >= 550 || ball3.gibXPosition() >= 550) {
//                fertig = true;
//            }
        }
    
    }
}
