/**----------------------------------------------------------------------------------
 -- Company: ENSEA Cergy
 -- Engineer: ANTHONY FERNANDO Judeson
 -- Last Update : 25.11.2021
 -- Project Name: Runner_Project
 -- Class Name: Foe
 -- Class Methods :  rectangle2DGetHitBox(Hero hero1, Foe foe)
                    / distanceFoe(double rdA, double rdB)
                    / displayHart(Hero hero1,Foe hart)
 -- Description: This class creates foes objects.
 -- Parent class: animatedThing
 -- Additional Comments: Foe object is used in the code to create foes, harts (hero lives).
                         It's also used for start and game over animation.
 */

// imported libraries
//----------------------------------------------------------------------------------------------------------------------
import static java.lang.Math.abs;
//----------------------------------------------------------------------------------------------------------------------

public class Foe extends animatedThing{

    // variables
    //------------------------------------------------------------------------------------------------------------------
    // variables for distanceFoe method
    private double rdA; // random number given by Math.random() method
    private double rdB; // random number given by Math.random() method
    //------------------------------------------------------------------------------------------------------------------

    // constructor
    //------------------------------------------------------------------------------------------------------------------
    public Foe(String fileName, double x, double y, double sizeXWindow, double sizeYWindow, double offsetXFrame, double offsetYFrame){
        super(fileName, x, y, sizeXWindow, sizeYWindow, offsetXFrame, offsetYFrame);
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * rectangle2DGetHitBox method : if hero hit a foe, hero looses a life point
     * @param hero1 our hero from gameScene
     * @param foe   foes from gameScene
     */
    //------------------------------------------------------------------------------------------------------------------
    public void rectangle2DGetHitBox(Hero hero1, Foe foe) {
        if (abs((hero1.getOffsetXFrame()-(int)(hero1.getOffsetXFrame()/800)*800)-foe.getOffsetXFrame()) < 25 && hero1.getOffsetYFrame() > 240) {
            hero1.setLifePoint(hero1.getLifePoint()-1);
        }
        if (abs((hero1.getOffsetXFrame()-(int)(hero1.getOffsetXFrame()/800)*800)-(foe.getOffsetXFrame()+70)) < 25 && hero1.getOffsetYFrame() > 240) {
            hero1.setLifePoint(hero1.getLifePoint()-1);
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * distanceFoe methods : if foes are too closed from each other, this method adds distance between them
     * @param rdA random number given by Math.random() method
     * @param rdB random number given by Math.random() method
     */
    //------------------------------------------------------------------------------------------------------------------
    public void distanceFoe(double rdA, double rdB){
        if (abs(rdA-rdB)<250) {
            System.out.println("collééé"+" "+rdA+" "+rdB);
            if (rdB < rdA) {this.rdA = (rdA + (400-abs(rdA-rdB)))%700; this.rdB = rdB;}
            else {this.rdB = (rdB + (400-abs(rdA-rdB)))%700; this.rdA = rdA;}
        }
        else {this.rdA = rdA ; this.rdB = rdB;}
        System.out.println("plus collééé"+" "+this.rdA+" "+this.rdB);
    }
    //------------------------------------------------------------------------------------------------------------------

    // display harts -> each hart equals to 3 hero.lifePoints

    /**
     * each hart equals to 3 hero.lifePoint
     * displayHart method : this method displays from a full hero's hart to an empty hero's hart
     *                      as long as he looses a life point
     * @param hero1 our hero from gameScene
     * @param hart  harts from gameScene
     */
    //------------------------------------------------------------------------------------------------------------------
    public void displayHart(Hero hero1,Foe hart){
        if(hero1.getLifePoint()%3 == 2) {hart.setX(30);}
        if(hero1.getLifePoint()%3 == 1) {hart.setX(270);}
        if(hero1.getLifePoint()%3 == 0) {hart.setX(380);}
    }
    //------------------------------------------------------------------------------------------------------------------

    // getter
    //------------------------------------------------------------------------------------------------------------------
    public double getRdA() {return rdA;}
    public double getRdB() {return rdB;}
    //------------------------------------------------------------------------------------------------------------------
}
