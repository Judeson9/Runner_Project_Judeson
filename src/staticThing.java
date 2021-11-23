import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {

    // variables
    //------------------------------------------------------------------------------------------------------------------
    private double x;
    private double y;
    private ImageView imageView;
    //------------------------------------------------------------------------------------------------------------------

    // constructor
    //------------------------------------------------------------------------------------------------------------------
    public staticThing(String fileName, double x, double y){
        this.x = x;
        this.y = y;
        // take the image and set the position
        this.imageView = new ImageView( new Image(fileName));
        this.imageView.setX(x);
        this.imageView.setY(y);
    }
    //------------------------------------------------------------------------------------------------------------------

    // getter
    //------------------------------------------------------------------------------------------------------------------
    public double getX() { return x; }
    public double getY() { return y; }
    public ImageView getImageView() { return imageView; }
    //------------------------------------------------------------------------------------------------------------------
}
