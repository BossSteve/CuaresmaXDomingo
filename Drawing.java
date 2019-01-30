import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Drawing extends JComponent{
	
	public int x = 20;
	public int y = 280;
	
	public int state = 0;

	public BufferedImage image;
	public BufferedImage BG_image;
	public URL resource = getClass().getResource("panda0.gif");
	public URL BG = getClass().getResource("bgimage.jpg");

	public Drawing(){
		try{
			image = ImageIO.read(resource);
			BG_image = ImageIO.read(BG);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void reloadImage(){
		
		if(state == 0){
			resource = getClass().getResource("panda10.gif");
		}
		else if(state == 1){
			resource = getClass().getResource("panda11.gif");
		}
		else if(state == 2){
			resource = getClass().getResource("panda12.gif");
		}
		else if(state == 3){
			resource = getClass().getResource("panda13.gif");
		}
		else if(state == 4){
			resource = getClass().getResource("panda14.gif");
		}
		else if(state == 5){
			resource = getClass().getResource("panda15.gif");
		}
		else if(state == 6){
			resource = getClass().getResource("panda16.gif");
			state = 0;
		}
		

		state++;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void moveUp(){
		y=y -40;
		reloadImage();
		repaint();
	}
	public void moveDown(){
		y=y +40;
		reloadImage();
		repaint();
	}
	public void moveLeft(){
		x=x -40;
		reloadImage();
		repaint();
	}
	public void moveRight(){
		x=x +40;
		reloadImage();
		repaint();
	}

	public void jumpAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 8; ctr++){
					
					if(ctr==7){
						resource = getClass().getResource("panda0.gif");
					}
					else{
						resource = getClass().getResource("panda2"+ctr+".gif");
					}

					try {
						image = ImageIO.read(resource);
					}
					catch(IOException e) {
						e.printStackTrace();
					}

					repaint();

					try {
						Thread.sleep(100);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
				}	
			}
		});
		thread1.start();
	}

	public void jump(){
		jumpAnimation();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(BG_image,0,0,2000,1000,this);
		g.drawImage(image,x,y,1500,1050,this);
	}
}