package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class gui {

	public static void main(String[] args) {
		JFrame f= new JFrame("System store");
		
		int n= 5;
		JButton [] bt = new JButton[n];
		
		for(int i=0;i<n;i++) {
			
			JButton bt1 = new JButton("Button"+(i+1));
			bt1.setForeground(Color.blue);
			
			
		}
		f.add(bt[0],BorderLayout.NORTH);
		f.add(bt[0],BorderLayout.SOUTH);
		f.add(bt[0],BorderLayout.EAST);
		f.add(bt[0],BorderLayout.NORTH);
		f.add(bt[0],BorderLayout.CENTER);
		
		
		f.setBackground(Color.orange);
		f.setForeground(Color.red);
		
		
		JLabel lb1 = new JLabel("Ten class");
		lb1.setSize(100,40);
		lb1.setForeground(Color.green);
		
		JButton bt1 = new JButton("Click");
		bt1.setSize(100,40);
		bt1.setBackground(Color.yellow);
		bt1.setForeground(Color.green);
		bt1.setEnabled(false);
		
		
		f.setBackground(Color.yellow);
		f.getContentPane().setBackground(Color.red);
		f.add(lb1);
		f.add(bt1);
		
		f.setBounds(130,220,500,400);
		f.setVisible(true);
		System.out.println(f.getComponentCount());
				
		
	}
	
	}


