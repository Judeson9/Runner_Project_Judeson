/**----------------------------------------------------------------------------------
 -- Company: ENSEA Cergy
 -- Engineer: ANTHONY FERNANDO Judeson
 -- Last Update : 25.11.2021
 -- Project Name: Runner_Project
 -- Class Name: gameScene
 -- Class Methods :
 -- Description: This class creates the game scene, it's also the "main" class for this project
 -- Parent class: none
 -- Additional Comments: gameScene contains myTIMER class : myTimer class updates all parameters of the game
 */

// imported libraries
//----------------------------------------------------------------------------------------------------------------------
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;
//----------------------------------------------------------------------------------------------------------------------

public class GameScene extends Scene {

    // variables
    //------------------------------------------------------------------------------------------------------------------
    // camera
    protected Camera camera;
    // landscape
    private staticThing staticThing0;
    private staticThing staticThing1;
    private staticThing staticThing2;
    // hero
    protected Hero hero1;
    private Rectangle2D rectangle2D;
    // foe
    private ArrayList<Foe> foeGroup;
    private Foe foe1;
    private Foe foe2;
    private Foe foe3;
    // hart
    private Foe hart1;
    private Foe hart2;
    private Foe hart3;
    private int hartSize = 40;
    private Rectangle2D rectangleHart1;
    private Rectangle2D rectangleHart2;
    private Rectangle2D rectangleHart3;
    // gameOver & start
    private Foe gameOver;
    private Foe start;
    private Foe restart;
    // text
    private Text showLevel;
    private Text showMessage;
    private Text restartMessage;
    //------------------------------------------------------------------------------------------------------------------


    // constructor
    //------------------------------------------------------------------------------------------------------------------
    // root -> template
    public GameScene(Group root) {
        // camera
        //--------------------------------------------------------------------------------------------------------------
        super(root, 800, 390, Color.rgb(0, 153, 255));
        camera = new Camera(0, 0);
        //--------------------------------------------------------------------------------------------------------------
        // landscape png
        //--------------------------------------------------------------------------------------------------------------
        this.staticThing0 = new staticThing("img/desert.png", -800, 0);
        this.staticThing1 = new staticThing("img/desert.png", 0, 0);
        this.staticThing2 = new staticThing("img/desert.png", 800, 0);
        //--------------------------------------------------------------------------------------------------------------
        // hero png
        //--------------------------------------------------------------------------------------------------------------
        this.hero1 = new Hero("img/heros.png", 0, 0, 85, 100, 0, 245);
        //--------------------------------------------------------------------------------------------------------------
        // foe gif
        //--------------------------------------------------------------------------------------------------------------
        this.foeGroup = new ArrayList<Foe>();
        this.foe1 = new Foe("img/freezer.gif", 30, 30, 125, 80, 200, 220);
        this.foe2 = new Foe("img/cell.gif", 70, 0, 100, 93, 550, 245);
        this.foe3 = new Foe("img/buu.gif", 40, 0,115 , 150, 700, 200);
        this.foe1.getImageView().setFitHeight(120);
        this.foe1.getImageView().setFitWidth(130);
        this.foe2.getImageView().setFitHeight(100);
        this.foe2.getImageView().setFitWidth(130);
        this.foe3.getImageView().setFitHeight(150);
        this.foe3.getImageView().setFitWidth(130);
        this.foeGroup.add(this.foe1);
        this.foeGroup.add(this.foe2);
        this.foeGroup.add(this.foe3);
        //--------------------------------------------------------------------------------------------------------------
        // hart png
        //--------------------------------------------------------------------------------------------------------------
        this.hart1 = new Foe("img/coeur.png", 30, 0,100,150,10,0);
        this.hart2 = new Foe("img/coeur.png",30  , 0,100,150,60,0);
        this.hart3 = new Foe("img/coeur.png", 30, 0,100,150,110,0);
        this.hart1.getImageView().setFitHeight(hartSize);
        this.hart1.getImageView().setFitWidth(hartSize);
        this.hart2.getImageView().setFitHeight(hartSize);
        this.hart2.getImageView().setFitWidth(hartSize);
        this.hart3.getImageView().setFitHeight(hartSize);
        this.hart3.getImageView().setFitWidth(hartSize);
        //--------------------------------------------------------------------------------------------------------------
        // start & gameOver gif & restart
        //--------------------------------------------------------------------------------------------------------------
        this.start = new Foe("img/start.gif",0,0,480,352,0,0);
        this.start.getImageView().setFitHeight(400);
        this.start.getImageView().setFitWidth(800);
        this.gameOver = new Foe("img/gameOver.gif",0,0,600,300,-1200,0);
        this.gameOver.getImageView().setFitHeight(400);
        this.gameOver.getImageView().setFitWidth(800);
        this.restart = new Foe("img/restart.png",0,0,320,320,730,-60);
        this.restart.getImageView().setFitHeight(50);
        this.restart.getImageView().setFitWidth(50);
        //--------------------------------------------------------------------------------------------------------------
        // text
        //--------------------------------------------------------------------------------------------------------------
        this.showLevel = new Text(10,60,"Level : "+ this.hero1.getLevel());
        this.showLevel.setFont(new Font(20));
        this.showLevel.setFill(Color.BLACK);
        this.showMessage = new Text(320,380,"Press S to Start DBZRun");
        this.showMessage.setFont(new Font(15));
        this.showMessage.setFill(Color.WHITE);
        this.restartMessage = new Text(735,50,"Press G");
        this.restartMessage.setFont(new Font(12));
        this.restartMessage.setFill(Color.BLACK);
        //--------------------------------------------------------------------------------------------------------------
        // to display all the pngs, gifs and texts
        //--------------------------------------------------------------------------------------------------------------
        root.getChildren().addAll(
                this.staticThing0.getImageView(), this.staticThing1.getImageView(), this.staticThing2.getImageView(),
                this.hero1.getImageView(),
                this.foe1.getImageView(), this.foe2.getImageView(), this.foe3.getImageView(),
                this.hart1.getImageView(),this.hart2.getImageView(), this.hart3.getImageView(),
                this.gameOver.getImageView(), this.start.getImageView(), this.restart.getImageView(),
                this.showLevel, this.showMessage, this.restartMessage);
        //--------------------------------------------------------------------------------------------------------------
        // timer
        //--------------------------------------------------------------------------------------------------------------
        MyTimer timer = new MyTimer();
        timer.start();
        //--------------------------------------------------------------------------------------------------------------
    }
    //------------------------------------------------------------------------------------------------------------------

