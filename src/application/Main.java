package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
	    
	    gc.setFill(Color.GREEN);
	    gc.setStroke(Color.BLACK);
	    gc.setLineWidth(2);
	    Font theFont = Font.font("Calibri", FontWeight.BOLD, 78);
	    gc.setFont(theFont);
		
		final long startNanoTime = System.nanoTime();
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent e) {
				
				gc.clearRect(0, 0, 520, 520);
				gc.fillText(e.getCode().toString(),260,260);
				gc.strokeText(e.getCode().toString(),260,260);
			}
			
		});
		
		
		theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
