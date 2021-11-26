/**----------------------------------------------------------------------------------
 -- Company: ENSEA Cergy
 -- Engineer: ANTHONY FERNANDO Judeson
 -- Last Update : 25.11.2021
 -- Project Name: Runner_Project
 -- Class Name: Camera
 -- Class Methods : toString()
                    / update(long time, Hero hero1)
 -- Description: This class creates the camera which follows our hero during the game.
 -- Parent class: none
 -- Additional Comments: none
 */

public class Camera {

    // variables
    //------------------------------------------------------------------------------------------------------------------
    private float x; // x position
    private float y; // y position
    //------------------------------------------------------------------------------------------------------------------

    // constructor
    //------------------------------------------------------------------------------------------------------------------
    public Camera(float x,float y){
        // camera init positions
        this.x = x;
        this.y = y;
    }
    //------------------------------------------------------------------------------------------------------------------

    // getter
    //------------------------------------------------------------------------------------------------------------------
    public float getX() { return x; }
    public float getY() { return y; }
    //------------------------------------------------------------------------------------------------------------------


    @Override
    /**
     * toString method : display x and y camera's positions
     */
    //------------------------------------------------------------------------------------------------------------------
    public String toString() { return this.x + "  " + this.y ;}
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Update method : updates the camera position every dt with the hero position.
     * The camera is set to have the hero on the position x=100 and y=250 on the scene.
     * @param time time from the gameScene's timer
     * @param hero1 our hero from gameScene
     */
    //------------------------------------------------------------------------------------------------------------------
    public void update(long time, Hero hero1){
        this.x = (float) hero1.getOffsetXFrame() - 100;
        this.y = (float) hero1.getOffsetYFrame() - 250;
    }
    //------------------------------------------------------------------------------------------------------------------
}
