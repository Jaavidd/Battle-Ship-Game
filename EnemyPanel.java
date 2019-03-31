package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EnemyPanel extends JPanel{
	Random_Generator rand_gen = new Random_Generator();
	MyPanel panelLeft;
	GridLayout panelLayout;
	private JButton arr[][];
	int matrix_bot[][];
	MouseListener mouse;
	
	
	
	public EnemyPanel(MyPanel panelLeft) {
		this.panelLeft = panelLeft;
		mouse = new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			@Override
			public void mouseExited(MouseEvent e) {	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelLeft.cell_counter == 17) {
					System.out.println("hello");
				}
//				int row = 0;
//				int column = 0;
//				for (int i = 0; i < arr.length; i++) 
//					for (int j = 0; j < arr[0].length; j++) 
//						if(arr[i][j] == e.getSource()) {
//							row = i;
//							column = j;
//							break;	
//						}
			}
		};
		
		panelLayout = new GridLayout(10,10);
		arr = new JButton[10][10];
		matrix_bot = new int[10][10];
		setSize(new Dimension(800, 800));
		setVisible(true);
		setLayout(panelLayout);
		fill_BUTTONS();
		
		
	}
	
	private  void fill_BUTTONS() {
		JButton bt;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				bt = new JButton();
				bt.addMouseListener(mouse);
				arr[i][j] = bt;
				add(bt);
			}
		}
	}

}
