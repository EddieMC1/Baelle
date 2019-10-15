import java.awt.*;
import java.awt.geom.*;

/**
 * Die Klasse Ball implementiert grafisch Bälle, die der Schwerkraft
 * unterworfen sind. Ein Ball kann bewegt werden. Die Bedingungen der Bewegung
 * werden dabei vom Ball selbst kontrolliert. Er füllt abwärts und beschleunigt
 * aufgrund der Schwerkraft. Er prallt ab, wenn er auf dem Boden auftrifft.
 * 
 * Diese Bewegung kann simuliert werden, indem wiederholt die Operation
 * "bewegen" aufgerufen wird.
 * 
 * @author Eduard Gradwald
 *
 * @version 10.09.2019
 */

public class Ball
{
    private static final int gravitation = 3;  // Einfluss der Gravitation

    private int bremsfaktor = 1;  // simuliert den Luftwiderstand
    private Ellipse2D.Double kreis;
    private Color farbe;
    private int durchmesser;
    private int xPos;
    private int yPos;
    private final int bodenPosition;     // y-Position des Bodens
    private final int deckenPosition;      // y-Position der Decke
    private final int seiteLinksPosition;   // x-Position der linken Seite
    private final int seiteRechtsPosition;   // x-Position der rechten Seite
    private Canvas leinwand;
    private int yGeschwindigkeit = 20;   // anfängliche Abwärtsgeschwindigkeit
    private int xGeschwindigkeit = 20;   // anfängliche Abwärtsgeschwindigkeit

    /**
     * Konstruktor für Exemplare von Ball
     *
     * @param xPos    die horizontale Koordinate des Balles
     * @param yPos    die vertikale Koordinate des Balles
     * @param balldurchmesser  der Durchmesser des Balles (in Bildschirmpunkten)
     * @param ballfarbe        die Farbe des Balles
     * @param bodenPosition    die y-Position des Bodens (wo der Ball aufspringt)
     * @param zeichengrund     die Leinwand, auf der dieser Ball gezeichnet wird
     */
    public Ball(int xPos, int yPos, int durchmesser, Color farbe,
                        int bodenPosition, int deckenPosition, int seiteLinksPosition, int seiteRechtsPosition, Canvas leinwand)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.farbe = farbe;
        this.durchmesser = durchmesser;
        this.bodenPosition = bodenPosition;
        this.deckenPosition = deckenPosition;
        this.seiteLinksPosition = seiteLinksPosition;
        this.seiteRechtsPosition = seiteRechtsPosition;
        this.leinwand = leinwand;
    }

    /**
     * Zeichne diesen Ball an der aktuellen Position auf die Leinwand.
     **/
    public void zeichnen()
    {
    	// Den Boden zeichnen.
        leinwand.setForegroundColor(Color.BLACK);
        leinwand.drawLine(50, 400, 550, 400);
        
        // Die Decke zeichnen.
        leinwand.setForegroundColor(Color.BLACK);
        leinwand.drawLine(50, 50, 550, 50);
        
        // Die linke Wand zeichnen.
        leinwand.setForegroundColor(Color.BLACK);
        leinwand.drawLine(50, 50, 50, 400);
        
        // Die rechte Wand zeichnen.
        leinwand.setForegroundColor(Color.BLACK);
        leinwand.drawLine(550, 400, 550, 50);
        
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xPos, yPos, durchmesser);
    }

    /**
     * Lösche diesen Ball an seiner aktuellen Position.
     **/
    public void loeschen()
    {
        leinwand.eraseCircle(xPos, yPos, durchmesser);
    }    

    /**
     * Bewege diesen Ball entsprechend seiner Position und 
     * Geschwindigkeit und zeichne ihn erneut.
     **/
    public void bewegen()
    {
        // An der aktuellen Position von der Leinwand entfernen.
        loeschen();
            
        // Neue Position berechnen.
//        yGeschwindigkeit += gravitation;
        yPos += yGeschwindigkeit;
        xPos += xGeschwindigkeit;

        // Prüfen, ob der Boden erreicht ist.
        if(yPos >= 400 - durchmesser) {
            yPos = (int)(bodenPosition - durchmesser);
            yGeschwindigkeit = -yGeschwindigkeit + bremsfaktor; 
        }

        // Prüfen, ob die Decke erreicht ist.
        if(yPos < 50) {
        	yPos = (int)(deckenPosition);
        	yGeschwindigkeit = -yGeschwindigkeit + bremsfaktor;
        }
        
        // Prüfen, ob die rechte Seite erreicht ist.
        if(xPos > 550 - durchmesser) {
        	xPos = (int)(seiteRechtsPosition - durchmesser);
        	xGeschwindigkeit = -xGeschwindigkeit + bremsfaktor;
        }
        
        // Prüfen, ob die linke Seite erreicht ist.
        if(xPos < 50) {
        	xPos = (int)(seiteLinksPosition + durchmesser);
        	xGeschwindigkeit = -xGeschwindigkeit + bremsfaktor;
        }
        
        // An der neuen Position erneut zeichnen.
        zeichnen();
    }    

    /**
     * Liefere die horizontale Position dieses Balls.
     */
    public int gibXPosition()
    {
        return xPos;
    }

    /**
     * Liefere die vertikale Position dieses Balls.
     */
    public int gibYPosition()
    {
        return yPos;
    }
}
