package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage theStage) {
		theStage.setTitle( "Canvas Example" ); // Dá um título à janela
        
	    Group root = new Group(); // Cria um agrupamento para nodes
	    Scene theScene = new Scene( root );  //Instância a cena com o agrupamento como a raiz dos nodes 
	    theStage.setScene( theScene ); //Coloca a cena no palco
	        
	    Canvas canvas = new Canvas( 400, 300 ); //Instância o canvas para alocação de textos, imagens, formas e afins
	    root.getChildren().add( canvas ); //Adiciona o canvas como primeiro filho (nó ou node) da raiz
	        
	    GraphicsContext gc = canvas.getGraphicsContext2D(); //Instância um GraphicsContext para a criação e alocação de objetos no canvas. GraphicsContext é como um serviço que contém vários recursos gráficos
	        
	    gc.setFill( Color.RED );
	    gc.setStroke( Color.BLACK );
	    gc.setLineWidth(2);
	    Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
	    gc.setFont( theFont );
	    gc.fillText( "Hello, World!", 60, 50 );
	    gc.strokeText( "Hello, World!", 60, 50 );
	    
	    gc.setFill( Color.BLACK );
	    gc.setStroke( Color.RED );
	    gc.setLineWidth(2);
	    Font theFont2 = Font.font( "Calibri", FontWeight.BOLD, 36 );
	    gc.setFont( theFont2 );
	    gc.fillText( "Hello, Nothing!", 90, 250 );
	    gc.strokeText( "Hello, Nothing!", 90, 250 );
	    
	    Image earth = new Image( "earth.png" );
	    gc.drawImage(earth, 150, 100, 100, 100);
	    
	    theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
