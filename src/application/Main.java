package application;
	
import animation.AnimatedImage;
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
		
		theStage.setTitle("Frame-Based Animation");
		
		Group root = new Group();
		Scene scene = new Scene(root);
		theStage.setScene(scene);
		
		Canvas canvas = new Canvas(520,520);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		root.getChildren().add(canvas);
		
		AnimatedImage ufo = new AnimatedImage();
		Image[] imageArray = new Image[6];
		
		imageArray[1] = new Image( "earth.png" );
		imageArray[2] = new Image( "space.jpeg" );
		imageArray[3] = new Image( "sun.png" );
		
		ufo.frames = imageArray;
		ufo.duration = 0.100;
		
		final long startNanoTime = System.nanoTime();
		
		
		new AnimationTimer(){
			
			public void handle(long currentNanoTime) {
				double t = (currentNanoTime - startNanoTime) / 1000000000.0;
				
				gc.drawImage( ufo.getFrame(t), 0, 25 ); 
				
				System.out.println(t);
				
			}
			
		}.start();
		
		theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
