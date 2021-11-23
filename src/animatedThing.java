// imported libraries
//----------------------------------------------------------------------------------------------------------------------
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//----------------------------------------------------------------------------------------------------------------------

public class animatedThing {

    // variables
    //------------------------------------------------------------------------------------------------------------------
    // origins on the animated thing image
    private double x;
    private double y;
    // size window of animated thing image
    private double sizeXWindow;
    private double sizeYWindow;
    // speed of animated thing
    private double Vx ;
    private double Vy ;
    // position of animated thing
    private double offsetXFrame;
    private double offsetYFrame;
    // gravity
    private double gravity;
    private double initGravity;
    // image view
    private ImageView imageView;
    private int attitude ; // 0 run - 1 jumpUp - 2 jumpDown - 3 nothing
    // variables for update method
    private double m = 0;
    private long dt = 0;
    private long prevTime = 0;
    //------------------------------------------------------------------------------------------------------------------

    // constructor
    //------------------------------------------------------------------------------------------------------------------
    public animatedThing(String fileName, double x, double y, double sizeXWindow, double sizeYWindow, double offsetXFrame, double offsetYFrame) {
        // image configuration
        // image's origins
        this.x = x;
        this.y = y;
        // window size to display
        this.sizeXWindow = sizeXWindow;
        this.sizeYWindow = sizeYWindow;
        // initiation
        this.Vx = 0;
        this.Vy = 0;
        this.initGravity = 50;
        this.gravity = this.initGravity;
        this.attitude = 3;
        this.offsetXFrame = offsetXFrame;
        this.offsetYFrame = offsetYFrame;
        // image view
        this.imageView = new ImageView(new Image(fileName));
        this.imageView.setX(offsetXFrame);
        this.imageView.setY(offsetYFrame);
        this.imageView.setViewport(new Rectangle2D(x,y,sizeXWindow,sizeYWindow));
    }
    //------------------------------------------------------------------------------------------------------------------

    // getter
    //------------------------------------------------------------------------------------------------------------------
    public double getX() { return x; }
    public double getY() { return y; }
    public ImageView getImageView() { return imageView; }
    public double getOffsetXFrame() { return offsetXFrame; }
    public double getOffsetYFrame() { return offsetYFrame; }
    public double getVx() { return Vx; }
    public double getVy() { return Vy; }
    public double getGravity() { return gravity; }
    public double getInitGravity() { return initGravity; }
    public int getAttitude() { return attitude; }
    public double getSizeXWindow() { return sizeXWindow; }
    public double getSizeYWindow() { return sizeYWindow; }
    //------------------------------------------------------------------------------------------------------------------

    // setter
    //------------------------------------------------------------------------------------------------------------------
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setOffsetYFrame(double offsetYFrame) { this.offsetYFrame = offsetYFrame; }
    public void setOffsetXFrame(double offsetXFrame) { this.offsetXFrame = offsetXFrame; }
    public void setAttitude(Integer attitude) { this.attitude = attitude; }
    public void setImageView(ImageView imageView) { this.imageView = imageView; }
    public void setVx(double vx) { Vx = vx; }
    public void setVy(double vy) { Vy = vy; }
    public void setGravity(double gravity) { this.gravity = gravity; }
    public void setSizeXWindow(double sizeYWindow) { this.sizeYWindow = sizeYWindow; }
    public void setSizeYWindow(double sizeYWindow) { this.sizeYWindow = sizeYWindow; }
    //------------------------------------------------------------------------------------------------------------------

    // update hero
    //------------------------------------------------------------------------------------------------------------------
    public void update(long time, Hero hero1,Camera camera){
        this.dt = time - this.prevTime;
        if(dt > 9e7) {
            // hero runs -> set the new x position
            (hero1.getImageView()).setX(hero1.getOffsetXFrame()-camera.getX());
            // run effect
            if (hero1.getAttitude() == 0) {
                this.x = this.m * 85;
                this.y = 0;
                this.m += 1;
                if (this.m == 6) {
                    this.m = 0;
                }
            }
            this.prevTime = time;
        }
    }
    //------------------------------------------------------------------------------------------------------------------

}
