package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite
{
    private Image image;
    private double positionX;
    private double positionY;    
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;
  
    public Sprite() {
	
	}
    
    
	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public double getPositionX() {
		return positionX;
	}


	public void setPosition(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}


	public double getPositionY() {
		return positionY;
	}

	public double getVelocityX() {
		return velocityX;
	}


	public void setVelocity(double velocityX, double velocityY) {
		this.velocityX = velocityX;
		this.velocityY = velocityY;
	}


	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public void update(double time)
    {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }
    public void render(GraphicsContext gc)
    {
        gc.drawImage( image, positionX, positionY , width, height);
    }
    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }
    public boolean intersects(Sprite s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }
}