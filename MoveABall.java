import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class MoveABall extends JFrame implements KeyListener{

	public Drawing draw;

	public MoveABall(){
		this.draw = new Drawing();

	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			draw.moveUp();
			System.out.print("Move Up");
		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			draw.moveDown();
			System.out.print("Move Down");
		}

		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			draw.moveLeft();
			System.out.print("Move Left");
		}

		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			draw.moveRight();
			System.out.print("Move Right");
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			draw.jump();
			System.out.print("Jump");
		}
	}
	public void keyTyped(KeyEvent e){
	
	}

	public void keyReleased(KeyEvent e){
	}

	public static void  main (String args[]){
		MoveABall myFrame = new MoveABall();
		myFrame.setSize(2000,1000);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		myFrame.add(myFrame.draw);
		myFrame.addKeyListener(myFrame);
		System.out.println("Playing Nonsense Ball...");
	}
}