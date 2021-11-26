/**----------------------------------------------------------------------------------
 -- Company: ENSEA Cergy
 -- Engineer: ANTHONY FERNANDO Judeson
 -- Last Update : 25.11.2021
 -- Project Name: Runner_Project
 -- Class Name: Hero
 -- Class Methods :  jumpUp( Hero hero1)
                   / jumpDown( Hero hero1)
                   / isInvincibility(Hero hero1, int invTime)
 -- Description: This class creates our hero for the game with all his parameters
 -- Parent class: animatedThing
 -- Additional Comments: none
 */

public class Hero extends animatedThing {

    // variables
    //------------------------------------------------------------------------------------------------------------------
    // variables for isInvincibility method
    private int invincible = 0; // invincible = 0 -> hero is not invincible / invincible = 1 -> hero is invincible
    private int invincibility = 25000000;
    // hero configuration
    private int lifePoint ;
    private int initLifePoint ;
    private int heightJump;
    private int level;
    //------------------------------------------------------------------------------------------------------------------

    // constructor
    //------------------------------------------------------------------------------------------------------------------
    public Hero(String fileName, double x, double y, double sizeXWindow, double sizeYWindow, double offsetXFrame, double offsetYFrame){
        super(fileName, x, y, sizeXWindow, sizeYWindow, offsetXFrame, offsetYFrame);
        this.lifePoint = 0;
        this.initLifePoint = this.lifePoint;
        this.heightJump = 64;
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Hero's jump is separates in 2 methods : jumpUp & jumpDown
     * jumpUp method : displays the hero jumpUp image and adds to the hero's initial x position
     *                 the updated gravity value (from the gameScene class).
     *                 NB : Gravity value increases from an init value (negative value) to 0.
     * @param hero1 our hero from gameScene
     */
    //------------------------------------------------------------------------------------------------------------------
    public void jumpUp( Hero hero1){
        hero1.setAttitude(1);
        // hero jumpUp image
        hero1.setX(0);
        hero1.setY(160);
        // hero jumps up
        hero1.setOffsetYFrame(250 + hero1.getGravity());
        (hero1.getImageView()).setY(hero1.getOffsetYFrame());
    }
    /**
     * Hero's jump is separates in 2 methods : jumpUp & jumpDown
     * jumpDown method : displays the hero jumpUp image and adds to the hero's initial x position
     *                   the updated gravity value (from the gameScene class).
     *                   NB : Gravity value decreases from 0 to an init value (negative value).
     * @param hero1 our hero from gameScene
     */
    public void jumpDown( Hero hero1){
        hero1.setAttitude(2);
        // hero jumpDown image
        hero1.setX(85);
        hero1.setY(160);
        // hero jumps down
        hero1.setOffsetYFrame(250 + hero1.getGravity());
        (hero1.getImageView()).setY(hero1.getOffsetYFrame());
    }
    //------------------------------------------------------------------------------------------------------------------

    //

    /**
     * invincible = 0 -> hero is not invincible / invincible = 1 -> hero is invincible
     * isInvincibility method : hero is invincible for dt time,
     *                          this method changes hero's opacity ( = means that is invincible)
     *                          and sets to 0 invincible at the end of invincibility time
     * @param hero1 our hero from gameScene
     * @param invTime time past from the previous called (gameScene)
     */
    //------------------------------------------------------------------------------------------------------------------
    public void isInvincibility(Hero hero1, int invTime){
        this.invincibility -= invTime;
        hero1.getImageView().opacityProperty().setValue(0.5);
        if(this.invincibility <= 0 ){
            hero1.getImageView().opacityProperty().setValue(1);
            this.invincible = 0;
            this.invincibility = 25000000;
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    // getter
    //------------------------------------------------------------------------------------------------------------------
    public int getLifePoint(){ return this.lifePoint;}
    public int getInitLifePoint() {return initLifePoint;}
    public int getInvincible() {return invincible;}
    public int getHeightJump() { return heightJump;}
    public int getLevel() { return level;}
    public long getInvincibility() { return invincibility;}
    //------------------------------------------------------------------------------------------------------------------

    // setter
    //------------------------------------------------------------------------------------------------------------------
    public void setLifePoint(int lifePoint) { this.lifePoint = lifePoint;}
    public void setInvincible(int invincible) { this.invincible = invincible;}
    public void setLevel(int level ) { this.level = level;}
    public void setInvincibility(int invincibility) {this.invincibility = invincibility;}
    //------------------------------------------------------------------------------------------------------------------
}
