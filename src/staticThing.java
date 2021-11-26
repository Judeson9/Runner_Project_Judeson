/**----------------------------------------------------------------------------------
 -- Company: ENSEA Cergy
 -- Engineer: ANTHONY FERNANDO Judeson
 -- Last Update : 25.11.2021
 -- Project Name: Runner_Project
 -- Class Name: staticThing
 -- Class Methods : none
 -- Description: This class creates static things for our games like landscapes
 -- Parent class: none
 -- Additional Comments: none
 */

// imported libraries
//----------------------------------------------------------------------------------------------------------------------
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//----------------------------------------------------------------------------------------------------------------------

public class staticThing {

    // variables
    //------------------------------------------------------------------------------------------------------------------
    // position on the gameScene
    private double x; // staticThing object's origin in x
    private double y; // staticThing object's origin in y
    private ImageView imageView;
    //------------------------------------------------------------------------------------------------------------------

    // constructor
    //------------------------------------------------------------------------------------------------------------------
    public staticThing(String fileName, double x, double y){
        this.x = x;
        this.y = y;
        // take image and set positions
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
