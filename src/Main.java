import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Group()
// Image(String file directory)
// ImageView(Image ima)
// Camera(int X position, int Y position)
// GameScene(Group entire window, Camera cam)
// staticThing(String file directory, double image's origin in x,double image's origin in y)
// animatedThing(String fileName, double x, double y, double sizeXWindow, double sizeYWindow, double offsetXFrame, double offsetYFrame)
// Hero(String fileName, position on the rectangle -> {double x, double y} , double sizeXWindow, double sizeYWindow, position on gamescene -> {double offsetXFrame , double offsetYFrame})

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // setting title to the Stage
        primaryStage.setTitle("Hello world");
        // creating a group object
        Group root = new Group();
        //StackPane pane = new StackPane();
        // creating a scene object
        // Scene theScene = new Scene(pane, 600, 400, true);
        // adding scene to the stage
        GameScene gameScene = new GameScene(root);
        Camera camera = new Camera(100,400);
        //gameScene.setCamera();
        System.out.println(gameScene.getCamera());
        System.out.println(gameScene.getX());
        primaryStage.setScene(gameScene);

        // creating an image
        //-Image spriteSheet = new Image("C:\\Users\\judes\\IdeaProjects\\Runner_Project\\img\\desert.png");
        // setting the image view
        //-ImageView sprite = new ImageView(spriteSheet);
        // setting the position of the image
        // position on scene
        //-sprite.setX(0);
        //-sprite.setY(0);

        // define the rectangle to display
        // arguments take : double x, double y, double w, double h
        //-sprite.setViewport(new Rectangle2D(0,0,100,400));

        // add image to the scene
        // root.getChildren().addAll(sprite);

        // displaying the contents of the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

