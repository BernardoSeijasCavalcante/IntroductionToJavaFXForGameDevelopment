package application;
	
import java.util.ArrayList;
import java.util.Iterator;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage theStage) {
		
		theStage.setTitle( "Click the Target!" );
	    Group root = new Group();
	    Scene theScene = new Scene( root );
	    theStage.setScene( theScene );
	    
	    Canvas canvas = new Canvas( 500, 500 );
	    root.getChildren().add( canvas );
	    
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	    
	    Sprite briefcase = new Sprite();
	    briefcase.setImage(new Image("sun.png"));
	    briefcase.setHeight(50);
	    briefcase.setWidth(50);
	    briefcase.setPosition(200, 0);
	    ArrayList<Sprite> moneybagList = new ArrayList<Sprite>();
	    
	    for (int i = 0; i < 15; i++)
	    {
	        Sprite moneybag = new Sprite();
	    	moneybag.setImage(new Image("earth.png"));
	    	double px = 350 * Math.random() + 50;
	    	double py = 350 * Math.random() + 50;          
	    	moneybag.setPosition(px,py);
	    	moneybagList.add( moneybag );
	    }
	    
	    ArrayList<String> input = new ArrayList<String>();
	    IntValue score = new IntValue(0);
	    
	    theScene.setOnKeyPressed(
	            new EventHandler<KeyEvent>()
	            {
	                public void handle(KeyEvent e)
	                {
	                    String code = e.getCode().toString();
	                    // only add once... prevent duplicates 
	                    if ( !input.contains(code) )
	                        input.add( code );
	                }
	            });
	        theScene.setOnKeyReleased(
	            new EventHandler<KeyEvent>()
	            {
	                public void handle(KeyEvent e)
	                {
	                    String code = e.getCode().toString();
	                    input.remove( code );
	                }
	            });
	    
	    LongValue lastNanoTime = new LongValue(System.nanoTime());
	    new AnimationTimer()
	    {
	        public void handle(long currentNanoTime)
	        {
	        	// calculate time since last update. 
	    		double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
	    		lastNanoTime.value = currentNanoTime;
	    		
	    		// game logic 
	    		
	    		briefcase.setVelocity(0,0);
	    		if (input.contains("LEFT"))
	    			briefcase.setVelocity(-50,0);
	    		if (input.contains("RIGHT"))
	    			briefcase.setVelocity(50,0);
	    		if (input.contains("UP"))
	    			briefcase.setVelocity(0,-50);
	    		if (input.contains("DOWN"))
	    			briefcase.setVelocity(0,50);
	    			
	    		briefcase.update(elapsedTime);
	    		
	    		// collision detection 
	    		
	    		Iterator<Sprite> moneybagIter = moneybagList.iterator();
	    		while ( moneybagIter.hasNext() )
	    		{
	    			Sprite moneybag = moneybagIter.next();
	    			if ( briefcase.intersects(moneybag) )
	    			{
	    				moneybagIter.remove();
	    				score.value++;
	    			}
	    		}
	    		
	    		// render 
	    		
	    		gc.clearRect(0, 0, 512,512);
	    		briefcase.render( gc );
	    		
	    		for (Sprite moneybag : moneybagList ) {
	    			moneybag.setHeight(50);
	    			moneybag.setWidth(50);
	    			moneybag.render( gc );
	    		}
	    		String pointsText = "Cash: $" + (100 * score.value);
	    		gc.fillText( pointsText, 360, 36 );
	    		gc.strokeText( pointsText, 360, 36 );
	        }
	    }.start();
	    
	    theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
