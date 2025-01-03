package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage theStage) {
		theStage.setTitle( "Timeline Example" );
	    Group root = new Group();
	    Scene theScene = new Scene( root );
	    theStage.setScene( theScene );
	    Canvas canvas = new Canvas( 512, 512 );
	    root.getChildren().add( canvas );
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	    Image earth = new Image( "earth.png" );
	    Image sun   = new Image( "sun.png" );
	    Image space = new Image( "space.jpeg" );
	    final long startNanoTime = System.nanoTime();
	    new AnimationTimer()
	    {
	        public void handle(long currentNanoTime)
	        {
	            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
	            System.out.println(t);
	            double x = 231 + 128 * Math.cos(t);
	            double y = 231 + 128 * Math.sin(t);
	            // background image clears canvas 
	            gc.clearRect(0,0,512,512);
	            gc.drawImage( space, 0, 0 ,512,512);
	            gc.drawImage( earth, x, y , 50, 50);
	            gc.drawImage( sun, 206, 206, 100 , 100 );
	            
	        }
	    }.start();
	    
	    theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