    // monitoring timer
    //------------------------------------------------------------------------------------------------------------------
    private class MyTimer extends AnimationTimer {

        // variables
        //--------------------------------------------------------------------------------------------------------------
        private float m = 7;
        private float a = 0;
        private long prevTime = 0;
        private long dt;
        private int prevLifePoint;
        private int rep = 0;
        private int prevRep = 0;
        private int flagJump = 0; // flag to indicate if hero has already jump or no
        private double rd1; // random number for foe1 x position
        private double rd2; // random number for foe2 x position
        private double rd3; // random number for foe3 x position
        //--------------------------------------------------------------------------------------------------------------

        @Override
        public void handle(long time) {

            // display static things (landscape and foes)
            //----------------------------------------------------------------------------------------------------------
            staticThing0.getImageView().setViewport(new Rectangle2D(0, camera.getY(), 800, 400));
            staticThing1.getImageView().setViewport(new Rectangle2D(0, camera.getY(), 800, 400));
            staticThing2.getImageView().setViewport(new Rectangle2D(0, camera.getY(), 800, 400));
            // manage the Y axis
            foe1.getImageView().setY(foe1.getOffsetYFrame() - camera.getY());
            foe2.getImageView().setY(foe2.getOffsetYFrame() - camera.getY());
            foe3.getImageView().setY(foe3.getOffsetYFrame() - camera.getY());
            // manage the X axis
            rep = (int) camera.getX() / 800;
            // give a random value to foes
            if (prevRep+1 == rep) {
                this.rd1 = Math.random()*650+75;
                this.rd2 = Math.random()*650+75;
                this.rd3 = Math.random()*600+150;
                foe1.distanceFoe(this.rd1,this.rd2);
                this.rd1 = foe1.getRdA();
                this.rd2 = foe1.getRdB();
                prevRep = rep;
            }
            staticThing0.getImageView().setX(-800 - camera.getX());
            // staticThing1 and staticThing2 are my landscapes images.
            // They are displayed one after the other until the game over.
            if (Math.floorMod(rep, 2) == 0) {
                foe3.setOffsetXFrame(this.rd3);
                staticThing1.getImageView().setX(800 * rep - camera.getX());
                foe1.getImageView().setX(foe1.getOffsetXFrame() + (800 * rep) - camera.getX());
                foe2.getImageView().setX(foe2.getOffsetXFrame() + (800 * rep) - camera.getX());
                staticThing2.getImageView().setX(800 * (rep + 1) - camera.getX());
                foe3.getImageView().setX(foe3.getOffsetXFrame() + (800 * (rep+1)) - camera.getX());
            }
            if (Math.floorMod(rep, 2) != 0) {
                foe1.setOffsetXFrame(this.rd1);
                foe2.setOffsetXFrame(this.rd2);
                staticThing1.getImageView().setX(800 * (rep + 1) - camera.getX());
                foe1.getImageView().setX(foe1.getOffsetXFrame() + (800 * (rep + 1)) - camera.getX());
                foe2.getImageView().setX(foe2.getOffsetXFrame() + (800 * (rep + 1)) - camera.getX());
                staticThing2.getImageView().setX(800 * rep - camera.getX());
                foe3.getImageView().setX(foe3.getOffsetXFrame() + (800 * rep) - camera.getX());
            }
            //----------------------------------------------------------------------------------------------------------

            //----------------------------------------------------------------------------------------------------------
            this.dt = time - prevTime;
            //----------------------------------------------------------------------------------------------------------

            // verification : hero doesn't hit a foe
            //----------------------------------------------------------------------------------------------------------
            if (hero1.getInvincible() == 0) {
                prevLifePoint = hero1.getLifePoint();
                if (hero1.getOffsetXFrame()%1600 <= 800) {
                    foe1.rectangle2DGetHitBox(hero1, foe1);
                    foe2.rectangle2DGetHitBox(hero1, foe2);
                }
                if (hero1.getOffsetXFrame()%1600 >= 800) {
                    foe3.rectangle2DGetHitBox(hero1, foe3);
                }
                if (prevLifePoint != hero1.getLifePoint()) {
                    hero1.setInvincible(1);
                }
            }

            // inputs from player
            //----------------------------------------------------------------------------------------------------------
            // Press S to Start the game
            // Press Space to Jump
            // Press G to Give up the game
            // Press R to Restart and to init all parameters
            //----------------------------------------------------------------------------------------------------------
            setOnKeyPressed((event2) -> {
                if (event2.getCode() == KeyCode.S)
                {System.out.println("start");
                    foe1.setOffsetXFrame(300);
                    foe2.setOffsetXFrame(600);
                    foe1.getImageView().setX(foe1.getOffsetXFrame());
                    foe2.getImageView().setX(foe2.getOffsetXFrame());
                    start.getImageView().setX(-1200);
                    restart.getImageView().setY(0);
                    hero1.setVx(5);
                    hero1.setAttitude(0);}
                if (event2.getCode() == KeyCode.SPACE)
                {System.out.println("Jump");
                    this.flagJump = 1;
                    if (hero1.getAttitude() == 0) {hero1.setAttitude(1);m += 0.2 * hero1.getVx()/5;}}
                if (event2.getCode() == KeyCode.G)
                {System.out.println("Restart");
                    hero1.setLifePoint(-1);}
                if (event2.getCode() == KeyCode.R && hero1.getLifePoint()<0){
                    this.flagJump = 0;
                    this.m = 8;
                    // images positions
                    //--------------------------------------------------------------------------------------------------
                    hero1.setLifePoint(hero1.getInitLifePoint());
                    start.getImageView().setX(0);
                    gameOver.getImageView().setX(-1200);
                    // hero update
                    //--------------------------------------------------------------------------------------------------
                    hero1.setVx(0);
                    hero1.setOffsetXFrame(100);
                    hero1.getImageView().setX(hero1.getOffsetXFrame());
                    hero1.setOffsetYFrame(245);
                    hero1.getImageView().setY(hero1.getOffsetYFrame());
                    hero1.getImageView().opacityProperty().setValue(1);
                    hero1.setLevel(0);
                    hero1.setInvincible(0);
                    hero1.setInvincibility(25000000);
                    //--------------------------------------------------------------------------------------------------
                    // staticThings update (foes + harts)
                    //--------------------------------------------------------------------------------------------------
                    hart1.setX(30); hart2.setX(30); hart3.setX(30);
                    this.rep=0;
                    this.prevRep=0;
                    //--------------------------------------------------------------------------------------------------
                    showMessage.setText("Press S to Start DBZRun");
                    showMessage.getText();
                }
            });
            //----------------------------------------------------------------------------------------------------------

            // display lives
            //----------------------------------------------------------------------------------------------------------
            if (hero1.getLifePoint()>=6) { hart3.displayHart(hero1,hart3);}
            if (hero1.getLifePoint()>=3 & hero1.getLifePoint()<=5) { hart3.setX(485);hart2.displayHart(hero1,hart2);}
            if (hero1.getLifePoint()>=0 & hero1.getLifePoint()<=2) { hart2.setX(485);hart1.displayHart(hero1,hart1);}
            if (hero1.getLifePoint()<0) { hart1.setX(485);};

            rectangleHart1 = new Rectangle2D(hart1.getX(), hart1.getY(), hart1.getSizeXWindow(), hart1.getSizeYWindow());
            rectangleHart2 = new Rectangle2D(hart2.getX(), hart2.getY(), hart2.getSizeXWindow(), hart2.getSizeYWindow());
            rectangleHart3 = new Rectangle2D(hart3.getX(), hart3.getY(), hart3.getSizeXWindow(), hart3.getSizeYWindow());
            hart1.getImageView().setViewport(rectangleHart1);
            hart2.getImageView().setViewport(rectangleHart2);
            hart3.getImageView().setViewport(rectangleHart3);
            //----------------------------------------------------------------------------------------------------------

            // instructions given during the game
            //----------------------------------------------------------------------------------------------------------
            if (hero1.getLifePoint()<0) {
                hero1.setVx(0);
                hero1.setAttitude(3);
                restart.getImageView().setY(-60); // hide restart image when it's game over
                gameOver.getImageView().setX(0); // show Game Over
                restartMessage.setText(" ");
                restartMessage.getText();
                showMessage.setText("Press R to Restart");
                showMessage.getText();
            }
            else {
                restartMessage.setText("Press G");
                restartMessage.getText();
                if(hero1.getVx()==0){
                    showMessage.setText("Press S to Start DBZRun");
                    showMessage.getText();
                }
                else if(hero1.getVx()!=0 & flagJump==0){
                    showMessage.setX(300);
                    showMessage.setY(200);
                    showMessage.setFont(new Font(25));
                    showMessage.setFill(Color.WHITE);
                    showMessage.setText("Press Space to Jump");
                    showMessage.getText();
                }
                else{
                    showMessage.setX(320);
                    showMessage.setY(380);
                    showMessage.setFont(new Font(15));
                    showMessage.setFill(Color.WHITE);
                    showMessage.setText(" ");
                    showMessage.getText();
                }
            }
            //----------------------------------------------------------------------------------------------------------

            // display hero
            //----------------------------------------------------------------------------------------------------------
            rectangle2D = new Rectangle2D(hero1.getX(), hero1.getY(), 85, 100);
            hero1.getImageView().setViewport(rectangle2D);
            //----------------------------------------------------------------------------------------------------------

            // jump
            //----------------------------------------------------------------------------------------------------------
            // hero jumps up
            if (hero1.getAttitude() == 1) {
                a = -hero1.getHeightJump()+ m * m;
                hero1.setGravity(a);
                hero1.jumpUp(hero1);
                if (m <=0) {
                    hero1.setGravity(a);
                    hero1.setAttitude(2);
                    m +=0.2 * hero1.getVx()/5;
                }
                m -= 0.2 * hero1.getVx()/5 ;;
            }
            // hero jumps down
            if (hero1.getAttitude() == 2) {
                a = -hero1.getHeightJump() + m * m;
                hero1.setGravity(a);
                hero1.jumpDown(hero1);
                m += 0.25 * hero1.getVx()/5;
                if (m >= 8) {
                    m = 8;
                    hero1.setAttitude(0);
                    hero1.setGravity(hero1.getInitGravity());
                    hero1.setOffsetYFrame(250);
                };
            }
            hero1.setGravity(hero1.getInitGravity());
            //----------------------------------------------------------------------------------------------------------

            // camera and hero classes update
            //----------------------------------------------------------------------------------------------------------
            camera.update(time, hero1);
            hero1.update(time, hero1, camera);
            //----------------------------------------------------------------------------------------------------------


            if (dt > 3e7) {
                // invincibility
                //------------------------------------------------------------------------------------------------------
                if (hero1.getInvincible()==1 && hero1.getLifePoint()>=0){
                    hero1.isInvincibility(hero1,(int)5e5);
                    System.out.println("lifePoint :"+" "+hero1.getLifePoint()%3+" "+hero1.getLifePoint());}
                //------------------------------------------------------------------------------------------------------

                // level+ -> increase speed & display level
                //------------------------------------------------------------------------------------------------------
                if (hero1.getOffsetXFrame()%2400 >= 2400- hero1.getVx()) {
                    hero1.setLevel(hero1.getLevel()+1);
                    hero1.setVx(hero1.getVx()+1);
                    System.out.println("Level :"+" "+(hero1.getVx()-5)+" "+hero1.getOffsetXFrame()%1600);
                }
                showLevel.setText("Level : "+ hero1.getLevel());
                //------------------------------------------------------------------------------------------------------

                // hero runs
                //------------------------------------------------------------------------------------------------------
                if (hero1.getAttitude()!=3) {
                    hero1.setOffsetXFrame((hero1.getOffsetXFrame()) + hero1.getVx());
                    prevTime = time;
                }
            }
            //----------------------------------------------------------------------------------------------------------
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}

