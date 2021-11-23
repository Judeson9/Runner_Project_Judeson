public class Hero extends animatedThing {

    // variables
    //------------------------------------------------------------------------------------------------------------------
    // variables for isInvincibility method
    private int invincible = 0;
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
        this.lifePoint = 8;
        this.initLifePoint = this.lifePoint;
        this.heightJump = 64;
    }
    //------------------------------------------------------------------------------------------------------------------

    // jump methods
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

    // invincibility methods
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
