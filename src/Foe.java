// imported libraries
//----------------------------------------------------------------------------------------------------------------------
import static java.lang.Math.abs;
//----------------------------------------------------------------------------------------------------------------------

public class Foe extends animatedThing{

    // variables
    //------------------------------------------------------------------------------------------------------------------
    // variables for distanceFoe method
    private double rdA;
    private double rdB;
    //------------------------------------------------------------------------------------------------------------------

    // constructor
    //------------------------------------------------------------------------------------------------------------------
    public Foe(String fileName, double x, double y, double sizeXWindow, double sizeYWindow, double offsetXFrame, double offsetYFrame){
        super(fileName, x, y, sizeXWindow, sizeYWindow, offsetXFrame, offsetYFrame);
    }
    //------------------------------------------------------------------------------------------------------------------

    // collision
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

    // manage distance between 2 foes -> if 2 foes are to close, distanceFoe method add distance between them
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
