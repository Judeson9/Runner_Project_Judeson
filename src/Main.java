/**----------------------------------------------------------------------------------
 -- Company: ENSEA Cergy
 -- Engineer: ANTHONY FERNANDO Judeson
 -- Last Update : 25.11.2021
 -- Project Name: Runner_Project
 -- Class Name: main
 -- Class Methods : none
 -- Description: Runner_Projet's main class
 -- All classes in this project:
 // Camera(float X position, float Y position)
 // staticThing(String file directory, double staticThing object's origin in x,double staticThing object's origin in y)
 // animatedThing(String fileName, double x, double y, double sizeXWindow, double sizeYWindow, double offsetXFrame, double offsetYFrame)
 // Hero(String fileName, position on the rectangle -> {double x, double y} , double sizeXWindow, double sizeYWindow, position on gameScene -> {double offsetXFrame , double offsetYFrame})
 // GameScene(Group entire window)
 // Foe(String fileName, double x, double y, double sizeXWindow, double sizeYWindow, double offsetXFrame, double offsetYFrame)
 -- Additional Comments: none
 */

// imported libraries
//----------------------------------------------------------------------------------------------------------------------
import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
//----------------------------------------------------------------------------------------------------------------------

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // setting title to the Stage
        primaryStage.setTitle("DBZRun");
        // creating a group object
        Group root = new Group();
        // creating a scene object;
        // adding scene to the stage
        GameScene gameScene = new GameScene(root);
        System.out.println(gameScene.getCamera());
        System.out.println(gameScene.getX());
        primaryStage.setScene(gameScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

